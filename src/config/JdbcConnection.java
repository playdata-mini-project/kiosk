package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    private final String url = "jdbc:mysql://192.168.0.128:3306/kiosk"+
            "?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
    private final String user = "kiosk";
    private final String password = "admin";
    public Connection getJdbc(){
        Connection conn;
        try {
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("test");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

}
