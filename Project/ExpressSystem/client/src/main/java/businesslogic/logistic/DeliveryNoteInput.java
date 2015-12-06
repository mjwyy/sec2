package businesslogic.logistic;

import businesslogicservice.logisticblservice.DeliveryNoteInputBLService;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.logisticdataservice.DeliveryNoteInputDataService;
import po.DeliveryNotePO;
import po.OrderPO;
import util.ResultMsg;
import util.SendDocMsg;
import util.enums.GoodsState;
import vo.DeliveryNoteVO;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class DeliveryNoteInput implements DeliveryNoteInputBLService {

    private DeliveryNoteInputDataService dataService;

    private DeliveryNotePO notePO;
    private OrderPO orderPO;

    public DeliveryNoteInput() {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService = (DeliveryNoteInputDataService) getter.getObjectByName("DeliveryNoteInputDataService");
    }

    @Override
    public ResultMsg inputSendDoc(DeliveryNoteVO sendDocVO) {
        return sendDocVO.checkFormat();
    }

    @Override
    public SendDocMsg submitSendDoc(DeliveryNoteVO sendDocVO) {
        try {
            this.notePO = sendDocVO.toPO();
            this.notePO.setOrganization(sendDocVO.getOrganization());
            this.notePO.setUserName(sendDocVO.getUserName());
            return this.dataService.insert(this.notePO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new SendDocMsg(false, "提交寄件单失败!", 0, null);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
            return new SendDocMsg(false, "单据信息存在错误,提交寄件单失败!", 0, null);
        } catch (InterruptWithExistedElementException e) {
            e.printStackTrace();
            return new SendDocMsg(false, "提交寄件单失败!单据编号已存在!", 0, null);
        }
    }
}
