package data.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by kylin on 15/11/18.
 */
public class DatabaseConnection {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Express?" +
            "useUnicode=true&characterEncoding=UTF-8";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "861910";
    private Connection connection;

    public DatabaseConnection(){
        try {
            System.out.println("DataBase connecting...");
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            System.out.println("DataBase is connected!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() throws SQLException {
        if(connection !=null){
            connection.close();
            System.out.println("DataBase is closed!");
        }
    }

    public static void main(String[] args) {
        DatabaseConnection connection = new DatabaseConnection();
    }

}
