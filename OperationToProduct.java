import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OperationToProduct  {
    private final Scanner sc = new Scanner(System.in);
    private MyList list;
    private static boolean isSorted = false;

    //<constructor>
    public OperationToProduct() {
    }
    //<method> input product: user input fields from keyboard/ input: id, name, quantity and price of product
    public void inputProduct(MyList list, String fileName) {
        try {
            System.out.println("Input new ID: ");
            SaveOutput.out.println("Input new ID: ");
            String id = sc.next();
            SaveOutput.out.print(id+"\n");
            System.out.println("Input Product's Name: ");
            SaveOutput.out.println("Input Product's Name: ");
            String name = sc.next();
            SaveOutput.out.print(name+"\n");
            System.out.println("Input Product's quantity: ");
            SaveOutput.out.println("Input Product's quantity: ");
            int qtt = sc.nextInt();
            SaveOutput.out.print(qtt+"\n");
            System.out.println("Input Product's price: ");
            SaveOutput.out.println("Input Product's price: ");
            double price = sc.nextDouble();
            SaveOutput.out.print(price+"\n");
            list.addAtLast(new Product(id, name, qtt, price));
            isSorted = false;
            System.out.println("Successfully!");
            SaveOutput.out.println("Successfully!");
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException");
            SaveOutput.out.println("InputMismatchException");
        }
    }
    //<method> load products from file: input filename to read and return list product from this
    public MyList loadProduct(MyList list, String fileName) {
        list = this.read(fileName); isSorted = false;
        //display list and inform finish read
        if (!list.isEmpty()) {
            list.display();
            System.out.println("\n\nSuccessfully!");
            SaveOutput.out.println("\n\nSuccessfully!");
            }
        return list;
    }
    //<method> save products to file: input list product and file name, save list to file named
    public void saveProduct(MyList list, String fileName){
        this.write(list,fileName);
        System.out.println("Successfully!");
        SaveOutput.out.println("Successfully!");
    }
    //<method> search by Id: input MyList , input id of product form keyboard to search and  print product
    //    (return index / return -1 mean no match)
    public int search(MyList list, String id) {
        for (Node current = list.head(); current != null; current = current.next()) {
            if (current.product().getId().equalsIgnoreCase(id)) {
                current.product().display();
                return current.product().index();
            }
        }
        return -1;
    }
    public void search(MyList list) {
        try {
            System.out.print("Input the ID to search = ");
            SaveOutput.out.print("Input the ID to search = ");
            String id = sc.next();
            SaveOutput.out.print(id+"\n");
            System.out.print("Result: ");
            SaveOutput.out.print("Result: ");
            if (search(list, id) == -1) {
                System.out.print(" -1");
                SaveOutput.out.print(" -1");
            }
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException");
            SaveOutput.out.println("InputMismatchException");
        }
    }
    //<method> delete by Id: input Mylist , input id of product from keyboard to find out product to delete
    public void delete(MyList list) {
        try {
            System.out.print("Input the ID to delete = ");
            SaveOutput.out.print("Input the ID to delete = ");
            String id = sc.next();
            SaveOutput.out.print(id+"\n");
            Node current = list.head();
            if (current != null && current.product().getId().equalsIgnoreCase(id)) {
                list.remove();
                System.out.println("Deleted!");
                SaveOutput.out.println("Deleted!");
                return;
            }
            while (current!= null) {
                if (current.next().product().getId().equalsIgnoreCase(id)) {
                    if (current.next()==list.tail()) list.tail(current);
                    current.next(current.next().next());
                    System.out.println("Deleted!");
                    SaveOutput.out.println("Deleted!");
                    MyList.size--;
                    return;
                }
                current = current.next();
            }
            System.out.println("Cannot find product ID = " + id + " to delete");
            SaveOutput.out.println("Cannot find product ID = " + id + " to delete");
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException");
            SaveOutput.out.println("InputMismatchException");
        } finally {
            if (list.head() == null) list.tail(null);
//            System.out.println("test qua tail==null"); //test
        }
    }
    //<method> sort by Id: input Mylist and sort list ; if list's sorted pass away
    /*public void sortById(MyList list) {
        if (!isSorted) {
            for (Node current = list.head(); current != null; current = current.next()) {
                Node min = current;
                for (Node current2 = current.next(); current2 != null; current2 = current2.next()) {
                    if (current2.product().getId().charAt(0) < min.product().getId().charAt(0)) min = current2;
                }
                Product t = min.product();
                min.product(current.product());
                current.product(t);
            }
            System.out.println("Successfully!");
            isSorted = true;
        }
    }*/
    //<method :advance> sort by Id: input Mylist and sort list ; if list's sorted pass away
    public void sortById(MyList list) {
        if (!isSorted) {
            sortById(list.head());
            System.out.println("Successfully!");
            SaveOutput.out.println("Successfully!");
            isSorted = true;
        }
    }
    public void sortById(Node begin) {
        if (begin == null) return;
        else {
            Node min = begin;
            for (Node current = min.next(); current != null; current = current.next()) {
                if (current.product().getId().charAt(0) < min.product().getId().charAt(0)) min = current;
            }
            Product t = min.product(); min.product(begin.product()); begin.product(t);
            sortById(begin.next());
        }
    }
    //<method> convert to Binary: input number, run convert and return binary
    public void convertBinary(MyList list) {
        int qtt = (list.head()==null) ? 0 : list.head().product().getQuantity();
        ArrayList<Integer> bin = new ArrayList<>();
        convertBinary(bin,qtt);
        System.out.print("Quantity = " + qtt + " => " + "(");
        SaveOutput.out.print("Quantity = " + qtt + " => " + "(");
        for (int e : bin) {
            System.out.print(e);
            SaveOutput.out.print(e);
        }
        System.out.print(")");
        SaveOutput.out.print(")");
    }
    private ArrayList<Integer> convertBinary(ArrayList<Integer> result,int x) {
        if (x==0) result.add(0);
        while (x > 0) {
            result.add(x % 2);
            x= x / 2;
        }
        Collections.reverse(result);
        return result;
    }
    //<method> Load to stack and display : input Mylist, convert to stack and display from stack LIFO
    public void loadStack(String fileName) {
        MyList list = read(fileName);
        MyStack x = new MyStack();
        for (Node current = list.head(); current != null; current = current.next()) {
            x.push(current.product());
        }
        x.display();
    }
    //<method> Load to queue and display: input Mylist, convert to queue and display from queue FIFO
    public void loadQueue(String fileName) {
        MyList list = read(fileName);
        MyQueue x = new MyQueue();
        for (Node current = list.head(); current != null; current = current.next()) {
            x.enqueue(current.product());
        }
        x.display();
    }
    //<method> write:  input list and file name , write list into file
    private void write (MyList list, String fileName){
        try {
            //output file > output object > write file > close file
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
            SaveOutput.out.println("FileNotFoundException");
        } catch (ObjectStreamException e) {
            System.out.println("ObjectStreamException");
            SaveOutput.out.println("ObjectStreamException");
        } catch (IOException e) {
            System.out.println("IOException");
            SaveOutput.out.println("IOException");

        }
    }
    //<method> read: input file name; read list from file and assign to new list; after return a link list
    private MyList read (String fileName){
        MyList result = new MyList();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            result= (MyList) ois.readObject();
            MyList.size=result.getSize();
        }  catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            SaveOutput.out.println("ClassNotFoundException");
        } catch (ObjectStreamException e) {
            System.out.println("ObjectStreamException");
            SaveOutput.out.println("ObjectStreamException");
        } catch (IOException e) {
            System.out.println("IOException");
            SaveOutput.out.println("IOException");
        }
        return result;
    }

}
    /*
    1. Load data from file and display
    2. Input & add to the end.
    3.Display data
    4.Save product list to file.
    5. Search by ID
    6.Delete by ID
    7.Sort by ID.
    8. Convert to Binary
    9. Load to stack and display
    10. Load to queue and display. */
    /* public static void main(String[] args) {
        //test

            MyList t = new MyList();
        t.add(new Product("001", "Hoa", 15, 15.2));
        t.add(new Product("001", "Hoa", 15, 15.2));
        t.add(new Product("001", "Hoa", 15, 15.2));
        t.add(new Product("001", "Hoa", 15, 15.2));
        write(t,"test");
        MyList x = read("test");
        x.display();
        int size = MyList.size;
        System.out.println(size);
    } */