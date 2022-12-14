package kellang;

public class Function {
    private final String name;
    private Action[] actions;


    public Function(String name, Action[] actions) {
        this.name = name;
        this.actions = actions;
    }

    public void run() {
        for(Action act : this.actions) {
            act.run();
        }
    }

    public String getName() {
        return name;
    }
}
