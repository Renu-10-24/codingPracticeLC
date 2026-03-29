package concurrency.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapCME {
    static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        //HashMap keys must be immutable - or we could land at inconsistencies with getting those keys
        map.put("A",1);
        map.put("B",2);
        map.put("C",31);
        map.put("D",4);
        map.put("E",5);

        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            iterator.remove();
            System.out.println("Entry key : "+entry.getKey());
            System.out.println("Entry val : "+entry.getValue());
            //removed all already iterated key had no impact like removing 1st key map.remove("A"); , now deleting a key not yet visited
            map.remove("E");
        }
        // this map.forEach is not printing anything because, we removed all elements from the map in the iterator
        map.forEach((k,v)-> System.out.println("key : "+k + " val : "+v));

    }
}
