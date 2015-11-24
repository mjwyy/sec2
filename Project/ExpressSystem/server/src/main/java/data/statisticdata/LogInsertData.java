package data.statisticdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.database.DatabaseConnection;
import data.statisticdata.inte.LogInsertDataService;

public class LogInsertData implements LogInsertDataService {
	
	private Connection connection;
	
	public LogInsertData() {
		super();
        this.connection = new DatabaseConnection().getConnection();
	}
	
	@Override
	public void insertSystemLog(String log) throws SQLException {
		String currentTime = null;
		//TODO Needs a simple class that provides a string indicating time
//		currentTime = 
		String insertStat = "insert into SystemLog (time,log) values ('"+currentTime+"','" +log+ "')";
		PreparedStatement statement = connection.prepareStatement(insertStat);
		statement.executeUpdate();
	}

}
