package data.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlHelper {

    /**
     * 执行一条SQL语句
     *
     * @param str String类型的SQL语句
     * @return 语句成功执行与否
     * @throws SQLException
     * @see Connection,PreparedStatement
     */
    public static boolean excSqlStatement(String str) throws SQLException {
        Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(str);
        int result = statement.executeUpdate();
        DatabaseManager.releaseConnection(connection, statement, null);
        return result > 0;
    }

}
