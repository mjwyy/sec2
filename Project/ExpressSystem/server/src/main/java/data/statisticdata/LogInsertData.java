package data.statisticdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import data.database.DatabaseManager;
import data.statisticdata.inte.LogInsertDataService;

public class LogInsertData extends UnicastRemoteObject implements LogInsertDataService {

	private Connection connection;
	
	public LogInsertData() throws RemoteException {
		super();
        this.connection = DatabaseManager.getConnection();
    }
	
	@Override
	public void insertSystemLog(String log) throws SQLException {
        String currentTime;
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        currentTime = df.format(new Date());
        String insertStat = "insert into SystemLog (time,log) values ('"+currentTime+"','" +log+ "')";
		PreparedStatement statement = connection.prepareStatement(insertStat);
		statement.executeUpdate();
	}

}
