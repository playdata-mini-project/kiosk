package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    public Connection getJdbc(){
        Connection conn;
        try {
            conn = DriverManager.getConnection(DbInfo.URL,DbInfo.USER,DbInfo.PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

}
