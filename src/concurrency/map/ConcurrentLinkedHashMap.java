package concurrency.map;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConcurrentLinkedHashMap {
    //there is no concurrent version of LinkedHashMap , if you want to maintain the insertion order of keys, we have to use a LinkedHashMap
    static void main() {
        Map<Integer,String> map = new LinkedHashMap<>();
        map.put(1,"A");
        map.put(2,"B");
        map.put(3,"C");
        map.put(2,"D");
        map.forEach((k,v)-> System.out.println("key : "+k+" val : "+v));
        Map<Integer,String> syncMap = Collections.synchronizedMap(new LinkedHashMap<>());
        synchronized(syncMap){
            var i = syncMap.entrySet().iterator();
            while(i.hasNext()){
                Map.Entry<Integer,String> entry = i.next();
                System.out.println("Key : "+entry.getKey());
                System.out.println("Val : "+entry.getValue());
            }
            for(Map.Entry<Integer,String> entry : syncMap.entrySet()){

            }
            syncMap.forEach((key, value) -> System.out.println(key + " " + value));
        }


    }

}
