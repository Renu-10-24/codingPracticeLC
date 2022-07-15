package scaler;

public class gcd {
}
class Solution {
    public int solve(int A, int B) {
        int temp=0;
        if(B>A){
            temp=A;
            A=B;
            B=temp;
        }
        int x = gcd(A,B);
        return x;
    }
    public int gcd(int a,int b){
        int temp=0;
        while(a%b !=0){
            temp=a;
            a=b;
            b=temp%b;
        }
        return b;
    }
}