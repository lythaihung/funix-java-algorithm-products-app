public class MyQueue {
    private Node head, tail;
    private int size;
    //<constructor>
    public MyQueue(){
        head=tail=null;
        size=0;
    }
    //<method> validate empty queue: return true if queue empty
    public boolean isEmpty (){
        return head==null;
    }
    //<method> enqueue : add a node to queue; size increase +1
    public void enqueue (Product product){
        size++;
        if (isEmpty()) head=tail=new Node(product);
        else {
            size++;
            Node t= new Node(product);
            tail.next(t); tail=t;
        }
    }
    //<method> dequeue : remove a node from queue; size decrease -1; return product dequeued
    public Product dequeue (){
        if (!isEmpty()) {
            size--;
            Node t=head; head=head.next();
            if (head==null) tail=null;
            return t.product();
        }
        return null;
    }
    //<method> return a product front
    public Product front (){
        if (!isEmpty()) return head.product();
        return null;
    }
    //<method> return size of queue
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
