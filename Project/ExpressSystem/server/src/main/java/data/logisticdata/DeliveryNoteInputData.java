package data.logisticdata;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import data.database.DatabaseManager;
import data.logisticdata.deliverystrategy.CityManager;
import data.logisticdata.deliverystrategy.PriceStrategy;
import data.logisticdata.deliverystrategy.TimePresumeStrategy;
import data.statisticdata.LogInsHelper;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.logisticdataservice.DeliveryNoteInputDataService;
import dataservice.statisticdataservice.BusinessDataModificationDataService;
import dataservice.statisticdataservice.OrderInquiryDataService;
import po.DeliveryNotePO;
import util.SendDocMsg;
import util.enums.DeliverCategory;
import util.enums.DocState;
import util.enums.PackageType;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeliveryNoteInputData extends NoteInputData implements DeliveryNoteInputDataService {

    private OrderInquiryDataService orderDataService;
    private BusinessDataModificationDataService businessDataModificationDataService;

    private PriceStrategy priceStrategy;
    private TimePresumeStrategy timePresumeStrategy;
    private CityManager cityManager;

    public DeliveryNoteInputData(OrderInquiryDataService orderDataService,
                                 BusinessDataModificationDataService businessDataModificationDataService)
            throws RemoteException {
        this.orderDataService = orderDataService;
        this.businessDataModificationDataService = businessDataModificationDataService;
        this.priceStrategy = new PriceStrategy(this.businessDataModificationDataService);
        this.timePresumeStrategy = new TimePresumeStrategy();
        this.cityManager = new CityManager();
    }

    @Override
    public SendDocMsg insert(DeliveryNotePO po) throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "insert into `Express`.`note_delivery` " +
                "( `volume`, `category`, `senderTeleNumber`, `receiverAddress`, " +
                "`packPrice`, `weight`, `userName`, `receiverName`, `goodsNumber`," +
                " `receiverTeleNumber`, `senderAddress`, `senderName`, `name`, `barCode`) values " +
                "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        SendDocMsg sendDocMsg;
        try {
            statement = connection.prepareStatement(sql);
            statement.setDouble(1, po.getVolume());
            statement.setString(2, po.getCategory().getStrCategory());
            statement.setString(3, po.getSenderTeleNumber());
            statement.setString(4, po.getReceiverAddress());
            statement.setString(5, po.getPackType().toString());
            statement.setDouble(6, po.getWeight());
            statement.setString(7, po.getReceiverName());
            statement.setInt(8, po.getGoodsNumber());
            statement.setString(9, po.getReceiverTeleNumber());
            statement.setString(10, po.getSenderAddress());
            statement.setString(11, po.getSenderName());
            statement.setString(12, po.getName());
            statement.setString(13, po.getBarCode());
            statement.executeUpdate();
            sendDocMsg =  this.afterInsert(po);
        } catch (MySQLIntegrityConstraintViolationException e){
            throw new InterruptWithExistedElementException();
        } catch (SQLException e) {
            e.printStackTrace();
            sendDocMsg = new SendDocMsg(false, "寄件单提交失败!", 0, null);
        }
        //操作结束
        DatabaseManager.releaseConnection(connection, statement, null);
        return sendDocMsg;
    }

    private SendDocMsg afterInsert(DeliveryNotePO po) throws RemoteException, ElementNotFoundException, SQLException {
        SendDocMsg sendDocMsg;
        String deliveryMan = po.getUserName();
        String orderInfo = "货物已被快递员 "+deliveryMan+" 签收;";
        LogInsHelper.insertLog(po.getOrganization()+" 业务员 "+deliveryMan+
                "新增寄件单,单据编号:" + po.getBarCode());
        DocState docState = this.waitForCheck("note_delivery", "barCode", po.getBarCode());

        //审批通过
        if (docState == DocState.PASSED) {
            //追加修改物流信息
            orderDataService.insertOrderPO(po.getBarCode(),orderInfo);
            //获取地址中的有效城市名称
            ArrayList<String> cites = businessDataModificationDataService.getAllCities();
            String city1 = cityManager.findCity(cites,po.getSenderAddress());
            String city2 = cityManager.findCity(cites,po.getReceiverAddress());

            //获取价格与预计日期
            double price = priceStrategy.getPrice(city1,city2,po.getWeight(),
                    po.getVolume(),po.getCategory(),po.getPackType());
            String presumedDate = timePresumeStrategy.getPresumedTime(city1,city2,po.getCategory());

            sendDocMsg = new SendDocMsg(true,"寄件单已成功提交!",price,presumedDate);
        } else {
            //审批没有通过
            String advice = this.getFailedAdvice("note_delivery",
                    "barCode", po.getBarCode());
            sendDocMsg = new SendDocMsg(false, advice, 0, null);
        }
        return sendDocMsg;
    }

    @Override
    public ArrayList<DeliveryNotePO> getDeliveryNote() throws RemoteException {
        ArrayList<DeliveryNotePO> result = new ArrayList<>();
        Connection connection = DatabaseManager.getConnection();
        String sql = "select * from `note_delivery` where isPassed = 0";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            DeliveryNotePO arrivalNoteOnServicePO;

            while(resultSet.next()){
                String senderName = resultSet.getString(1);
                String senderAdd = resultSet.getString(2);
                String senderTel = resultSet.getString(3);
                String recName = resultSet.getString(4);
                String recADD = resultSet.getString(5);
                String recTel = resultSet.getString(6);
                String name = resultSet.getString(7);
                int goodsNumber = resultSet.getInt(8);
                int weight = resultSet.getInt(9);
                int volume = resultSet.getInt(10);
                String category = resultSet.getString(11);
                String stringType = resultSet.getString(12);
                PackageType packageType = PackageType.getPackageType(stringType);
                String barcode = resultSet.getString(13);

                arrivalNoteOnServicePO = new DeliveryNotePO(senderName,senderAdd,senderTel,recName,
                        recADD,recTel,name,goodsNumber,weight,volume,DeliverCategory.getDeliverCategory(category),
                        packageType,barcode);
                result.add(arrivalNoteOnServicePO);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseManager.releaseConnection(connection, statement, null);
        return result;
    }

}
