package OOPs.interfaces;

public class InterfacesDemo implements Interface1, Interface2{

    //this method HAS TO BE PUBLIC as interface methods are public NON static by default
    @Override
    public String print() {
        //we have to override the common default method and explicitly call out which interface method needs to be overwritten
        Interface1.super.print();
        System.out.println("default method overriden in the implementing class");
        return "default method overriden in the implementing class";
    }

    public static void main(String [] args) {
        Interface1.staticMethod();
        InterfacesDemo d = new InterfacesDemo();
        d.print();
    }
}
