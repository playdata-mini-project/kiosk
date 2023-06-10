package repository;

import config.JdbcConnection;
import domain.entity.Product;
import domain.entity.User;
import sql.product_sql.ProductSql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    public Product findById(int id){
        Connection conn = new JdbcConnection().getJdbc();

        Product product = null;

        try {
            PreparedStatement psmt = conn.prepareStatement(ProductSql.findById);
            psmt.setInt(1, id);
            ResultSet resultSet = psmt.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int makeTime = resultSet.getInt("make_time");
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

    public List<Product> findByCategoryId(int id){

        Connection conn = new JdbcConnection().getJdbc();

        List<Product> products = new ArrayList<>();

        try {
            PreparedStatement psmt = conn.prepareStatement(ProductSql.findByCategoryId);
            psmt.setInt(1, id);
            ResultSet resultSet = psmt.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int makeTime = resultSet.getInt("make_time");
                int categoryId = resultSet.getInt("category_id");
                int price  = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");

                products.add(new Product(productId, name, makeTime, categoryId, price, quantity));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }
}
