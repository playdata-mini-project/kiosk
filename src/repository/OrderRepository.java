package repository;

import config.JdbcConnection;
import sql.user_sql.UserSql;
import utility.LoginUser;

import java.sql.*;

public class OrderRepository {

    Connection conn = new JdbcConnection().getJdbc();

    public int getStock(int productId) {
        Integer quantity = null;
        String sql= "select (quantity) from product where id = ?";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
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
        String sql =" update product set quantity = quantity - ?" +
                    " where id = ? ";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, quantity);
            psmt.setInt(2, productId);
            psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int orderSave(int userId) {
        int orderHistoryId = 0;
        String sql = "insert into order_history(user_id)" +
                     "values(?)";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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
        String sql = "insert into customer_order (order_history_id,product_id,amount)" +
                     "values (?,?,?)";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, orderHistoryId);
            psmt.setInt(2, productId);
            psmt.setInt(3, quantity);
            psmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
