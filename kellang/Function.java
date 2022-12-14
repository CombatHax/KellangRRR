package kellang;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public class Function {
    private final String name;
    private Action[] actions;
    private HashMap<String, Class> args;
    public static LinkedList<Function> functions = new LinkedList<>();


    public Function(String name, Action[] actions, HashMap<String, Class> args) {
        this.name = name;
        this.actions = actions;
        this.args = args;
        functions.add(this);
    }

    public void run(HashMap<String, Object> args) {
        for(Action act : this.actions) {
            act.run(args);
        }
    }

    public String getName() {
        return this.name;
    }

    public static Function getFunction(String fName) {
        for(Function func : functions) {
            if(Objects.equals(func.getName(), fName)) return func;
        }
        return null;
    }
}
