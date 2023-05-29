import javax.xml.crypto.Data;
import java.sql.*;
import java.util.Scanner;

public class Main {
    static String url = "jdbc:mysql://localhost:3306/shopping";
    static String user = "root";
    static String passwd = "1234";

    public static void main(String[] args) throws SQLException {
// Parameters are: getConnection( database, user, password )
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("driver not found");
        }
        Connection conn = DriverManager.getConnection(url, user, passwd);

        Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);


        //Database.seeProducts(statement);
        //String a ="Bahars_bag";
        //Database.createBag(statement,a);
        //Database.queryAProductByAuthor("b", statement);
        //Database.addAProduct(statement, conn );
        //Database.addToBag(statement,conn,a);


    }
}
