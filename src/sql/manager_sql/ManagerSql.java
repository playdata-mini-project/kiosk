package sql.manager_sql;

public class ManagerSql {
    public static String productSql = "select * from product";
    public static String orderHistorySql ="select * " +
            "from order_history o, order_history_detail d , product p " +
            "where o.id = d.order_history_id " +
            "and d.product_id = p.id";
    public static String quantitySql = "update product set quantity = ? where id=?";
}
