import java.io.Serializable;

/*Product: ID, Name, Quantity, price with id's not same (validate)*/
public class Product implements Serializable {
    /*//test
    public static void main(String[] args) {
        Product t=new Product("P15","Lemon", 15, 5.30);
        t.display();
    }*/
    private String id,name;
    private int qtt,index;
    private double price;
    //<constructor> input id,name,quantity and price of product
    public Product(String id, String name, int qtt, double price){
        this.index=MyList.size++;
        this.id=id;
        this.name=name;
        this.qtt=qtt;
        this.price=price;
    }
    public Product(){
        this(null,null,0,0);
    }
    //<method> encapsulation
    public void setId(String id){        this.id=id;    }
    public void setName(String name) {        this.name = name;    }
    public void setQuantity(int qtt) {        this.qtt = qtt;    }
    public void setPrice(double price) {        this.price = price;    }
    public String getId() {        return id;    }
    public String getName() {        return name;    }
    public int getQuantity() {        return qtt;    }
    public double getPrice() {return price;}
    public int index() {        return index;    }
    //<method> display value of product by string
    public void display (){
        System.out.printf("| %-7s| %-15s| %-10s| %-10s|",id,name,qtt,price);
        SaveOutput.out.printf("| %-7s| %-15s| %-10s| %-10s|",id,name,qtt,price);
    }
}
