package utils;

import java.util.LinkedList;

public class OrderedDict<K, V> {
    private LinkedList<K> keys = new LinkedList<>();
    private LinkedList<V> values = new LinkedList<>();

    public OrderedDict() {}

    public LinkedList<K> getKeys() {
        return keys;
    }

    public LinkedList<V> getValues() {
        return values;
    }

    public V get(K name) {
        for(K key : this.keys) {
            if(key == name) return this.values.get(this.keys.indexOf(K));
        }
        return null;
    }

    public void add(K name, V value) {
        if(get(name) == null) {
            this.keys.add(name);
            this.values.add(value);
        } else {
            for(K key : this.keys) {
                if(key == name) this.values.set(this.keys.indexOf(name), value);
            }
        }
    }
}
