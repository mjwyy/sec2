package businesslogic.logistic;

import businesslogicservice.logisticblservice.DeliveryNoteInputBLService;
import connection.RemoteObjectGetter;
import dataservice.logisticdataservice.DeliveryNoteInputDataService;
import po.DeliveryNotePO;
import po.OrderPO;
import util.PresumedMsg;
import util.ResultMsg;
import util.sendDocMsg;
import vo.DeliveryNoteVO;

import java.rmi.RemoteException;
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
        if(formatCheck.isPass())
            this.submitSendDoc(sendDocVO);
        return formatCheck;
    }

    @Override
    public sendDocMsg submitSendDoc(DeliveryNoteVO sendDocVO) {
        double price = 0;
        String date = null;
        try {
            this.notePO = sendDocVO.toPO();
            this.dataService.insert(this.notePO);
            ArrayList<String> history = new ArrayList<String>();
            history.add("快递员已收件");
            this.orderPO = new OrderPO(sendDocVO.getBarCode(),"已收货",history);
            PresumedMsg presumedMsg = this.dataService.insertOrderPO(this.orderPO);
            price = presumedMsg.getPrice();
            date = presumedMsg.getDate();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return new sendDocMsg(true,"寄件单已成功提交!",price,date);
    }
}
