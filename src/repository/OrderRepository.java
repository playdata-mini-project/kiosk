package repository;

import config.JdbcConnection;
import sql.order_sql.OrderSql;
import sql.user_sql.UserSql;
import utility.LoginUser;

import java.sql.*;

public class OrderRepository {

    Connection conn = new JdbcConnection().getJdbc();

    public int getStock(int productId) {
        Integer quantity = null;
        try {
            PreparedStatement psmt = conn.prepareStatement(OrderSql.getStockSql);
            psmt.setInt(1, productId);
            ResultSet resultSet = psmt.executeQuery();
            while (resultSet.next()) {
                quantity = resultSet.getInt("quantity");
                return quantity;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return quantity;
    }

    public void order(int productId, int quantity) {

        try {
            PreparedStatement psmt = conn.prepareStatement(OrderSql.orderSql);
            psmt.setInt(1, quantity);
            psmt.setInt(2, productId);
            psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int orderSave(int userId) {
        int orderHistoryId = 0;

        try {
            PreparedStatement psmt = conn.prepareStatement(OrderSql.orderSaveSql, Statement.RETURN_GENERATED_KEYS);
            psmt.setInt(1, userId);
            psmt.executeUpdate();
            ResultSet generatedKeys = psmt.getGeneratedKeys();


            if (generatedKeys.next()) {
                orderHistoryId = generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  orderHistoryId;
    }

    public void orderDetailSave(int orderHistoryId, int productId, int quantity) {
        try {
            PreparedStatement psmt = conn.prepareStatement(OrderSql.orderDetailSaveSql);
            psmt.setInt(1, orderHistoryId);
            psmt.setInt(2, productId);
            psmt.setInt(3, quantity);
            psmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
