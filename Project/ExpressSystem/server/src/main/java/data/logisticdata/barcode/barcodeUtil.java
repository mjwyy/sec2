package data.logisticdata.barcode;

import data.database.DatabaseManager;
import util.BarcodeAndState;
import util.enums.GoodsState;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/12/1.
 */
public class BarcodeUtil {

    private static final String barSplit = ";";

    public String getDBbarsFromBarList(ArrayList<String> barcodes){
        StringBuilder stringBuilder = new StringBuilder();
        for (String barcode : barcodes) {
            stringBuilder.append(barcode);
            stringBuilder.append(barSplit);
        }
        return stringBuilder.toString();
    }

    public ArrayList<String> getBarcodesFromDBbars(String barcodes){
        String[] split = barcodes.split(barSplit);
        ArrayList<String> allBarcodes = new ArrayList<>();
        for(String str : split){
            if(!str.equals(""))
                allBarcodes.add(str);
        }
        return allBarcodes;
    }

    public String getDBbarsFromBarAndStateList(ArrayList<BarcodeAndState> barcodeAndStates){
        StringBuilder stringBuilder = new StringBuilder();
        for (BarcodeAndState history : barcodeAndStates) {
            stringBuilder.append(history.getBarcode());
            stringBuilder.append(barSplit);
        }
        return stringBuilder.toString();
    }

    public ArrayList<BarcodeAndState> getBarcodeAndStateFromDBbars(String barcodes){
        ArrayList<String> allBarcode = this.getBarcodesFromDBbars(barcodes);
        ArrayList<BarcodeAndState> barcodeAndStates = new ArrayList<>();
        for(String bar : allBarcode){
            barcodeAndStates.add(new BarcodeAndState(bar,this.getGoodsState(bar)));
        }
        return barcodeAndStates;
    }

    public GoodsState getGoodsState(String barcode){
        Connection connection = DatabaseManager.getConnection();
        String sql = "select `stateOfTransport` from `order` where `barcode` = '"+barcode+"'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                String state = resultSet.getString("stateOfTransport");
                DatabaseManager.releaseConnection(connection, statement, resultSet);
                return GoodsState.getGoodsState(state);
            }
            statement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseManager.releaseConnection(connection, statement, resultSet);
        return null;
    }

}
