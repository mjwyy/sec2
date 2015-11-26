package data.logisticdata;

import data.database.DatabaseManager;
import util.enums.DocState;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by kylin on 15/11/26.
 */
public class NoteInputData {

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

}
