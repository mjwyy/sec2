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

    public String getFailedAdvice(String table, String keyName, String key){
        Connection connection = DatabaseManager.getConnection();
        String sql = "select advice from " + table +
                " where " + keyName + " = '" + key + "'";
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        String advice = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if (resultSet.next())
                advice = resultSet.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseManager.releaseConnection(connection, statement, resultSet);
        return advice;
    }

    public DocState waitForCheck(String table, String keyName, String key) {
        DocState result = DocState.UNCHECKED;
        while (true) {
            try {
                int state = 0;
                Connection connection = DatabaseManager.getConnection();
                String sql = "select isPassed from " + table +
                        " where " + keyName + " = '" + key + "'";
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next())
                    state = resultSet.getInt(1);
                DatabaseManager.releaseConnection(connection, statement, resultSet);
                result = DocState.getDocState(state);
            } catch (SQLException e) {
                e.printStackTrace();
            }
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

    public void updateOrder(ArrayList<BarcodeAndState> barcodeAndState, String newMesg){
        Connection connection = DatabaseManager.getConnection();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = df.format(new Date());
        String msg = (currentTime+","+newMesg+";");
        String barcode;
        GoodsState goodsState;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("");
            for(BarcodeAndState barcodeState : barcodeAndState){
                barcode = barcodeState.getBarcode();
                goodsState = barcodeState.getState();
                statement.executeUpdate("update `order` set `history` = concat(`history`, '" + msg + "'), " +
                        "`stateOfTransport` = '"+goodsState.toString()+"' where barcode = '"+barcode+"'");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseManager.releaseConnection(connection, statement, null);
    }

    public void updateOrder(String newMesg, ArrayList<String> barcodes) {
        Connection connection = DatabaseManager.getConnection();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = df.format(new Date());
        String msg = (currentTime+","+newMesg+";");
        PreparedStatement statement = null;
        try {
            for(String bar : barcodes){
                statement = connection.prepareStatement("");
                statement.executeUpdate("update `order` set `history` = concat(`history`, '" + msg + "') " +
                        " where `barcode` = '"+bar+"'");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseManager.releaseConnection(connection, statement, null);
    }

}
