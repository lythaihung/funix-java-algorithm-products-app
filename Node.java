import java.io.Serializable;

public class Node implements Serializable {
    private Product product;
    private Node next;
    //<constructor> input object product or node next
    public Node(Product product, Node next) {
        this.product=product;
        this.next=next;
    }
    public Node(Product product){
        this(product,null);
    }
    //<method> for encapsulation
    public void next(Node next){
        this.next=next;
    }
    public Node next(){
        return next;
    }
    public void product(Product product) {
        this.product = product;
    }
    public Product product() {
        return product;
    }

    //<method> display information of node
    public void info(){
        product.display();
    }
}
