package scaler.degree.dsa1test;

public class OnesComplement {
    static void main() {
        OnesComplement o = new OnesComplement();
        int A = 17;
        int result = o.solve(A);
        System.out.println("ans : "+(1<<0));
        System.out.println(result);
    }
    public int solve(int A){
        int result = 0;
        int msb = -1;
        for(int x =30;x>=0;x--){
            int t = (1<<x);
            if((A&t) == t){
                msb = x;
                break;
            }
        }
        for(int i =0;i<= msb;i++){
            int t = (1<<i);
            if((A&t) != t){
                result += t;
            }
        }
        return result;
    }
}
