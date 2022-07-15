package scaler.math.gcd;

public class GCDOfArray {
    public static void main(String args[]) {
        GCDOfArray g = new GCDOfArray();
        int[] A = new int[]{12, 14, 16, 18, 20, 24};
        int x = g.gcdOfArray(A);
        System.out.println(x);
    }
    public int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public int gcdOfArray(int[] A){
        int gcd = gcd(A[0],A[1]);
        for (int i = 2; i < A.length; i++) {
            gcd = gcd(gcd,A[i]);
            if(gcd==1){
                return gcd;
            }
        }
        System.out.println("gcd of entire array is : "+gcd);
        return gcd;
    }
}
