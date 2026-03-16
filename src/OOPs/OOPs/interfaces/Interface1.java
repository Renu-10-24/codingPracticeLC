package OOPs.interfaces;

public interface Interface1 {
    default void print(){
        System.out.println("in Interface1 print");
    }

    static void staticMethod() {
        System.out.println("Interface can have its OWN TYPE specific implementation, that the classes CANNOT Override through Inheritance. " +
                "These are Utility/ Helper methods that subclasses cannot share behavior with, they HAVE to call with InterfaceType.. ");
    }
}
