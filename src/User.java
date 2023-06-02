import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.Scanner;

public class User {
    int password;
    String userName;

    public User(int password, String userName) {
        this.password = password;
        this.userName = userName;
    }

    public static void register(@NotNull Statement statement, @NotNull Connection conn) throws SQLException {
    Scanner scanner = new Scanner(System.in);
System.out.println("Enter username: ");
    String userName = scanner.next();
System.out.println("Enter password: ");
    int password = scanner.nextInt();

    PreparedStatement preparedStatement0 = conn.prepareStatement("SELECT username FROM user WHERE username = ?");
preparedStatement0.setString(1, userName);
    ResultSet resultSet = preparedStatement0.executeQuery();

if (resultSet.next()) {
        System.out.println("This username is not available!");
    } else {
    resultSet = statement.executeQuery("SELECT id FROM user ORDER BY id ASC");
        int id = 0;
        if (resultSet.last()) {
            id = resultSet.getInt("id");
        } else {
            System.out.println("No rows found.");
        }
        resultSet.close();
        id = id + 1;

        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO user(id, username, password) VALUES (?, ?, ?)");
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, userName);
        preparedStatement.setInt(3, password);
        preparedStatement.executeUpdate();

        System.out.println("Your account has been created successfully");
    }
}
    public static void login(@NotNull Connection conn) throws SQLException {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your username:");
        String username = s.nextLine();
        System.out.println("Enter your password:");
        int password = s.nextInt();

        String sql = "SELECT * FROM user WHERE username=? AND password=?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        // Set the parameters
        stmt.setString(1, username); // replace with actual username input
        stmt.setInt(2, password); // replace with actual password input

        // Execute the query
        ResultSet rs = stmt.executeQuery();

        // Check if user credentials match
        if (rs.next()) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }


    }
    public static void deleteID(@NotNull Connection conn) throws SQLException {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the username you want to delete: ");
        String username = s.nextLine();

        PreparedStatement stmt = conn.prepareStatement("delete from user where username=? ");
        stmt.setString(1, username);
        stmt.executeUpdate();

            System.out.println("The row successfully deleted!! ");
    }
}