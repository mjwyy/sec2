package businesslogic.logistic;

import businesslogicservice.logisticblservice.ReceivingNoteInputBLService;
import connection.RemoteObjectGetter;
import dataservice.logisticdataservice.ReceivingNoteInputDataService;
import po.ReceivingNotePO;
import util.ResultMsg;
import vo.ReceivingNoteVO;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/11/17.
 */
public class ReceivingNoteInput implements ReceivingNoteInputBLService {

    private ReceivingNotePO po;

    private ReceivingNoteInputDataService dataService;

    public ReceivingNoteInput(ReceivingNotePO po) {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService = (ReceivingNoteInputDataService) getter.getObjectByName("ReceivingNoteInputDataService");
    }

    @Override
    public ResultMsg inputReceiveDoc(ReceivingNoteVO receiveDocVO) {
        ResultMsg formatCheck = receiveDocVO.checkFormat();
        if(formatCheck.isPass())
            this.submitSendDoc(receiveDocVO);
        return formatCheck;
    }

    @Override
    public ResultMsg submitSendDoc(ReceivingNoteVO receiveDocVO) {
        try {
            this.po = receiveDocVO.toPO();
            this.dataService.insert(this.po);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return new ResultMsg(true,"收件单已提交!");
    }
}
