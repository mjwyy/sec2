package businesslogic.logistic;

import businesslogicservice.logisticblservice.DeliveryNoteInputBLService;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
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

    public DeliveryNoteInput(DeliveryNoteInputDataService dataService) {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService = (DeliveryNoteInputDataService) getter.getObjectByName("DeliveryNoteInputData");
    }

    @Override
    public ResultMsg inputSendDoc(DeliveryNoteVO sendDocVO) {
        ResultMsg formatCheck = sendDocVO.checkFormat();
        return formatCheck;
    }

    @Override
    public SendDocMsg submitSendDoc(DeliveryNoteVO sendDocVO) {
        double price = 0;
        String date = null;
        try {
            this.notePO = sendDocVO.toPO();
            SendDocMsg SendDocMsg = this.dataService.insert(this.notePO);
            ArrayList<String> history = new ArrayList<String>();
            history.add("快递员已收件");
            this.orderPO = new OrderPO(sendDocVO.getBarCode(), GoodsState.COMPLETE, history);
            price = SendDocMsg.getPrice();
            date = SendDocMsg.getPredectedDate();
        } catch (RemoteException e) {
            e.printStackTrace();
            return new SendDocMsg(false, e.getMessage(), 0, null);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
        return new SendDocMsg(true, "寄件单已成功提交!", price, date);
    }
}
