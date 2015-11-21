package businesslogic.statistic;

import businesslogicservice.statisticblservice.OrderInquiryBLService;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.OrderInquiryDataService;
import po.OrderPO;
import util.ResultMsg;
import vo.OrderVO;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/11/17.
 */
public class OrderInquiry implements OrderInquiryBLService {

    private OrderInquiryDataService dataService;

    private OrderVO orderVO;
    private OrderPO resultPO;
    private OrderVO resultVO;

    @Override
    public ResultMsg inputBarcode(String inputBarcode) {
        this.orderVO = new OrderVO(inputBarcode,null,null);
        ResultMsg resultMsg = this.orderVO.checkFormat();
        //订单号码格式正确
        if(resultMsg.isPass()){
            this.submitBarcode(inputBarcode);
            return new ResultMsg(true,"输入的订单号码格式正确!");
        }
        //订单号码格式错误
        else
            return resultMsg;
    }

    @Override
    public OrderVO submitBarcode(String inputBarcode) {
        try {
            this.resultPO = dataService.findOrder(inputBarcode);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        this.resultVO = new OrderVO(this.resultPO.getBarcode(),resultPO.getStateOfTransport(),
                resultPO.getHistory());
        return this.resultVO;
    }
}
