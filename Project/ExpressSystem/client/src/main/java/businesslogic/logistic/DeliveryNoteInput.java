package businesslogic.logistic;

import businesslogicservice.logisticblservice.DeliveryNoteInputBLService;
import dataservice.logisticdataservice.DeliveryNoteInputDataService;
import po.DeliveryNotePO;
import po.OrderPO;
import util.ResultMsg;
import util.sendDocMsg;
import vo.DeliveryNoteVO;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/11/10.
 */
public class DeliveryNoteInput implements DeliveryNoteInputBLService {

    private DeliveryNoteInputDataService dataService;

    private DeliveryNotePO notePO;
    private OrderPO orderPO;

//    private RemoteObjectGetter rmi;


    @Override
    public ResultMsg inputSendDoc(DeliveryNoteVO sendDocVO) {
        //格式检查待定,初步想法:正则表达式匹配,检查工具类静态方法
        boolean formatCheck = true;
        if(!formatCheck)
            return new ResultMsg(false,"格式错误!");
        this.submitSendDoc(sendDocVO);
        return new ResultMsg(true,"格式正确!");
    }

    @Override
    public sendDocMsg submitSendDoc(DeliveryNoteVO sendDocVO) {
        //时间和价格还没有数据接口提供,PO的数据不全
        double price = 0;
        String date = null;
        this.notePO = new DeliveryNotePO(sendDocVO.getSenderName(),sendDocVO.getSenderAddress(),sendDocVO.getSenderWorkPlace(),
                sendDocVO.getSenderTeleNumber(),sendDocVO.getNumber(),sendDocVO.getWeight(),sendDocVO.getVolume(),
                sendDocVO.getName(),sendDocVO.getCategory(),sendDocVO.getPackPrice(),sendDocVO.getBarCode());
        try {
            this.dataService.insert(this.notePO);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return new sendDocMsg(true,"寄件单已成功提交!",price,date);
    }
}
