public class MyStack {
    private Node head;
    private int size;
    //<constructor>
    public MyStack(){
        head=null;
        size=0;
    }
    //<method> validate stack : check stack empty or not ; if stack empty return true
    public boolean isEmpty(){
        return head==null;
    }
    //<method> push a new node to stack ; input a node (Object Product)
    public void push(Product product){
        size++;
        if (isEmpty()){
            this.head=new Node(product);
        } else {
            Node t= this.head; this.head=new Node(product); this.head.next(t);
        }
    }
    //<method> pop a node from stack ; return node popped
    public Product pop(){
        if (!isEmpty()) {
            size--;
            Node t = head;
            head=head.next();
            return t.product();
        }
        return null;
    }
    //<method> return a node on top of stack
    public Product top(){return head.product();}
    //<method> return size of stack
    public int size() {
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
