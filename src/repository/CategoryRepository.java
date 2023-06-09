package repository;

import config.JdbcConnection;

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

        String sql = "SELECT * FROM CATEGORY";

        PreparedStatement psmt = null;
        try {
            psmt = conn.prepareStatement(sql);
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

class Category{
    int id;
    String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
