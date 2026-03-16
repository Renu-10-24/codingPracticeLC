package OOPs.interfaces;

public class InterfacesDemo implements Interface1, Interface2{

    //this method HAS TO BE PUBLIC as interface methods are public NON static by default
    @Override
    public void print() {
        Interface1.super.print();           //we have to override the common default method and explicitly call out which interface method needs to be overwritten
    }

    static void main() {
        Interface1.staticMethod();
        InterfacesDemo d = new InterfacesDemo();
        d.print();
    }
}
