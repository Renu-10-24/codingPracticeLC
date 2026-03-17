package OOPs.interfaces;

public interface Interface2 {
    default String print(){
        System.out.println("in Interface2 print");
        return "in Interface2 print";
    }
}
