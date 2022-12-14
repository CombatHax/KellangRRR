package kellang;

import java.util.HashMap;

public class Action {
    public enum ACTIONS {
        OUTPUT,
        STORE
    }
    private final ACTIONS type;
    public Action(ACTIONS type) {
        this.type = type;
    }

    public void run(HashMap<String, Object> args) {
        switch(this.type) {
            case OUTPUT:
                System.out.println(args.get("string"));
        }
    }
}
