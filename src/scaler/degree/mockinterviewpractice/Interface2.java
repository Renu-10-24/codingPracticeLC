package scaler.degree.mockinterviewpractice;

public interface Interface2 {
    public default int defaultMethod(int x , int y){
        return x+y/2;
    }
    public abstract int anotherMethod(int x, int y);
}
