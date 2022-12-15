package kellang;

import java.util.LinkedList;

public class Action {
    public enum ACTIONS {
        OUTPUT,
        STORE
    }
    private final ACTIONS type;
    public Action(ACTIONS type) {
        this.type = type;
    }

    public void run(LinkedList<Object> args) {
        switch(this.type) {
            case OUTPUT:
                System.out.println(args.get(0));
        }
    }
}
