<<<<<<< HEAD
import config.JdbcConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conn = new JdbcConnection().getJdbc();

    }

}


