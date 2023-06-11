package utility;

import config.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InitDb {

    List<String> queryList = new ArrayList<>();
    public void initDb(){

        setDatabase();
        createTables();
        insertData();

        Connection conn = new JdbcConnection().getJdbc();
        PreparedStatement psmt = null;

        for (String query : queryList) {
            try {
                psmt = conn.prepareStatement(query);
                psmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private void setDatabase(){

        queryList.add(DROP_DATABASE);
        queryList.add(CREATE_DATABASE);
        queryList.add(USE_DATABASE);
    }
    private void createTables(){

        queryList.add(CREATE_CATEGORY_TABLE);
        queryList.add(CREATE_PRODUCT_TABLE);
        queryList.add(CREATE_USER_TABLE);
        queryList.add(CREATE_ORDER_HISTORY_TABLE);
        queryList.add(CREATE_ORDER_HISTORY_DETAIL_TABLE);
    }
    public void insertData(){

        queryList.add(USER1);
        queryList.add(USER2);

        queryList.add(CATEGORY1);
        queryList.add(CATEGORY2);
        queryList.add(CATEGORY3);

        queryList.add(PRODUCT1);
        queryList.add(PRODUCT2);
        queryList.add(PRODUCT3);
        queryList.add(PRODUCT4);
        queryList.add(PRODUCT5);
        queryList.add(PRODUCT6);
    }
    private final String DROP_DATABASE = "DROP DATABASE PLAYDATA";
    private final String CREATE_DATABASE = "CREATE DATABASE PLAYDATA";
    private final String USE_DATABASE = "USE PLAYDATA";
    private final String USER1 =
            "INSERT INTO USER(NAME, PASSWORD, ROLE) " +
                    "VALUES ('red', '1111', 'admin')";
    private final String USER2 =
            "INSERT INTO USER(NAME, PASSWORD, ROLE) " +
                    "VALUES ('blue', '2222', 'customer')";
    private final String CATEGORY1 =
            "INSERT INTO CATEGORY(NAME) " +
                    "VALUES ('커피')";
    private final String CATEGORY2 =
            "INSERT INTO CATEGORY(NAME)" +
                    "VALUES ('티')";
    private final String CATEGORY3 =
            "INSERT INTO CATEGORY(NAME) " +
                    "VALUES ('스무디')";
    private final String PRODUCT1 =
            "INSERT INTO PRODUCT(NAME, MAKE_TIME, CATEGORY_ID, PRICE, QUANTITY) " +
                    "VALUES ('아메리카노', 10, 1, 2000, 100)";
    private final String PRODUCT2 =
            "INSERT INTO PRODUCT(NAME, MAKE_TIME, CATEGORY_ID, PRICE, QUANTITY) " +
                    "VALUES ('라떼', 20, 1, 2500, 20)";
    private final String PRODUCT3 =
            "INSERT INTO PRODUCT(NAME, MAKE_TIME, CATEGORY_ID, PRICE, QUANTITY) " +
                    "VALUES ('히비스커스', 15, 2, 3000, 30)";
    private final String PRODUCT4 =
            "INSERT INTO PRODUCT(NAME, MAKE_TIME, CATEGORY_ID, PRICE, QUANTITY) " +
                    "VALUES ('캐모마일', 20, 2, 3500, 40)";
    private final String PRODUCT5 =
            "INSERT INTO PRODUCT(NAME, MAKE_TIME, CATEGORY_ID, PRICE, QUANTITY) " +
                    "VALUES ('딸기딜라이트요거트블렌디드', 30, 3, 4000, 60)";
    private final String PRODUCT6 =
            "INSERT INTO PRODUCT(NAME, MAKE_TIME, CATEGORY_ID, PRICE, QUANTITY) " +
                    "VALUES ('블루베리스무디', 35, 3, 5000, 70)";

    private final String CREATE_CATEGORY_TABLE =
            "CREATE TABLE CATEGORY" +
                    "(ID INT AUTO_INCREMENT PRIMARY KEY," +
                    "NAME VARCHAR(255) NOT NULL)";
    private final String CREATE_PRODUCT_TABLE =
            "CREATE TABLE PRODUCT" +
                    "(ID INT AUTO_INCREMENT PRIMARY KEY," +
                    "NAME VARCHAR(255) NOT NULL," +
                    "MAKE_TIME INT," +
                    "CATEGORY_ID INT," +
                    "PRICE INT," +
                    "QUANTITY INT," +
                    "FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORY(ID))";
    private final String CREATE_USER_TABLE =
            "CREATE TABLE USER" +
                    "(ID INT AUTO_INCREMENT PRIMARY KEY," +
                    "NAME VARCHAR(255) NOT NULL," +
                    "PASSWORD VARCHAR(255) UNIQUE KEY NOT NULL," +
                    "ROLE VARCHAR(255))";
    private final String CREATE_ORDER_HISTORY_TABLE =
            "CREATE TABLE ORDER_HISTORY" +
                    "(ID INT AUTO_INCREMENT PRIMARY KEY," +
                    "USER_ID INT," +
                    "ORDERED_AT DATETIME DEFAULT NOW()," +
                    "FOREIGN KEY (USER_ID) REFERENCES USER (ID))";
    private final String CREATE_ORDER_HISTORY_DETAIL_TABLE =
            "CREATE TABLE ORDER_HISTORY_DETAIL(" +
                    "ID INT AUTO_INCREMENT PRIMARY KEY," +
                    "ORDER_HISTORY_ID INT," +
                    "PRODUCT_ID INT," +
                    "AMOUNT INT," +
                    "FOREIGN KEY (ORDER_HISTORY_ID) REFERENCES ORDER_HISTORY (ID)," +
                    "FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT (ID))";
}
