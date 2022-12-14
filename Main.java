import java.io.File;
import java.io.FileNotFoundException;
import kellang.Kellang;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        if(!file.canRead()) {
            System.out.println("Invalid file");
        }
        Kellang kel = new Kellang(file);
        kel.run();
    }
}