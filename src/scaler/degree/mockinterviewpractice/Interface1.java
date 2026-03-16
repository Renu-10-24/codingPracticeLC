package scaler.degree.mockinterviewpractice;

public interface Interface1 {
    public default int defaultMethod(int x , int y){
        return Math.abs(x)+Math.abs(y);
    }
    public abstract int anotherMethod(int x, int y);
}
