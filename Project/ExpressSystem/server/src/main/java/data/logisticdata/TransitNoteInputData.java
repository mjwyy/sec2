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
            ArrayList<BarcodesAndLocation> barcodesAndLocationArrayList = po.getBarcodes();

            //存储货物的条形码与位置,位置包括4位数字
            //格式如下:1234567890,1,2,3,4;
            for (BarcodesAndLocation barcodesAndLocation : barcodesAndLocationArrayList) {
                stringBuilder.append(barcodesAndLocation.getBarcode());
                stringBuilder.append(',');
                stringBuilder.append(barcodesAndLocation.getSection());
                stringBuilder.append(',');
                stringBuilder.append(barcodesAndLocation.getLine());
                stringBuilder.append(',');
                stringBuilder.append(barcodesAndLocation.getRow());
                stringBuilder.append(',');
                stringBuilder.append(barcodesAndLocation.getNumber());
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

            statement.executeUpdate();
            return this.afterInsert(po);
        } catch (MySQLIntegrityConstraintViolationException e){
            throw new InterruptWithExistedElementException();
        } catch (SQLException e) {
            e.printStackTrace();
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
        ArrayList<BarcodesAndLocation> barcodesAndLocationArrayList = po.getBarcodes();

        if (result == DocState.PASSED) {
            System.out.println("TransitNote is passed!");
            ArrayList<String> bars = new ArrayList<>();
            for (BarcodesAndLocation barcodesAndLocation : barcodesAndLocationArrayList)
                bars.add(barcodesAndLocation.getBarcode());
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

    /**
     * 从数据库中存储的条形码与货物位置获得BarcodesAndLocation
     *
     * @param barcodes
     * @return
     */
    public ArrayList<BarcodesAndLocation> getBarcodesAndLocation(String barcodes){
        ArrayList<BarcodesAndLocation> result = new ArrayList<>();
        String[] split = barcodes.split(";");
        for(String line : split){
            String[] aline = line.split(",");
            result.add(new BarcodesAndLocation(aline[0],Integer.parseInt(aline[1]),Integer.parseInt(aline[2]),
                    Integer.parseInt(aline[3]),Integer.parseInt(aline[4])));
        }
        return result;
    }

}
