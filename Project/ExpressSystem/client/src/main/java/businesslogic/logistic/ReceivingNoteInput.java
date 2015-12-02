package businesslogic.logistic;

import businesslogicservice.logisticblservice.ReceivingNoteInputBLService;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.ReceivingNoteInputDataService;
import po.ReceivingNotePO;
import util.ResultMsg;
import vo.ReceivingNoteVO;

import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * Created by kylin on 15/11/17.
 */
public class ReceivingNoteInput implements ReceivingNoteInputBLService {

    private ReceivingNotePO po;

    private ReceivingNoteInputDataService dataService;

    public ReceivingNoteInput() {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService = (ReceivingNoteInputDataService) getter.getObjectByName("ReceivingNoteInputDataService");
    }

    @Override
    public ResultMsg inputReceiveDoc(ReceivingNoteVO receiveDocVO) {
        return receiveDocVO.checkFormat();
    }

    @Override
    public ResultMsg submitSendDoc(ReceivingNoteVO receiveDocVO) {
        try {
            this.po = receiveDocVO.toPO();
            this.po.setOrganization(receiveDocVO.getOrganization());
            this.po.setUserName(receiveDocVO.getUserName());
            return this.dataService.insert(this.po);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"提交收件单失败!");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
            return new ResultMsg(false,"输入的条形码对应订单不存在,请重新输入");
        }
    }
}
