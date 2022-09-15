import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class SaveOutput {
    public static PrintStream out;

    static {
        try {
            out = new PrintStream(new FileOutputStream("Output.txt",true));
        } catch (FileNotFoundException e) {
            System.out.println("WriteOutputToFile: FileNotFoundException");
        }
    }

}
