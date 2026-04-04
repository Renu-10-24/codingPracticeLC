package scaler.degree.mockinterviewpractice;

import java.util.List;

public class StreamToArrayDemo {
    static void main() {
        List<String> stringList = List.of("abc","def","ghi");
        String[] stringArray = stringList.toArray(String[]::new); // without streams, direct conversion of collection / list to array
        // if we have to use stream api, use this instead
//        String[] stringArray = stringList.stream().toArray(String[]::new); // without streams, direct conversion of collection / list to array
        for(String str : stringArray){
            System.out.println(str);
        }
    }
}
