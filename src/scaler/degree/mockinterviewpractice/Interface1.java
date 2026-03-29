package scaler.degree.mockinterviewpractice;

public interface Interface1 {
    public default int defaultMethod(int x , int y){
        return Math.abs(x)+Math.abs(y);
    }
    public abstract int anotherMethod(int x, int y);
    public static String myUtilMethod(int x, int y){
        return helperMethod()+"this is my util that need not be implemented by subclasses, they can use the method directly";
    }
    //interfaces can have private helper methods that other interface methods can use from java 9
    private static String helperMethod(){
        return "helper string generated";
    }
}
