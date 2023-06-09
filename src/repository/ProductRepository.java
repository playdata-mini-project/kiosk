package repository;

import config.JdbcConnection;
import domain.entity.Product;
import domain.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepository {

    public Product findById(int id){
        Connection conn = new JdbcConnection().getJdbc();

        Product product = null;
        String sql = "select * from product " +
                "where id = ?";

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, String.valueOf(id));
            ResultSet resultSet = psmt.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int makeTime = resultSet.getInt("");
                int categoryId = resultSet.getInt("category_id");
                int price  = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");

                product = new Product(productId, name, makeTime, categoryId, price, quantity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }
}
