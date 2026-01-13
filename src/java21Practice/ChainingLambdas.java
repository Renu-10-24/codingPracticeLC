package java8;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class ChainingLambdas {
    public static void main(String args[]){
        Consumer<String> c1= s->System.out.println("c1 consumes "+s);
        Consumer<String> c2= s->System.out.println("c2 consumes "+s);
        Consumer<String> c3 = s-> {
            c1.accept(s);
            c2.accept(s);
        };
        c3.accept("Hello");

        Predicate<String> isNull = s-> s == null;
        System.out.println("Predicate checks for null");
        System.out.println("for null  : " + isNull.test(null));
        System.out.println("for Hello : " + isNull.test("Hello"));

        Predicate<String> isEmpty = s-> s.isEmpty();
        System.out.println("Predicate checks for value empty");
        System.out.println("for empty    : " + isEmpty.test(""));
        System.out.println("for Hello .. : " + isEmpty.test("Hello .."));

        Predicate<String> p = isNull.negate().and(isEmpty.negate());
        System.out.println("Predicate checks for value not null and not empty");
        System.out.println("For null         : " + p.test(null));
        System.out.println("For empty        : " + p.test(""));
        System.out.println("For blank space  : " + p.test(" "));
        System.out.println("For valid string : " + p.test("abddcd"));
    }
}
