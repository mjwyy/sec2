package data.logisticdata;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import data.database.DatabaseManager;
import data.statisticdata.LogInsHelper;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.logisticdataservice.DeliveryNoteInputDataService;
import dataservice.statisticdataservice.BusinessDataModificationDataService;
import dataservice.statisticdataservice.OrderInquiryDataService;
import po.DeliveryNotePO;
import util.SendDocMsg;
import util.enums.DocState;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeliveryNoteInputData extends NoteInputData implements DeliveryNoteInputDataService {

    private OrderInquiryDataService orderDataService;

    public DeliveryNoteInputData(OrderInquiryDataService orderDataService)
            throws RemoteException {
        this.orderDataService = orderDataService;
    }

    @Override
    public SendDocMsg insert(DeliveryNotePO po) throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "insert into `Express`.`note_delivery` " +
                "( `volume`, `category`, `senderTeleNumber`, `receiverAddress`, " +
                "`packPrice`, `weight`, `receiverName`, `goodsNumber`," +
                " `receiverTeleNumber`, `senderAddress`, `senderName`, `name`, `barCode`) values " +
                "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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

            if(this.isNoteInDB( "note_delivery", "barCode", po.getBarCode() ))
                throw new InterruptWithExistedElementException("");
            else{
                statement.executeUpdate();
                sendDocMsg = this.afterInsert(po);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            sendDocMsg = new SendDocMsg(false, "寄件单提交失败!", 0, null);
        }
        //操作结束
        DatabaseManager.releaseConnection(connection, statement, null);
        return sendDocMsg;
    }

    /**
     * 向数据库加入寄件单之后的操作
     * 等待审批,添加物流信息,获取计算价格以及预计到达日期
     *
     * @param po 输入的寄件单
     * @return 总经理审批结果,价格以及预计到达日期
     *
     * @throws RemoteException
     * @throws ElementNotFoundException
     * @throws SQLException
     *
     * @see data.statisticdata.LogInsHelper
     */
    private SendDocMsg afterInsert(DeliveryNotePO po) throws RemoteException, ElementNotFoundException, SQLException {
        SendDocMsg sendDocMsg = null;
        String deliveryMan = po.getUserName();
        String orderInfo = "货物已被快递员 "+deliveryMan+" 签收";
        LogInsHelper.insertLog(po.getOrganization()+" 业务员 "+deliveryMan+
                "新增寄件单,单据编号:" + po.getBarCode());
        DocState docState = this.waitForCheck("note_delivery", "barCode", po.getBarCode());
        //审批通过
        if (docState == DocState.PASSED) {
            //追加修改物流信息
            orderDataService.insertOrderPO(po.getBarCode(),orderInfo,po.getPrice());
        } else {
            //审批没有通过
            String advice = this.getFailedAdvice("note_delivery",
                    "barCode", po.getBarCode());
            sendDocMsg = new SendDocMsg(false, advice, 0, null);
        }
        return sendDocMsg;
    }


}
