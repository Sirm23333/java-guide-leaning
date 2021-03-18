package map.hashmap;

import java.util.*;

public class MyHashMap<k,v> implements Map<k,v> {

    transient MyEntry[] table;

    int DEFAULT_INITIAL_CAPACITY = 16;

    int size  = 0;

    public MyHashMap(){
        table = new MyEntry[DEFAULT_INITIAL_CAPACITY];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public v get(Object key) {
        int hash = hash(key);
        MyEntry<k,v> entry = table[hash];
        if(entry == null)
            return null;
        do{
            if(entry.key.equals(key))
                return entry.value;
        }while ((entry = entry.next) != null);
        return null;
    }

    @Override
    public v put(k key, v value) {
        int hash = hash(key);
        table[hash] = new MyEntry(key,value,table[hash],hash);
        return value;
    }

    @Override
    public v remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends k, ? extends v> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<k> keySet() {
        return null;
    }

    @Override
    public Collection<v> values() {
        return null;
    }

    @Override
    public Set<Map.Entry<k, v>> entrySet() {
        return null;
    }

    final int hash(Object key){
        return key.hashCode() % DEFAULT_INITIAL_CAPACITY;
    }
    static class MyEntry<k,v> implements Map.Entry<k,v>{

        k key;
        v value;
        MyEntry<k,v> next;
        int hash;

        public MyEntry(k key, v value, MyEntry<k, v> next, int hash) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }

        @Override
        public k getKey() {
            return key;
        }

        @Override
        public v getValue() {
            return value;
        }

        @Override
        public v setValue(v value) {
            v oleValue = value;
            this.value = value;
            return oleValue;
        }
    }
}
