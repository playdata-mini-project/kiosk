package sql.user_sql;

public class UserSql {
    public static String loginSql = "select * from user " +
                                    "where name = ? and password = ?";
    public static String insertUserSql =  "insert into user(name,password,role)" +
                                          "values (?,?,?)";
}
