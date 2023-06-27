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

        System.out.println("WELCOME TO THE SHOPPING WEBSITE!");
        System.out.println("Do you have an account?");
        Scanner s = new Scanner(System.in);
        String haveAnAccountAnswer = s.nextLine();
        if(haveAnAccountAnswer.equalsIgnoreCase("no")){
            System.out.println("You should create an account.");
            System.out.println("...");
            System.out.println("You are directing to the register page.");
            boolean b = true;
            while(true) {
                String result = User.register(statement, conn);
                if (result.equals("available")) {
                    System.out.println("You are directing to login page.");
                    String r = User.login(conn);
                    if(r.equals("available")){
                        product.userList(statement,conn,);
                    }else{
                        User.login(conn);
                    }
                } else if (result.equals("notAvailable")) {
                }
            }
        }else if(haveAnAccountAnswer.equalsIgnoreCase("yes")){
            System.out.println("You are directing to the login page.");
            String res = User.login(conn);
            if(res.equals("available")){

            }else if(res.equals("notAvailable")){
                User.login(conn);
            }
        }else{
            System.out.println("Please enter a proper answer!");
        }
        //User.deleteID(conn);
        //User.login(conn);
        //User.register(statement,conn);
        //Database.seeProducts(statement);
        //Database.createBag(statement,a);
        //Database.queryAProductByAuthor("b", statement);
        //Database.addAProduct(statement, conn );
        //Database.addToBag(statement,conn,a);
        // User.register(statement,conn);

    }
}
