package businesslogic.statistic;

import businesslogicservice.statisticblservice.OrderInquiryBLService;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.OrderInquiryDataService;
import po.OrderPO;
import util.ResultMsg;
import vo.OrderVO;

import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * Created by kylin on 15/11/17.
 */
public class OrderInquiry implements OrderInquiryBLService {

    private OrderInquiryDataService dataService;

    private OrderVO orderVO;
    private OrderPO resultPO;
    private OrderVO resultVO;

    public OrderInquiry() {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService =
                (OrderInquiryDataService)getter.getObjectByName("OrderInquiryDataService");
    }

    @Override
    public ResultMsg inputBarcode(String inputBarcode) {
        this.orderVO = new OrderVO(inputBarcode,null,null);
        ResultMsg resultMsg = this.orderVO.checkFormat();
        return resultMsg;
    }

    @Override
    public OrderVO submitBarcode(String inputBarcode) throws ElementNotFoundException, RemoteException {
        try {
            this.resultPO = dataService.findOrder(inputBarcode);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RemoteException("网络异常:查询订单失败!");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
            throw new ElementNotFoundException("输入的订单信息不存在!");
        }
        this.resultVO = new OrderVO(this.resultPO.getBarcode(), this.resultPO.getGoodsState(),
                this.resultPO.getHistory());
        return this.resultVO;
    }
}
