package data.logisticdata;

import data.database.DatabaseManager;
import data.database.SqlHelper;
import dataservice.exception.ElementNotFoundException;
import util.BarcodeAndState;
import util.enums.DocState;
import util.enums.GoodsState;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kylin on 15/11/26.
 */
public class NoteInputData extends UnicastRemoteObject implements Remote, Serializable {

    public NoteInputData() throws RemoteException {
        super();
    }

    public String getFailedAdvice(String table, String keyName, String key) throws SQLException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "select advice from " + table +
                " where " + keyName + " = '" + key + "'";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        String advice = "";
        if (resultSet.next())
            advice = resultSet.getString(1);
        DatabaseManager.releaseConnection(connection, statement, resultSet);
        return advice;
    }

    private DocState checkNoteState(String table, String keyName, String key) throws SQLException {
        Connection connection = DatabaseManager.getConnection();
        int result = 0;
        String sql = "select isPassed from " + table +
                " where " + keyName + " = '" + key + "'";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next())
            result = resultSet.getInt(1);
        DatabaseManager.releaseConnection(connection, statement, resultSet);
        return DocState.getDocState(result);
    }

    public DocState waitForCheck(String table, String keyName, String key) throws SQLException {
        DocState result;
        while (true) {
            result = this.checkNoteState(table, keyName, key);
            //单据被审批了
            if (!(result == DocState.UNCHECKED))
                break;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("note is waiting for check...");
        }
        return result;
    }

    public GoodsState getGoodsState(String barcode) throws SQLException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "select `stateOfTransport` from `order` where `barcode` = '"+barcode+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            String state = resultSet.getString("stateOfTransport");
            DatabaseManager.releaseConnection(connection, statement, resultSet);
            return GoodsState.getGoodsState(state);
        }
        else{
            DatabaseManager.releaseConnection(connection, statement, resultSet);
            return null;
        }
    }

    public void updateOrder(ArrayList<BarcodeAndState> barcodeAndState, String newMesg) throws SQLException {
        Connection connection = DatabaseManager.getConnection();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = df.format(new Date());
        String msg = (currentTime+","+newMesg+";");
        String barcode;
        GoodsState goodsState;
        PreparedStatement statement = connection.prepareStatement("");
        for(BarcodeAndState barcodeState : barcodeAndState){
            barcode = barcodeState.getBarcode();
            goodsState = barcodeState.getState();
            statement.executeUpdate("update `order` set `history` = concat(`history`, '" + msg + "'), " +
                    "`stateOfTransport` = '"+goodsState.toString()+"' where barcode = '"+barcode+"'");
        }
        DatabaseManager.releaseConnection(connection, statement, null);
    }

    public void updateOrder(String newMesg, ArrayList<String> barcodes) throws SQLException {
        Connection connection = DatabaseManager.getConnection();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = df.format(new Date());
        String msg = (currentTime+","+newMesg+";");
        PreparedStatement statement = connection.prepareStatement("");
        for(String bar : barcodes){
            statement.executeUpdate("update `order` set `history` = concat(`history`, '" + msg + "') " +
                    " where `barcode` = '"+bar+"'");
        }
        DatabaseManager.releaseConnection(connection, statement, null);
    }

    public static void main(String[] args) throws RemoteException, SQLException {
        NoteInputData data = new NoteInputData();
        ArrayList<String> barcodes = new ArrayList<>();
        barcodes.add("1234567891");
        barcodes.add("1234567892");
        barcodes.add("1234567890");
//        data.updateOrder("test2",barcodes);
        ArrayList<BarcodeAndState> barcodeAndState = new ArrayList<>();
        barcodeAndState.add(new BarcodeAndState("1234567891",GoodsState.COMPLETE));
        barcodeAndState.add(new BarcodeAndState("1234567892",GoodsState.DAMAGED));
        barcodeAndState.add(new BarcodeAndState("1234567890",GoodsState.LOST));
        data.updateOrder(barcodeAndState,"aaa");
    }

}
