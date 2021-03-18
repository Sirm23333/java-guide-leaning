package map;

import map.hashmap.MyHashMap;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {

    Map<String,String> map;
    HashMap<String,String> hashMap = new HashMap<>();

    public static void main(String[] args) {
        Map<String,String> map = new MyHashMap();
//        map.put("Aa","1");
//        map.put("BB","2");
//        System.out.println("Aa".hashCode() + " " +map.get("Aa"));
//        System.out.println("BB".hashCode() + " " +map.get("BB"));
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        Hashtable<Integer,Integer> hashTable = new Hashtable<>();
        LinkedHashMap<Integer,Integer> linkedHashMap = new LinkedHashMap<>();
        TreeMap<String,String> treeMap = new TreeMap<>();
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();

    }


}
