package cau_hoi_java.day_3;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

public class HashtableAndHashmap {
    public static void main(String[] args) {

        HashMap<Integer,String> hashMap = new HashMap<>();

        hashMap.put(1,"Apple");
        hashMap.put(2, "Orange");
        hashMap.put(3, "Banana");

        System.out.println("HashMap: ");
        iterateMap(hashMap);

        Hashtable<Integer,String> hashtable = new Hashtable<>();

        hashtable.put(1, "Apple");
        hashtable.put(2, "Orange");
        hashtable.put(3, "Banana");

        System.out.println("Hashtable: ");
        iterateMap(hashtable);

    }

    public static void iterateMap(Map<Integer, String> map) {
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            Integer key = iterator.next();
            String value = map.get(key);
            System.out.println("Key" + key + ", Value" + value);
        }


    }
}
