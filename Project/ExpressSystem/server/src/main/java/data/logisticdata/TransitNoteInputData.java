package data.logisticdata;

import data.database.DatabaseManager;
import data.statisticdata.LogInsertData;
import data.statisticdata.OrderInquiryData;
import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.TransitNoteInputDataService;
import po.TransitNotePO;
import util.BarcodesAndLocation;
import util.ResultMsg;
import util.enums.DocState;
import util.enums.GoodsState;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class TransitNoteInputData extends NoteInputData implements TransitNoteInputDataService {

    private LogInsertData logInsertData;
    private OrderInquiryData orderDataService;

    @Override
    public ResultMsg insert(TransitNotePO po) throws RemoteException, SQLException, ElementNotFoundException {
        String sql = "insert into `Express`.`note_transit`" +
                " ( `barcodes`, `transitDocNumber`, `supercargoMan`, `departurePlace`, " +
                "`transitType`, `date`, `desitination`, `transportNumber`)" +
                " values ( ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<BarcodesAndLocation> barcodesAndLocationArrayList = po.getBarcodes();
        for (BarcodesAndLocation barcodesAndLocation : barcodesAndLocationArrayList) {
            stringBuilder.append(barcodesAndLocation.getBarcode());
            stringBuilder.append(';');
        }
        statement.setString(1, stringBuilder.toString());
        statement.setString(2,po.getTransitDocNumber());
        statement.setString(3,po.getSupercargoMan());
        statement.setString(4,po.getDeparturePlace());
        statement.setString(5, po.getTransitType().toString());
        statement.setString(6, po.getDate());
        statement.setString(7, po.getDesitination());
        statement.setString(8, po.getTransportationNumber());
        statement.executeUpdate();
        statement.close();

        //记录系统日志
        logInsertData = new LogInsertData();
        logInsertData.insertSystemLog("中转中心业务员?新增中转单,单据编号:" + po.getTransitDocNumber());

        //等待总经理审批过程,反复查询
        DocState result = this.waitForCheck("note_transit",
                "transitDocNumber", po.getTransitDocNumber());
        ResultMsg resultMsg = new ResultMsg(false);
        //审批通过
        if (result == DocState.PASSED) {
            System.out.println("TransitNote is passed!");
            //追加修改物流信息
            orderDataService = new OrderInquiryData();
            for (BarcodesAndLocation barcodesAndLocation : barcodesAndLocationArrayList) {
                String barcode = barcodesAndLocation.getBarcode();
                orderDataService.updateOrder(barcode, GoodsState.COMPLETE,
                        "已从?中转中心发往"+po.getDesitination()+"中转中心");
            }
            resultMsg.setPass(true);
            //审批没有通过
        } else {
            System.out.println("TransitNote is failed!");
            String advice = this.getFailedAdvice("note_transit",
                    "transitDocNumber", po.getTransitDocNumber());
            resultMsg.setMessage(advice);
        }
        //操作结束
        DatabaseManager.releaseConnection(connection, statement, null);
        return resultMsg;
    }

}
