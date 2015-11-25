package data.statisticdata;
/**
 * @author XRiver
 * @date 2015/11/14
 */
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import po.LogEntryPO;
import dataservice.statisticdataservice.LogInquiryDataService;

public class LogInquiryData implements LogInquiryDataService{

    private Connection connection;

    public LogInquiryData(Connection con) {
        super();
        connection = con;
    }

    @Override
    public ArrayList<LogEntryPO> findLogEntries(String time, ArrayList<String> keyword)
            throws RemoteException, SQLException {
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
        PreparedStatement statement = connection.prepareStatement(sqlInsert);

        ResultSet resultSet = statement.executeQuery();

        ArrayList<LogEntryPO> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(new LogEntryPO(resultSet.getString("time"), resultSet.getString("log")));
        }
        statement.close();
        return result;
    }

}
