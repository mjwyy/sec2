package data.statisticdata;
/**
 * @author XRiver
 * @date 2015/11/14
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import data.database.DatabaseManager;
import data.infodata.UserInfoHelper;
import po.LogEntryPO;
import dataservice.statisticdataservice.LogInquiryDataService;
import util.RuntimeUserInfo;

public class LogInquiryData extends UnicastRemoteObject implements LogInquiryDataService{

    public LogInquiryData() throws RemoteException {
        super();
    }
    @Override
    public ArrayList<LogEntryPO> findLogEntries(String time, ArrayList<String> keyword)
            throws RemoteException {
        Connection connection = DatabaseManager.getConnection();
        //Constructing sql statement
        StringBuilder sb = new StringBuilder();
        sb.append("select time,log from SystemLog where ");
        if (time != null) {
            sb.append("time LIKE '%" + time + "%' AND ");
        }
        if (keyword.size() > 0) {
            sb.append("(");
            Iterator<String> it = keyword.iterator();
            while (it.hasNext()) {
                sb.append("log LIKE '%" + it.next() + "%'");
                if (it.hasNext()) sb.append(" OR ");
            }
            sb.append(")");
        }

        String sqlInsert = sb.toString();
        PreparedStatement statement = null;
        ArrayList<LogEntryPO> result = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sqlInsert);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(new LogEntryPO(resultSet.getString("time"), resultSet.getString("log")));
            }
            statement.close();
            LogInsHelper.insertLog("用户:"+ RuntimeUserInfo.getNum()+"查询系统日志");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
