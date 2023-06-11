package sql.manager_sql;

public class ManagerSql {
    public static String productSql = "select * from product";
    public static String orderHistorySql ="select * from order_history";
    public static String quantitySql = "update product set quantity = ? where id=?";
}
