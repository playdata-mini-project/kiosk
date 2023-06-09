package repository;

import config.JdbcConnection;
import domain.dto.OrderHistoryDto;
import domain.dto.ProductDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerRepository {
//    public static Manager manager;
    public List<ProductDto> stockCheck() {
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "select * from product";
        List<ProductDto> productList = new ArrayList<>();
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet resultSet = psmt.executeQuery();
            while (resultSet.next()) {
                ProductDto productDto = new ProductDto();
                productDto.setId(resultSet.getInt("id"));
                productDto.setName(resultSet.getString("name"));
                productDto.setMakeTime(resultSet.getInt("make_time"));
                productDto.setCategoryId(resultSet.getInt("category_id"));
                productDto.setPrice(resultSet.getInt("price"));
                productDto.setQuantity(resultSet.getInt("quantity"));
                productList.add(productDto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    public List<OrderHistoryDto> orderCheck() {
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "select * from order_history";
        List<OrderHistoryDto> orderList = new ArrayList<>();
        try {
            PreparedStatement psmt1 = conn.prepareStatement(sql);
            ResultSet resultSet = psmt1.executeQuery();
            while (resultSet.next()) {
                OrderHistoryDto orderHistoryDto = new OrderHistoryDto();
                orderHistoryDto.setId(resultSet.getInt("id"));
                orderHistoryDto.setUserId(resultSet.getInt("user_id"));
                orderHistoryDto.setProductId(resultSet.getInt("product_id"));
                orderHistoryDto.setAmount(resultSet.getInt("amount"));
                orderHistoryDto.setOrderedAt(resultSet.getString("ordered_at"));
                orderList.add(orderHistoryDto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderList;
    }

    public void plusQuantity(int productId, int quantity) {
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "update product set quantity = ? where id=?";
        PreparedStatement psmt2 = null;
        try {
            psmt2 = conn.prepareStatement(sql);
            psmt2.setInt(1, quantity);
            psmt2.setInt(2, productId);
            psmt2.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


