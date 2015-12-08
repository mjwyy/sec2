package data.logisticdata;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import data.database.DatabaseManager;
import data.logisticdata.barcode.BarcodeUtil;
import data.statisticdata.LogInsHelper;
import data.statisticdata.LogInsertData;
import data.statisticdata.OrderInquiryData;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.logisticdataservice.LoadNoteOnTransitDataService;
import po.LoadNoteOnTransitPO;
import util.ResultMsg;
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
public class LoadNoteOnTransitData extends NoteInputData implements LoadNoteOnTransitDataService {

    private BarcodeUtil barcodeUtil;

    public LoadNoteOnTransitData() throws RemoteException {
        barcodeUtil = new BarcodeUtil();
    }

    @Override
    public ResultMsg insert(LoadNoteOnTransitPO po) throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException {

        String sql = "insert into `note_load_on_transit` ( `barcodes`, `destination`, `supercargoMan`," +
                " `guardMan`, `date`, `carNumber`, `hallNumber`, `transpotationNumber`)" +
                " values ( ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = null;
        ResultMsg resultMsg;

        try {
            statement = connection.prepareStatement(sql);
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
            resultMsg = this.afterInsert(po);

        } catch (MySQLIntegrityConstraintViolationException e){
            throw new InterruptWithExistedElementException();
        } catch (SQLException e) {
            e.printStackTrace();
            resultMsg = new ResultMsg(false,"中转中心装车单提交失败!");
        }

        //操作结束
        DatabaseManager.releaseConnection(connection, statement, null);
        return resultMsg;
    }

    private ResultMsg afterInsert(LoadNoteOnTransitPO po) throws ElementNotFoundException {
        ResultMsg resultMsg = new ResultMsg(false);
        LogInsHelper.insertLog(po.getOrganization()+" 业务员"+po.getUserName()+
                "新增中转中心装车单,单据编号:" + po.getTranspotationNumber());
        DocState result = this.waitForCheck("note_load_on_transit",
                "transpotationNumber", po.getTranspotationNumber());

        if (result == DocState.PASSED) {
            this.updateOrder( "已从"+po.getOrganization()+"装车发往本地营业厅",po.getBarcodes());
            resultMsg.setPass(true);
            resultMsg.setMessage("中转中心装车单提交成功!");

        } else {
            String advice = this.getFailedAdvice("note_load_on_transit",
                    "transpotationNumber", po.getTranspotationNumber());
            resultMsg.setMessage(advice);
        }
        return resultMsg;
    }

}
