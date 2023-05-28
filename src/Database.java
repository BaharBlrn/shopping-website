import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.Scanner;

public class Database {

    public void seeProducts(@NotNull Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * from products ");
        System.out.println(rs);
    }

    public static void queryAProductByAuthor(String name, @NotNull Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * from products WHERE name = '"+ name+"'");
        //PreparedStatement.getstring("name");
        while (resultSet.next()) {
            // Retrieve the value of the "name" column from each row
            name = resultSet.getString("name");
            String author = resultSet.getString("author");
            int price = resultSet.getInt("price");
            // Do something with the retrieved name value
            System.out.print("  Name: " + name);
            System.out.print("  Author: " + author);
            System.out.println("  Price: " + price);
        }
        System.out.println(resultSet);
    }

    public static void queryAProductByName(String name, @NotNull Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * from products WHERE name = '"+ name+"'");
        //PreparedStatement.getstring("name");
        while (resultSet.next()) {
            // Retrieve the value of the "name" column from each row
            name = resultSet.getString("name");
            String author = resultSet.getString("author");
            int price = resultSet.getInt("price");
            // Do something with the retrieved name value
            System.out.print("  Name: " + name);
            System.out.print("  Author: " + author);
            System.out.println("  Price: " + price);
        }
        System.out.println(resultSet);
    }

    public static void addAProduct(@NotNull Statement statement, Connection conn ) throws SQLException {
        Scanner s = new Scanner(System.in);
        System.out.println("enter the values that you wanna add: ");
        System.out.println("name: ");
        String name = s.next();
        System.out.println("author: ");
        String author = s.next();
        System.out.println("price ");
        int price = s.nextInt();

        ResultSet resultSet = statement.executeQuery("SELECT id FROM products ORDER BY id asc");
        int id = 0;
        if (resultSet.last()) {
            id = resultSet.getInt("id");
        } else {
            // No rows found in the result set
            System.out.println("No rows found.");
        }
        resultSet.close();
        id = id + 1;
        PreparedStatement preparedStatement = conn.prepareStatement("insert into products(id,name,author,price) values (?,?,?,?)");
        preparedStatement.setInt(1, Integer.parseInt(String.valueOf(id)));
        preparedStatement.setString(2, String.valueOf(name));
        preparedStatement.setString(3, String.valueOf(author));
        preparedStatement.setInt(4, Integer.parseInt(String.valueOf(price)));
        preparedStatement.executeUpdate();


    }

    public void createBag(@NotNull Statement statement, String a) throws SQLException {
        statement.executeUpdate("create table ?(id,name,author,price)");
    }

    public void addToBag(@NotNull Statement statement) throws SQLException {
        statement.executeUpdate("insert table a(id,name,author,price) values (Aid, 'Aname' ,'Aauthor',Aprise)");
    }

}
