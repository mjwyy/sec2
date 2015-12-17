package businesslogic.logistic;

import businesslogic.logistic.deliverystrategy.DeliveryInfo;
import businesslogic.logistic.deliverystrategy.PriceInfo;
import businesslogic.logistic.deliverystrategy.PriceStrategy;
import businesslogic.logistic.deliverystrategy.TimePresumeStrategy;
import businesslogicservice.logisticblservice.DeliveryNoteInputBLService;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.logisticdataservice.DeliveryNoteInputDataService;
import dataservice.statisticdataservice.BusinessDataModificationDataService;
import po.DeliveryNotePO;
import po.OrderPO;
import util.ResultMsg;
import util.SendDocMsg;
import util.enums.PackageType;
import util.enums.PriceType;
import vo.DeliveryNoteVO;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kylin on 15/11/10.
 */
public class DeliveryNoteInput implements DeliveryNoteInputBLService {

    private DeliveryNoteInputDataService dataService;
    private BusinessDataModificationDataService businessDataModificationDataService;

    private DeliveryNotePO notePO;
    private PriceStrategy priceStrategy;
    private TimePresumeStrategy timePresumeStrategy;

    private CityManager cityManager;

    public DeliveryNoteInput() {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService = (DeliveryNoteInputDataService) getter.getObjectByName("DeliveryNoteInputDataService");
        this.businessDataModificationDataService =
                (BusinessDataModificationDataService) getter.getObjectByName("BusinessDataModificationDataService");
        priceStrategy = new PriceStrategy();
        timePresumeStrategy = new TimePresumeStrategy();

    }

    @Override
    public ResultMsg inputSendDoc(DeliveryNoteVO sendDocVO) {
        ResultMsg format =  sendDocVO.checkFormat();
        if(format.isPass()){
            SendDocMsg sendDocMsg;
            //获取地址中的有效城市与距离
            try {
                String packPriceType = sendDocVO.getPackType().toString();
                double pricePerKG = businessDataModificationDataService.getPrice(PriceType.PricePerKg);
                double packagePrice = businessDataModificationDataService.getPrice(PriceType.getPriceType(packPriceType));
                String city1 = CityManager.findCity(sendDocVO.getSenderAddress());
                String city2 = CityManager.findCity(sendDocVO.getReceiverAddress());
                //防御式编程:如果城市在系统中不存在,返回错误信息
                if(city1 == null)
                    return new ResultMsg(false,"寄件人城市有误!");
                if(city2 == null)
                    return new ResultMsg(false,"收件人城市有误!");
                double distance = city1.equals(city2) ? 30 :
                        businessDataModificationDataService.getDistance(city1, city2);
                //接口参数封装类
                DeliveryInfo deliveryInfo = new DeliveryInfo(city1,city2,distance,sendDocVO.getWeight(),
                        sendDocVO.getVolume(),sendDocVO.getCategory(),sendDocVO.getPackType());
                PriceInfo priceInfo = new PriceInfo(pricePerKG,packagePrice);
                //委托:获取价格与预计日期
                double price = priceStrategy.getPrice(deliveryInfo,priceInfo);
                sendDocVO.setPrice(price);
                String presumedDate = timePresumeStrategy.getPresumedTime(deliveryInfo);
                sendDocMsg = new SendDocMsg(true, "寄件单已成功提交,等待审批", price, presumedDate);
            } catch (RemoteException e) {
                e.printStackTrace();
                return new ResultMsg(false,"网络异常,请重试!");
            } catch (ElementNotFoundException e) {
                e.printStackTrace();
                return new ResultMsg(false,"输入的信息不存在,请重试!");
            } catch (SQLException e) {
                e.printStackTrace();
                return new ResultMsg(false,"服务器数据库异常,请重试!");
            }
            return sendDocMsg;
        }else
            return format;
    }

    @Override
    public ResultMsg submitSendDoc(DeliveryNoteVO sendDocVO) {
        try {
            this.notePO = sendDocVO.toPO();
            this.notePO.setOrganization(sendDocVO.getOrganization());
            this.notePO.setUserName(sendDocVO.getUserName());
            this.notePO.setPrice(sendDocVO.getPrice());
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
