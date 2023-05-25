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
        statement.executeUpdate("insert into products(id,name,author,prise) values (Aid, 'Aname' ,'Aauthor',Aprise))");
    }
    public void createBag(@NotNull Statement statement, String a) throws SQLException {
        statement.executeUpdate("create table a(id,name,author,prise)");
    }
    public void addToBag(Statement statement ) throws SQLException {
        statement.executeUpdate("insert table a(id,name,author,prise) values (Aid, 'Aname' ,'Aauthor',Aprise)");
    }

}
