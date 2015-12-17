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

        }
        return result;
    }

    public void updateOrder(ArrayList<BarcodeAndState> barcodeAndState, String newMesg) throws ElementNotFoundException {
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

                if( !this.isBarcodeInDB(barcode) ){
                    DatabaseManager.releaseConnection(connection, statement, null);
                    throw new ElementNotFoundException();
                }

                statement.executeUpdate("update `order` set `history` = concat(`history`, '" + msg + "'), " +
                        "`stateOfTransport` = '"+goodsState.toString()+"' where barcode = '"+barcode+"'");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseManager.releaseConnection(connection, statement, null);
    }

    public void updateOrder(String newMesg, ArrayList<String> barcodes) throws ElementNotFoundException {
        Connection connection = DatabaseManager.getConnection();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = df.format(new Date());
        String msg = (currentTime+","+newMesg+";");
        PreparedStatement statement = null;

        try {
            for(String bar : barcodes){

                if( !this.isBarcodeInDB(bar) ){
                    DatabaseManager.releaseConnection(connection, statement, null);
                    throw new ElementNotFoundException();
                }

                statement = connection.prepareStatement("");
                statement.executeUpdate("update `order` set `history` = concat(`history`, '" + msg + "') " +
                        " where `barcode` = '"+bar+"'");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DatabaseManager.releaseConnection(connection, statement, null);
    }

    public boolean isBarcodeInDB(String barcode){
        Connection connection = DatabaseManager.getConnection();
        String sql = "select `stateOfTransport` from `order` where barcode = '"+barcode+"'";
        PreparedStatement statement;
        ResultSet set;
        boolean result = false;
        try {
            statement = connection.prepareStatement(sql);
            set = statement.executeQuery();
            result = set.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        DatabaseManager.releaseConnection(connection, statement, set);
        return result;
    }

    public boolean isBarcodeInDB(ArrayList<String> barcodes){
        boolean result = true;
        for(String barcode : barcodes){
            if( !this.isBarcodeInDB(barcode) ){
                return false;
            }
        }
        return result;
    }

    public boolean isBarcodeInDB(ArrayList<BarcodeAndState> barcodeAndState,boolean noUse){
        boolean result = true;
        for(BarcodeAndState barcodeState : barcodeAndState){
            String barcode = barcodeState.getBarcode();
            if( !this.isBarcodeInDB(barcode) ){
                return false;
            }
        }
        return result;
    }

    public boolean isNoteInDB(String table, String keyName, String key){
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
               return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DatabaseManager.releaseConnection(connection, statement, resultSet);
        return false;
    }

}
