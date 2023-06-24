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
    public void adminList(){
        System.out.println("Type 'list' to see the list of the products: ");
        System.out.println("Type 'add' to add a new product: ");
    }
}
