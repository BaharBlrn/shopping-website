import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class product {
    int id;
    String name;
    String author;
    int price;

    public product(int id,String name,String author,int prise){
        this.author= author;
        this.name=name;
        this.id=id;
        this.price=prise;
    }
    public static void userList(Statement statement, Connection conn,String username) throws SQLException {
        System.out.println("Type 'list' to see the list of the products: ");
        System.out.println("Type 'add' to add a product to your bag");
        System.out.println("Type 'delete' to delete a product from your bag");
        Scanner s = new Scanner(System.in);
        String answer = s.nextLine();
        if(s.equals("list")){
            Database.seeProducts(statement);
        }if(s.equals("add")){
            if(username.equals()){
                Database.addToBag(statement,conn,"Users bag");
            }else{
                Database.createBag(statement,"Users bag");
            }
            Database.addToBag(statement,conn,"Users bag");
        }if(s.equals("delete")){
            Database.deleteFromTable(statement,conn,"a",id);
        }
    }
}
