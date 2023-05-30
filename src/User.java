import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.Scanner;

public class User {
    int password;
    String userName;

    public User(int password, String userName){
        this.password=password;
        this.userName=userName;
    }
    public static void register(@NotNull Statement statement, @NotNull Connection conn) throws SQLException {
        Scanner s = new Scanner(System.in);
        System.out.println("enter your username: ");
        System.out.println("username: ");
        String userName = s.next();

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

        PreparedStatement preparedStatement = conn.prepareStatement("insert into user(id,username) values (?,?)");
        preparedStatement.setInt(1, Integer.parseInt(String.valueOf(id)));
        preparedStatement.setString(2, String.valueOf(userName));
        preparedStatement.executeUpdate();
    }
}
