package scaler.math;

import org.w3c.dom.ls.LSOutput;

public class ExcelColumnNumber {
    public static void main(String args[]){
        SolPermutations s = new SolPermutations();
        String A = "ABCD";
        int x = s.titleToNumber(A);
        System.out.println(x);
    }
}
class SolPermutations {
    public int titleToNumber(String A) {
        int rank = 0;
        int len = A.length()-1;
        for(int i=len;i>=0;i--){
            int x = A.charAt(i)-64;
            rank += x*Math.pow(26,len-i);
        }
        return rank;
    }
}
