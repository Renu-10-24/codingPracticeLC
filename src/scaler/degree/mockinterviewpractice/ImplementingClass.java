package scaler.degree.mockinterviewpractice;

public class ImplementingClass implements Interface1 {

    //Default methods = are provided in java 8 to support evolving interfaces without breaking the clients -- at compile time as they DINT implement the new methds
    // in interface.
    //
    //when we implement interfaces with same default method, we should explicitly mention the Interface name whose default method we are implementing.
    //we have override only the ambiguous default methods when implementing multiple interfaces
    //otherwise no need to OVERRIDE the default methods, they have a default implementation in the interface.
//    @Override
//    public int defaultMethod(int x, int y) {
//        System.out.println("My custom implementation");
//        return Interface1.super.defaultMethod(x, y);
//}

    @Override
    public int defaultMethod(int x, int y) {
//        return x+y-10; either can provide its own implementation or use implementation from interface.
        return Interface1.super.defaultMethod(x, y);
    }



    @Override
    public int anotherMethod(int x, int y) {
        System.out.println("implementing abstract method frm interface");
        return x*y;
    }

    static void main() {
        Interface1 intrf1 = new ImplementingClass();
        intrf1.anotherMethod(2,1);
        System.out.println(Interface1.myUtilMethod(3,5));
    }
}
