import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AS2_Main {
    public static void main(String[] args) throws InputMismatchException,
            IOException, ObjectStreamException, ClassNotFoundException, FileNotFoundException {
        Scanner sc=new Scanner(System.in);
        int choice;
        MyList list = new MyList();
        OperationToProduct operation= new OperationToProduct();
        //<Loop>: Begin
        do {
            //Display menu and choice function
            menu();
            choice = sc.nextInt();
            SaveOutput.out.print(choice+"\n");
            switch (choice) {
                //1. Load data from file and display
                case 1:
                    list=operation.loadProduct(list, "Data.txt"); break;
                //2. Input & add to the end.
                case 2:
                    operation.inputProduct(list,"Data.txt"); break;
                //3.Display data
                case 3:
                    list.display(); break;
                //4.Save product list to file.
                case 4:
                    operation.saveProduct(list,"Data.txt"); break;
                //5. Search by ID
                case 5:
                    operation.search(list); break;
                //6.Delete by ID
                case 6:
                    operation.delete(list); break;
                //7.Sort by ID.
                case 7:
                    operation.sortById(list); break;
                //8. Convert to Binary
                case 8:
                    operation.convertBinary(list); break;
                //9. Load to stack and display
                case 9:
                    operation.loadStack("Data.txt"); break;
                //10. Load to queue and display.
                case 10:
                    operation.loadQueue("Data.txt"); break;
                //0. Exit
                default:
                    if (choice!=0) {
                        System.out.println("Please try again!");
                        SaveOutput.out.println("Please try again!");
                    }
                }
            } while (choice!=0);
        //<loop> :end
        System.out.println("Thank you!");
        SaveOutput.out.println("Thank you!");

    }
    //<method> menu: display menu list;
    static void menu (){
        System.out.println();
        SaveOutput.out.println();
        System.out.println("\nChoose one of this options:\n" +
                "Product list:\n" +
                "  1. Load data from file and display\n" +
                "  2. Input & add to the end.\n" +
                "  3. Display data\n" +
                "  4. Save product list to file.\n" +
                "  5. Search by ID\n" +
                "  6. Delete by ID\n" +
                "  7. Sort by ID.\n" +
                "  8. Convert to Binary \n" +
                "  9. Load to stack and display\n" +
                "  10. Load to queue and display.\n" +
                "Exit:\n" +
                "  0. Exit\n");
        SaveOutput.out.println("\nChoose one of this options:\n" +
                "Product list:\n" +
                "  1. Load data from file and display\n" +
                "  2. Input & add to the end.\n" +
                "  3. Display data\n" +
                "  4. Save product list to file.\n" +
                "  5. Search by ID\n" +
                "  6. Delete by ID\n" +
                "  7. Sort by ID.\n" +
                "  8. Convert to Binary \n" +
                "  9. Load to stack and display\n" +
                "  10. Load to queue and display.\n" +
                "Exit:\n" +
                "  0. Exit\n");
        System.out.print("Choice: ");
        SaveOutput.out.print("Choice: ");
    }
}
