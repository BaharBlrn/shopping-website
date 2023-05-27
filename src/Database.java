import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.Scanner;

public class Database {

    public void seeProducts(@NotNull Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * from products ");
        System.out.println(rs);
    }

    public void queryAProduct(String productIWannaFind, @NotNull Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * from products Where ");
        System.out.println(rs);
    }

    public static void addAProduct(@NotNull Statement statement, Connection conn) throws SQLException {
        Scanner s = new Scanner(System.in);
        System.out.println("enter the values that you wanna add: ");
        System.out.println("name: ");
        String name = s.next();
        System.out.println("author: ");
        String author = s.next();
        System.out.println("prise ");
        int price = s.nextInt();

        //ResultSet resultSet = statement.executeQuery("select id from products where ");
        //int id = resultSet.getInt("id");
        //int id = Which(conn);

        ResultSet resultSet = statement.executeQuery("SELECT id FROM products");
        // Move the cursor to the first row
        int id = 0;
        if (resultSet.first()) {
            // Process the first row
            id = resultSet.getInt("id");
            // Do something with the retrieved data
        } else {
            // No rows found in the result set
            System.out.println("No rows found.");
        }
        increaseValue(conn);
        PreparedStatement preparedStatement = conn.prepareStatement("insert into products(id,name,author,price) values (?,?,?,?)");
        preparedStatement.setInt(1, Integer.parseInt(String.valueOf(id)));
        preparedStatement.setString(2, String.valueOf(name));
        preparedStatement.setString(3, String.valueOf(author));
        preparedStatement.setInt(4, Integer.parseInt(String.valueOf(price)));
        preparedStatement.executeUpdate();


    }

    public void createBag(@NotNull Statement statement, String a) throws SQLException {
        statement.executeUpdate("create table a(id,name,author,price)");
    }

    public void addToBag(@NotNull Statement statement) throws SQLException {
        statement.executeUpdate("insert table a(id,name,author,price) values (Aid, 'Aname' ,'Aauthor',Aprise)");
    }

    public static void increaseValue(Connection connection) throws SQLException {
        // SQL statement and parameter
        String sql = "UPDATE products SET id = id + 1";

        // Create prepared statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // Execute the statement
        int rowsAffected = preparedStatement.executeUpdate();

        System.out.println(rowsAffected + " row(s) updated successfully.");

        // Close the prepared statement
        preparedStatement.close();
    }



}
