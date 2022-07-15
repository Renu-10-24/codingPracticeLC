package scaler.math;

public class LCM {
    public static void main(String args[]) {
        G g = new G();
        int A = 4, B = 6;
        int gcd = g.GCD(A, B);
        System.out.println(gcd);
        int lcm = g.LCM(A, B);
        System.out.println(lcm);
    }
}
class G {
    public int LCM(int A, int B) {
        //formula based A*B/GCD
        int gcd = GCD(A,B);
        int lcm = A*B/gcd;
        return lcm;
    }
    public int GCD(int A, int B){
        if(B>A){
            int temp = B;
            B=A;
            A=temp;
        }
        while(B>0){
            int x = A%B;
            if(x==0){
                return B;
            }
            A=B;
            B=x;
        }
        return 1;
    }
}