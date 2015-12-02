package data.logisticdata;

import data.database.DatabaseManager;
import data.logisticdata.barcode.BarcodeUtil;
import data.statisticdata.LogInsHelper;
import data.statisticdata.LogInsertData;
import data.statisticdata.OrderInquiryData;
import data.statisticdata.inte.LogInsertDataService;
import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.LoadNoteOnServiceDataService;
import dataservice.statisticdataservice.OrderInquiryDataService;
import po.LoadNoteOnServicePO;
import util.BarcodeAndState;
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
public class LoadNoteOnServiceData extends NoteInputData implements LoadNoteOnServiceDataService {

    private BarcodeUtil barcodeUtil;

    public LoadNoteOnServiceData() throws RemoteException {
        barcodeUtil = new BarcodeUtil();
    }

    @Override
    public ResultMsg insert(LoadNoteOnServicePO po) throws RemoteException, ElementNotFoundException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "insert into `note_load_on_service` ( `barcodes`, `destination`, `supercargoMan`, " +
                "`guardMan`, `date`, `carNumber`, `hallNumber`, `transpotationNumber`) " +
                "values ( ?, ?, ?, ?, ?, ?, ?, ?)";
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
        } catch (SQLException e) {
            e.printStackTrace();
            resultMsg = new ResultMsg(false,"提交营业厅装车单失败!");
        }

        //操作结束
        DatabaseManager.releaseConnection(connection, statement, null);
        return resultMsg;
    }

    private ResultMsg afterInsert(LoadNoteOnServicePO po) throws ElementNotFoundException {
        ResultMsg resultMsg = new ResultMsg(false);
        LogInsHelper.insertLog("营业厅业务员"+po.getUserName()+"新增营业厅装车单,单据编号:" + po.getTranspotationNumber());
        DocState result = this.waitForCheck("note_load_on_service",
                "transpotationNumber", po.getTranspotationNumber());

        if (result == DocState.PASSED) {
            System.out.println("ArrivalNoteOnTransitPO is passed!");
            this.updateOrder("已到达"+po.getOrganization(),po.getBarcodes());
            resultMsg.setPass(true);
            resultMsg.setMessage("营业厅装车单提交成功!");

        } else {
            System.out.println("ArrivalNoteOnTransitPO is failed!");
            String advice = this.getFailedAdvice("note_load_on_service",
                    "transpotationNumber", po.getTranspotationNumber());
            resultMsg.setMessage(advice);
        }
        return resultMsg;
    }

    @Override
    public ArrayList<LoadNoteOnServicePO> getLoadNoteOnService() throws RemoteException {
        ArrayList<LoadNoteOnServicePO> result = new ArrayList<>();
        Connection connection = DatabaseManager.getConnection();
        String sql = "select * from `note_load_on_service` where isPassed = 0";
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            LoadNoteOnServicePO arrivalNoteOnServicePO;

            while(resultSet.next()){
                String date = resultSet.getString(1);
                String hallNumber = resultSet.getString(2);
                String transNumber = resultSet.getString(3);
                String des = resultSet.getString(4);
                String car = resultSet.getString(5);
                String guard = resultSet.getString(6);
                String supercargo = resultSet.getString(7);
                String barcodes = resultSet.getString(8);
                arrivalNoteOnServicePO = new LoadNoteOnServicePO(date,hallNumber,transNumber,des,car,
                        guard,supercargo,barcodeUtil.getBarcodesFromDBbars(barcodes));
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
