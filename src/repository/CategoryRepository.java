package repository;

import config.JdbcConnection;
import domain.entity.Category;
import sql.category_sql.CategorySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    public List<Category> getCategoryList(){

        Connection conn = new JdbcConnection().getJdbc();

        List<Category> categoryList = new ArrayList<>();

        PreparedStatement psmt = null;

        try {
            psmt = conn.prepareStatement(CategorySql.findAll);
            ResultSet rs = psmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");

                categoryList.add(new Category(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoryList;
    }

}


