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
        Scanner s = new Scanner(System.in);
        System.out.println("username: ");
        String userName = s.next();
        System.out.println("password: ");
        int password = s.nextInt();

        PreparedStatement preparedStatement0 = conn.prepareStatement("select username from user");
        ResultSet a = preparedStatement0.executeQuery();
        while (a.next()) {
            String usernamesOnTable = a.getString("username");
            if (usernamesOnTable.equals(userName)) {
                System.out.println("This username is not available! ");
                break;
            } else {

                ResultSet resultSet = statement.executeQuery("SELECT id FROM user ORDER BY id asc");
                int id = 0;
                if (resultSet.last()) {
                    id = resultSet.getInt("id");
                } else {
                    // No rows found in the result set
                    System.out.println("No rows found.");
                }
                resultSet.close();
                id = id + 1;

                PreparedStatement preparedStatement = conn.prepareStatement("insert into user(id,username,password) values (?,?,?)");
                preparedStatement.setInt(1, Integer.parseInt(String.valueOf(id)));
                preparedStatement.setString(2, String.valueOf(userName));
                preparedStatement.setInt(3, Integer.valueOf(password));
                preparedStatement.executeUpdate();
            }
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