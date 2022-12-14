import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import kellang.Action;
import kellang.Function;
import kellang.Kellang;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        if(!file.canRead()) {
            System.out.println("Invalid file");
        }
        Kellang kel = new Kellang(file);
        initialize();
        kel.run();
    }

    private static void initialize() {
        HashMap<String, Class> args = new HashMap<>();
        args.put("string", String.class);
        new Function("o", new Action[]{new Action(Action.ACTIONS.OUTPUT)}, args);
    }
}