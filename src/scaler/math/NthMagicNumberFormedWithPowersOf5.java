package scaler.math;

public class NthMagicNumberFormedWithPowersOf5 {
    public static void main(String args[]){
    Solution s = new Solution();
    int A =7;
    int x = s.solve(A);
    System.out.println(x);
    }
}
class Solution {
    public int solve(int A) {
        //get the base five representation of the number A(since we are considering only
        //numbers ending with a 5, zero's place bit is not considered.)
        int n = 0;
        for(int i=1;A>0;i++){
            if((A&1)==1){
                n += Math.pow(5,i);
            }
            A=A>>1;
        }
        return n;
    }
}