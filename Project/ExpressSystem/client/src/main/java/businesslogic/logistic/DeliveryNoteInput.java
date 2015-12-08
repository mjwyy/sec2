package businesslogic.logistic;

import businesslogic.logistic.deliverystrategy.DeliveryInfo;
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
        SendDocMsg sendDocMsg = null;
        ResultMsg format =  sendDocVO.checkFormat();
        if(format.isPass()){
            //获取地址中的有效城市与距离
            ArrayList<String> cites = null;
            try {
                String packPriceType = sendDocVO.getPackType().toString();
                double pricePerKG = businessDataModificationDataService.getPrice(PriceType.PricePerKg);
                double packagePrice = businessDataModificationDataService.getPrice(PriceType.getPriceType(packPriceType));
                cites = businessDataModificationDataService.getAllCities();
                String city1 = this.findCity(cites,sendDocVO.getSenderAddress());
                String city2 = this.findCity(cites,sendDocVO.getReceiverAddress());
                double distance = 30;

                distance = businessDataModificationDataService.getDistance(city1, city2);
                DeliveryInfo deliveryInfo = new DeliveryInfo(city1,city2,distance,sendDocVO.getWeight(),
                        sendDocVO.getVolume(),sendDocVO.getCategory(),sendDocVO.getPackType());

                //获取价格与预计日期
                double price = priceStrategy.getPrice(deliveryInfo,pricePerKG,packagePrice);
                sendDocVO.setPrice(price);
                String presumedDate = timePresumeStrategy.getPresumedTime(deliveryInfo);
                sendDocMsg = new SendDocMsg(true, "寄件单已成功提交,等待审批", price, presumedDate);
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (ElementNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
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

    /**
     * 从一个详细的现实业务地址中获取有效的城市名称
     *
     * @param citys 公司业务已覆盖的所有城市
     * @param senderAddress 现实地址
     * @return 从地址中找到的城市(如果存在)
     */
    private String findCity(ArrayList<String> citys, String senderAddress) {
        for (String regex : citys) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(senderAddress);
            if (matcher.find())
                return regex;
        }
        return null;
    }

}
