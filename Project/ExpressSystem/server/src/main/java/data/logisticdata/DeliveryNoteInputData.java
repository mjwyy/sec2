package data.logisticdata;

import data.database.DatabaseManager;
import data.statisticdata.BusinessDataModificationData;
import data.statisticdata.LogInsertData;
import data.statisticdata.OrderInquiryData;
import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.DeliveryNoteInputDataService;
import po.DeliveryNotePO;
import util.BarcodeAndState;
import util.SendDocMsg;
import util.enums.DeliverCategory;
import util.enums.DocState;
import util.enums.GoodsState;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class DeliveryNoteInputData extends NoteInputData implements DeliveryNoteInputDataService {

    private LogInsertData logInsertData;
    private OrderInquiryData orderDataService;
    private BusinessDataModificationData businessDataModificationData;

    @Override
    public SendDocMsg insert(DeliveryNotePO po) throws RemoteException, SQLException, ElementNotFoundException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "insert into `Express`.`note_delivery` " +
                "( `volume`, `category`, `senderTeleNumber`, `receiverAddress`, " +
                "`packPrice`, `weight`, `userName`, `receiverName`, `goodsNumber`," +
                " `receiverTeleNumber`, `senderAddress`, `senderName`, `name`, `barCode`) values " +
                "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1, po.getVolume());
        statement.setString(2, po.getCategory().getStrCategory());
        statement.setString(3, po.getSenderTeleNumber());
        statement.setString(4, po.getReceiverAddress());
        statement.setDouble(5, po.getPackPrice());
        statement.setDouble(6, po.getWeight());
        statement.setString(7, "测试");
        statement.setString(8, po.getReceiverName());
        statement.setInt(9, po.getGoodsNumber());
        statement.setString(10, po.getReceiverTeleNumber());
        statement.setString(11, po.getSenderAddress());
        statement.setString(12, po.getSenderName());
        statement.setString(13, po.getName());
        statement.setString(14, po.getBarCode());
        int result = statement.executeUpdate();
        if (result < 0)
            throw new SQLException();
        //记录系统日志
        logInsertData = new LogInsertData();
        //TODO 获取业务员的信息
        logInsertData.insertSystemLog("营业厅业务员?新增寄件单,单据编号:" + po.getBarCode());

        //等待总经理审批过程,反复查询
        DocState docState = this.waitForCheck("note_delivery",
                "barCode", po.getBarCode());
        //审批通过
        double price = 0;
        String presumedDate = "";
        if (docState == DocState.PASSED) {
            System.out.println("DeliveryNote is passed!");
            //追加修改物流信息
            orderDataService = new OrderInquiryData();
            orderDataService.updateOrder(po.getBarCode(),GoodsState.COMPLETE,
                    "?营业厅已收件!");
            //TODO 策略模式
            //获取总价
            businessDataModificationData = new BusinessDataModificationData();
            String city1, city2;
            city1 = po.getSenderCity();
            city2 = po.getReceiverCity();
            double distance = businessDataModificationData.getDistance(city1, city2);
            double pricePerKG = distance / 1000 * 23;
            double weightPrice = pricePerKG * po.getWeight();
            if (po.getWeight() / po.getVolume() < 0.01) {
                double volumeWeight = po.getVolume() / 5000;
                double volumePrice = pricePerKG * volumeWeight;
                weightPrice = volumePrice > weightPrice ? volumePrice : weightPrice;
            }
            if (po.getCategory() == DeliverCategory.ECNOMIC)
                weightPrice = weightPrice * 18 / 23;
            else if (po.getCategory() == DeliverCategory.EXPRESS)
                weightPrice = weightPrice * 25 / 23;
            price = weightPrice + po.getPackPrice();
            //TODO 获取预计到达日期
            presumedDate = "";

        } else { //审批没有通过
            System.out.println("DeliveryNote is failed!");
            String advice = this.getFailedAdvice("note_delivery",
                    "barCode", po.getBarCode());
            return new SendDocMsg(false, advice, 0, null);
        }
        //操作结束
        DatabaseManager.releaseConnection(connection, statement, null);
        return new SendDocMsg(true, "寄件单已通过审批", price, presumedDate);
    }

    public ArrayList<DeliveryNotePO> getDeliveryNote() throws SQLException {
        ArrayList<DeliveryNotePO> result = new ArrayList<>();
        Connection connection = DatabaseManager.getConnection();
        String sql = "select * from `note_delivery` where isPassed = 0";
        PreparedStatement statement = connection.prepareStatement(sql);
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
            double packprice = resultSet.getDouble(12);
            String barcode = resultSet.getString(13);
            arrivalNoteOnServicePO = new DeliveryNotePO(senderName,senderAdd,senderTel,recName,
                    recADD,recTel,name,goodsNumber,weight,volume,DeliverCategory.getDeliverCategory(category),
                    packprice,barcode);
            result.add(arrivalNoteOnServicePO);
        }
        DatabaseManager.releaseConnection(connection, statement, resultSet);
        return result;
    }

}
