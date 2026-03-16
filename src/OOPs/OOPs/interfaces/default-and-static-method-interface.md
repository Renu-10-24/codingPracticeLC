1. The main purpose: keep utilities close to the contract

Before Java 8, interfaces could only declare abstract methods. If you wanted helper logic related to that interface, you had to create a separate utility class.

Example before Java 8:

public interface Comparator<T> {
int compare(T a, T b);
}

Helper methods lived elsewhere:

public class Comparators {
public static <T> Comparator<T> reversed(Comparator<T> c) {
return (a, b) -> c.compare(b, a);
}
}

This separates the contract from the related behavior, which is not ideal.

2. Java 8 improvement

Now the utility can live inside the interface:

public interface Comparator<T> {

    int compare(T a, T b);

    static <T> Comparator<T> reversed(Comparator<T> c) {
        return (a, b) -> c.compare(b, a);
    }
}

Usage:

Comparator<String> comp = Comparator.reversed(String::compareTo);

Now everything related to Comparator lives in one place.

This improves:

API discoverability

logical grouping

readability

3. Static methods are NOT for inheritance

This is the important distinction.

Static interface methods:

are not inherited

cannot be overridden

are not part of polymorphism

Example:

interface A {
static void hello() {
System.out.println("A");
}
}

class B implements A {}

You must call:

A.hello();

Not:

new B().hello(); // not allowed

So static methods are not shared behavior for subclasses.