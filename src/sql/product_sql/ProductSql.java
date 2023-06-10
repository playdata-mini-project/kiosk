package sql.product_sql;

public class ProductSql {

    public static String findById = "select * from product " +
            "where id = ?";
    public static String findByCategoryId = "select * from product " +
            "where id = ?";
}
