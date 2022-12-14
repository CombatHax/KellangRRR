package kellang;

import java.util.LinkedList;

public class Variable<T> {
    public static LinkedList<Variable> variables;
    private final String name;
    private T value;

    public Variable(String name, T value) {
        this.name = name;
        this.value = value;
        variables.add(this);
    }

    public String getName() {
        return name;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
