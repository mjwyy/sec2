package data.logisticdata;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import data.database.DatabaseManager;
import data.logisticdata.barcode.BarcodeUtil;
import data.statisticdata.LogInsHelper;
import data.statisticdata.LogInsertData;
import data.statisticdata.OrderInquiryData;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.logisticdataservice.TransitNoteInputDataService;
import po.TransitNotePO;
import util.BarcodesAndLocation;
import util.ResultMsg;
import util.enums.DocState;
import util.enums.GoodsState;
import util.enums.TransitType;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class TransitNoteInputData extends NoteInputData implements TransitNoteInputDataService {

    private BarcodeUtil barcodeUtil;

    public TransitNoteInputData() throws RemoteException {
        barcodeUtil = new BarcodeUtil();
    }

    @Override
    public ResultMsg insert(TransitNotePO po) throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException {
        String sql = "insert into `Express`.`note_transit`" +
                " ( `barcodes`, `transitDocNumber`, `supercargoMan`, `departurePlace`, " +
                "`transitType`, `date`, `desitination`, `transportNumber`)" +
                " values ( ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = null;
        ResultMsg resultMsg = new ResultMsg(false);

        try {
            statement = connection.prepareStatement(sql);
            StringBuilder stringBuilder = new StringBuilder();
            //存储货物的条形码
            ArrayList<String> barcodes = po.getBarcodes();
            for (String barcode : barcodes) {
                stringBuilder.append(barcode);
                stringBuilder.append(';');
            }
            statement.setString(1, stringBuilder.toString());
            statement.setString(2, po.getTransitDocNumber());
            statement.setString(3, po.getSupercargoMan());
            statement.setString(4, po.getDeparturePlace());
            statement.setString(5, po.getTransitType().toString());
            statement.setString(6, po.getDate());
            statement.setString(7, po.getDesitination());
            statement.setString(8, po.getTransportationNumber());

            if(this.isNoteInDB("note_transit","transitDocNumber", po.getTransitDocNumber()))
                throw new InterruptWithExistedElementException("");

            if(this.isBarcodeInDB(barcodes)){
                statement.executeUpdate();
                resultMsg = this.afterInsert(po);
            }else
                throw new ElementNotFoundException();

        } catch (SQLException e) {
            e.printStackTrace();
            return new ResultMsg(false,"数据库异常:新增中转单失败!");
        }

        DatabaseManager.releaseConnection(connection, statement, null);
        return resultMsg;
    }

    private ResultMsg afterInsert(TransitNotePO po) throws ElementNotFoundException {
        ResultMsg resultMsg = new ResultMsg(false);
        LogInsHelper.insertLog(po.getOrganization()+" 业务员 "+po.getUserName()+
                "新增中转单,单据编号:" + po.getTransitDocNumber());
        DocState result = this.waitForCheck("note_transit",
                "transitDocNumber", po.getTransitDocNumber());
        ArrayList<String> barcodes = po.getBarcodes();

        if (result == DocState.PASSED) {
            System.out.println("TransitNote is passed!");
            ArrayList<String> bars = new ArrayList<>();

            this.updateOrder("已从 "+po.getOrganization()+" 发往 "+po.getDesitination()+" 中转中心",bars);
            resultMsg.setPass(true);
            resultMsg.setMessage("中转单提交成功!");

        } else {
            System.out.println("TransitNote is failed!");
            String advice = this.getFailedAdvice("note_transit",
                    "transitDocNumber", po.getTransitDocNumber());
            resultMsg.setMessage(advice);
        }

        return resultMsg;
    }

}
