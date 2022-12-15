import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;

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
        LinkedList<Class> args = new LinkedList<>();
        args.add(String.class);
        new Function("o", new Action[]{new Action(Action.ACTIONS.OUTPUT)}, args);
    }
}