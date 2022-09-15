import java.io.*;

/* linked list create by Product Node with head and tail */
public class MyList implements Serializable {
    /*//test
    public static void main(String[] args) {
        MyList t= new MyList();
        t.add(new Node(new Product("P15","Lemon", 15, 5.30)));
        t.add(new Node(new Product("P15","Lemon", 15, 5.30)));
        t.add(new Node(new Product("P15","Lemon", 15, 5.30)));
        t.add(new Node(new Product("P15","Lemon", 15, 5.30)));
        t.display();
    }*/
    private Node head,tail;
    public static int size;
    //<constructor> input node head (object Product) and node tail (objectProduct)
    public MyList(){
        head=tail=null;
        size=0;
    }
    //<method< encapsulation
    public Node head() {        return head;    }
    public Node tail() {        return tail;    }
    public void tail(Node tail) {        this.tail = tail;    }
    public void head(Node head) {        this.head = head;    }
    //<method> check list empty ; return boolean true or false: true is empty list
    public boolean isEmpty(){         return head==null;    }
    //<method>input a Node ;add a node (obj Product) to the list
    public void add(Product product){
//        size++;
        if (isEmpty()) this.head=this.tail=new Node(product);
        else {
            Node t = this.head; this.head=new Node(product); this.head.next(t);
        }
    }
    public void addAtLast(Product product){
//        ++size;
        if (isEmpty()) this.head=this.tail=new Node(product);
        else {
            Node t= new Node(product); this.tail.next(t); this.tail=t;
        }
    }
    //<method>remove a Node ;remove a head
    public void remove(){
        if(!isEmpty()){
            if (head.next()==null) head=tail=null;
            else{
                head=head.next();
            }
            size--;
        }
    }
    //<method> count size : return size of list
    public int getSize(){
        int size=0;
        for (Node current=head; current!=null; current=current.next()){
            size++;
        }
        return size;
    }
    //<method> display info: print out the product list
    public void display(){
        System.out.printf("| %-7s| %-15s| %-10s| %-10s|","ID","Title", "Quantity", "Price");
        SaveOutput.out.printf("| %-7s| %-15s| %-10s| %-10s|","ID","Title", "Quantity", "Price");
        System.out.print("\n---------------------------------------------------");
        SaveOutput.out.print("\n---------------------------------------------------");
        for (Node current=head; current!=null; current=current.next()){
            System.out.println();
            SaveOutput.out.println();
            current.info();
        }
    }
}
