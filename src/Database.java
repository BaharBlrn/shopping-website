import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    public void seeProducts(@NotNull Statement statement ) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * from products ");
        System.out.println(rs);
    }
    public void queryAProduct(String productIWannaFind, @NotNull Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * from products Where ");
        System.out.println(rs);
    }
    public static void addAProduct(@NotNull Statement statement, product productWillAdd) throws SQLException {
        statement.executeUpdate("insert into products(id,name,author,price) values (1, 'Aname' ,'Aauthor',13)");
    }
    public void createBag(@NotNull Statement statement, String a) throws SQLException {
        statement.executeUpdate("create table a(id,name,author,price)");
    }
    public void addToBag(@NotNull Statement statement ) throws SQLException {
        statement.executeUpdate("insert table a(id,name,author,price) values (Aid, 'Aname' ,'Aauthor',Aprise)");
    }

}
