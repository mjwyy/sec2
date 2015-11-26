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

        statement.setString(1,po.getTranspotationNumber());
        statement.executeUpdate();
        statement.close();

        //记录系统日志
        logInsertData = new LogInsertData();
        logInsertData.insertSystemLog("营业厅业务员?新增营业厅到达单,单据编号:" + po.getTranspotationNumber());

        //等待总经理审批过程,反复查询
        DocState result = this.waitForCheck("note_arrival_on_transit",
                "transferNumber", po.getTranspotationNumber());
        ResultMsg resultMsg = new ResultMsg(false);
        //审批通过
        if (result == DocState.PASSED) {
            System.out.println("ArrivalNoteOnTransitPO is passed!");
            //追加修改物流信息
            orderDataService = new OrderInquiryData();
            orderDataService.updateOrder("",GoodsState.COMPLETE,"");
            resultMsg.setPass(true);
            //审批没有通过
        } else {
            System.out.println("ArrivalNoteOnTransitPO is failed!");
            String advice = this.getFailedAdvice("note_arrival_on_transit",
                    "transferNumber", po.getTranspotationNumber());
            resultMsg.setMessage(advice);
        }
        //操作结束
        DatabaseManager.releaseConnection(connection, statement, null);
        return resultMsg;
    }

}
