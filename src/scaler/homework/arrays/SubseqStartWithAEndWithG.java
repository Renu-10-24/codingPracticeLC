package scaler.homework.arrays;

public class SubseqStartWithAEndWithG {
    public static void main(String args[]){
        Solution_Subseq s = new Solution_Subseq();
        String A = new String("ABCGAG");
        int x =s.solve(A);
        System.out.println(x);
    }
}
class Solution_Subseq {
    public int solve(String A) {
        int count=0,ans=0;
        for(int i=0;i<A.length();i++){
            char ch = A.charAt(i);
            if(ch=='A'){
                count++;
            }
            if(ch=='G'){
                ans+= count;
            }
        }
        return ans;
    }
}