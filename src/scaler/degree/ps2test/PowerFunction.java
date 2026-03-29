package scaler.degree.ps2test;

public class PowerFunction {
    static void main() {
        int A = 3;
        int B = 6;
        int C = 1000000003;
        PowerFunction p = new PowerFunction();
        int res = p.pow(A,B,C);
        System.out.println(res);
    }
    public int pow(int A, int B, int C){
        return (int)power(A,B,C);
    }
    public long power(int A,int B,int C){
        //cal A^B
        if(B==0){
            return 1;
        }
        if(B == 1){
            return A;
        }
        long x = power(A,B/2, C);
        long ans = ((x % C) * (x % C)) % C;
        if(B%2 == 0){
            return (int)ans;
        }else {
            long ansOdd = (ans * (A % C)) %C;
            return (int)(ansOdd);
        }
    }

}
