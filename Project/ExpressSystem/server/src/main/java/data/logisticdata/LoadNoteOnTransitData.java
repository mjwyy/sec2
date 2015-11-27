package data.logisticdata;

import data.database.DatabaseManager;
import data.statisticdata.LogInsertData;
import data.statisticdata.OrderInquiryData;
import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.LoadNoteOnTransitDataService;
import po.LoadNoteOnTransitPO;
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
public class LoadNoteOnTransitData extends NoteInputData implements LoadNoteOnTransitDataService {

    private LogInsertData logInsertData;
    private OrderInquiryData orderDataService;

    @Override
    public ResultMsg insert(LoadNoteOnTransitPO po) throws RemoteException, SQLException, ElementNotFoundException {

        String sql = "insert into `note_load_on_transit` ( `barcodes`, `destination`, `supercargoMan`," +
                " `guardMan`, `date`, `carNumber`, `hallNumber`, `transpotationNumber`)" +
                " values ( ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> barcodes = po.getBarcodes();
        for (String barcode : barcodes) {
            stringBuilder.append(barcode);
            stringBuilder.append(';');
        }
        statement.setString(1, stringBuilder.toString());
        statement.setString(2,po.getDestination());
        statement.setString(3,po.getSupercargoMan());
        statement.setString(4,po.getGuardMan());
        statement.setString(5,po.getDate());
        statement.setString(6,po.getCarNumber());
        statement.setString(7,po.getHallNumber());
        statement.setString(8,po.getTranspotationNumber());
        statement.executeUpdate();
        statement.close();

        //记录系统日志
        logInsertData = new LogInsertData();
        logInsertData.insertSystemLog("中转中心业务员?新增中转中心装车单,单据编号:" + po.getTranspotationNumber());

        //等待总经理审批过程,反复查询
        DocState result = this.waitForCheck("note_arrival_on_transit",
                "transpotationNumber", po.getTranspotationNumber());
        ResultMsg resultMsg = new ResultMsg(false);
        //审批通过
        if (result == DocState.PASSED) {
            System.out.println("LoadNoteOnTransit is passed!");
            //追加修改物流信息
            orderDataService = new OrderInquiryData();
            for (String barcode : barcodes) {
                orderDataService.updateOrder(barcode,GoodsState.COMPLETE,
                        "已从?中转中心装车,发往本地营业厅!");
            }
            resultMsg.setPass(true);
            //审批没有通过
        } else {
            System.out.println("LoadNoteOnTransit is failed!");
            String advice = this.getFailedAdvice("note_arrival_on_transit",
                    "transpotationNumber", po.getTranspotationNumber());
            resultMsg.setMessage(advice);
        }
        //操作结束
        DatabaseManager.releaseConnection(connection, statement, null);
        return resultMsg;
    }

}
