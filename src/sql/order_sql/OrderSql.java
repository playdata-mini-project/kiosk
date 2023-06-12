package sql.order_sql;

public class OrderSql {
    public static String getStockSql =
            "select (quantity) from product where id = ?";

    public static String orderSql =
            " update product set quantity = quantity - ?"
                    + " where id = ? ";

    public static String orderSaveSql =
            "insert into order_history(user_id)"
                    +"values(?)";

    public static String orderDetailSaveSql =
            "insert into order_history_detail (order_history_id,product_id,amount)" +
            "values (?,?,?)";
}
