package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {
    static void main() {
        String s1 = "a";
        String s2 = "b";
        String s3 = "C";
        List<String> strings = new ArrayList(List.of(s1,s2,s3));
        Object o1 = "dafjl";
        Object o2 = 134;
        Object o3 = true;
        System.out.println(strings.size());
        for(String s : strings){
            System.out.println("Printing : "+s);
        }
        List<Object> objects = List.of(o1,o2,o3);
//        strings.addAll(objects); this is NOT allowed, as objects is not List<String>
        strings.addAll((List)objects); // explicit type cast would make it be accepted, but dangerous, because, it can cause runtime errors, when elements are accessed as string
        System.out.println(strings.size());
        for(String s : strings){
            System.out.println("Printing : "+s);//throws Runtime error
        }
    }
}
