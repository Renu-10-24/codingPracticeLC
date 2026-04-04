package scaler.strings;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToLowerCase {
    public static void main(String args[]) {
        Sol s = new Sol();
//        char[] A = {'S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y'};
//        char[] charArray = s.to_lower(A);
//        for(char c : charArray){
//            System.out.print(c);
//        }
        char[] A = {'S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0'};
        char[] charArray = s.to_lower(A);
        for(char c : charArray){
            System.out.print(c);
        }
        Comparator<Map.Entry<Character,Long>> c = (e1,e2)->e1.getValue().compareTo(e2.getValue());
        //streams
        String str = "javaprogram";
        Map<Character,Long> map = str.chars().mapToObj(i->(char)i).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        map.forEach((k,v)-> System.out.println("char : "+k+" count : "+v));
        //sorting the map of (Character, Count) in decreasing order of counts
        Stream<Map.Entry<Character,Long>> stream = map.entrySet().stream().sorted(c.reversed());
        Map<Character,Long> linkedHashMap = stream.collect(
                Collectors.toMap(e->e.getKey(),
                        e->e.getValue(),
                        (oldVal, newVal)-> oldVal, LinkedHashMap::new
                )
        );
        linkedHashMap.forEach((k,v)-> System.out.println("key : "+k+" val : "+v));
    }
}
class Sol {
    public char[] to_lower(char[] A) {
        for(int i=0;i<A.length;i++){
//            if(Character.isUpperCase(A[i])){
            if(A[i]>='A' && A[i]<='Z'){
                A[i]=Character.toLowerCase(A[i]);
            }
        }
        return A;
    }

    //if all chars are alphabet or numbers, return 1 else return 0
    public int solve1(char[] A) {
        for(int i=0;i<A.length;i++){
//            if(Character.isUpperCase(A[i])){
            if(!Character.isUpperCase(A[i]) && !Character.isLowerCase(A[i]) && !Character.isDigit(A[i]) ){
                return 0;
            }
        }
        return 1;
    }

    public int solve2(char[] A) {
        for(int i=0;i<A.length;i++){
            if(!Character.isUpperCase(A[i]) && !Character.isLowerCase(A[i]) ){
                return 0;
            }
        }
        return 1;
    }
}
