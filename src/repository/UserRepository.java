package repository;

import config.JdbcConnection;
import domain.dto.LoginDto;
import domain.dto.SignupDto;
import domain.entity.User;
import sql.user_sql.UserSql;
import utility.LoginUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    Connection conn = new JdbcConnection().getJdbc();
    public boolean login(LoginDto dto) {
        String name = null;
        try {
            PreparedStatement psmt = conn.prepareStatement(UserSql.loginSql);
            psmt.setString(1, dto.getName());
            psmt.setString(2, dto.getPassword());
            ResultSet resultSet = psmt.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                name = resultSet.getString("name");
                String role = resultSet.getString("role");
                LoginUser.doLogin(id,name,role);
                System.out.println(LoginUser.printLoginUser());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return name != null;
    }
    public void insertUser(SignupDto dto){
        try {
            PreparedStatement psmt = conn.prepareStatement(UserSql.insertUserSql);
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
