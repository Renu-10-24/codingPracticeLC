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
        System.out.println("for empty = " + isNull.test(null));
        System.out.println("for empty = " + isNull.test("Hello"));

        Predicate<String> isEmpty = s-> s.isEmpty();
        System.out.println("for empty = " + isEmpty.test(""));
        System.out.println("for empty = " + isEmpty.test("Hello .."));

        Predicate<String> p = isNull.negate().and(isEmpty.negate());
        System.out.println("For null  = " + p.test(null));
        System.out.println("For empty = " + p.test(""));
        System.out.println("For empty = " + p.test(" "));
        System.out.println("For empty = " + p.test("abddcd"));
    }
}
