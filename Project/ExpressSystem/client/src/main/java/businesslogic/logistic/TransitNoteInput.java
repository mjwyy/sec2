package businesslogic.logistic;

import businesslogicservice.logisticblservice.TransitNoteInputBLService;
import connection.RemoteObjectGetter;
import dataservice.logisticdataservice.TransitNoteInputDataService;
import po.TransitNotePO;
import util.ResultMsg;
import vo.TransitNoteOnTransitVO;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/11/17.
 */
public class TransitNoteInput implements TransitNoteInputBLService {

    private TransitNoteInputDataService dataService;

    private TransitNotePO po;

    public TransitNoteInput(TransitNoteInputDataService dataService) {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService = (TransitNoteInputDataService) getter.getObjectByName("TransitNoteInputDataService");
    }

    @Override
    public ResultMsg inputCenterTransitDoc(TransitNoteOnTransitVO centerTransitDocVO) {
        ResultMsg formatCheck = centerTransitDocVO.checkFormat();
        if(formatCheck.isPass())
            this.submitCenterTransitDoc(centerTransitDocVO);
        return formatCheck;
    }

    @Override
    public ResultMsg submitCenterTransitDoc(TransitNoteOnTransitVO centerTransitDocVO) {

        try {
            this.po = centerTransitDocVO.toPO();
            this.dataService.insert(this.po);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return new ResultMsg(true,"中转单已提交!");
    }
}
