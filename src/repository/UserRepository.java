package repository;

import config.JdbcConnection;
import domain.dto.LoginDto;
import domain.dto.SignupDto;
import domain.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    public static User user;

    public boolean login(LoginDto dto) {
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "select * from user " +
                "where name = ? and password = ?";
        String name = null;
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, dto.getName());
            psmt.setString(2, dto.getPassword());
            ResultSet resultSet = psmt.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                name = resultSet.getString("name");
                String role = resultSet.getString("role");
                user = new User(name,role);
                System.out.println(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return name != null;
    }
    public void insertUser(SignupDto dto){
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "insert into user(name,password,role)\n" +
                "values (?,?,?)";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, dto.getName());
            psmt.setString(2, dto.getPassword());
            psmt.setString(3, dto.getRole());
            if(psmt.executeUpdate() == 0) {
                System.out.println("insert error");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
