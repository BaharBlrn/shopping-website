import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
        Statement statement = conn.createStatement();

        Scanner s = new Scanner(System.in);
        System.out.println("enter the values that you wanna add: ");
        System.out.println("name: ");
        String n = s.next();
        System.out.println("author: ");
        String a = s.next();
        System.out.println("prise ");
        String p = s.next();
        product productWillAdd ;
        Database.addAProduct(statement,productWillAdd);


    }
}
