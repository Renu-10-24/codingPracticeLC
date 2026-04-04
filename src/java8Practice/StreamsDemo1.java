import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsDemo1 {
    static void main() {
        StreamsDemo1 s1 = new StreamsDemo1();
        List<String> strings = List.of("apple","avocado","banana","grape","kiwi","guava","clementine","starfruit","strawberry","blueberry");
        Map<Character,List<String>> out = strings.stream().collect(Collectors.groupingBy(s->s.substring(0,1).toCharArray()[0],Collectors.toList()));
        out.forEach((k,v)->System.out.println(k+ " : "+v));
    }
}
