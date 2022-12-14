package kellang;

public class Type<T> {
    private T value;
    T getValue() {
        return this.value;
    }

    void setValue(T v) {
        this.value = v;
    }
}
