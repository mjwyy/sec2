package businesslogic.logistic;

import businesslogicservice.logisticblservice.ReceivingNoteInputBLService;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
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
    public ResultMsg submitReceiveDoc(ReceivingNoteVO receivingNoteVO) {
        try {
            this.po = receivingNoteVO.toPO();
            this.po.setOrganization(receivingNoteVO.getOrganization());
            this.po.setUserName(receivingNoteVO.getUserName());
            return this.dataService.insert(this.po);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"提交收件单失败:网络异常!");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
            return new ResultMsg(false,"输入的条形码对应订单不存在,请重新输入");
        } catch (InterruptWithExistedElementException e) {
            e.printStackTrace();
            return new ResultMsg(false,"提交收件单失败:单据编号已存在!");
        }
    }
}
