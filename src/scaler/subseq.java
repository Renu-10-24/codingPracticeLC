package scaler;

import java.util.Arrays;

public class subseq {
    public static void main(String args[]){
        Solx s = new Solx();
        int[] A = new int[]{-2,8,0,3,2,7,4,9,6};
        int x = s.solve(A);
    }
}
class Solx {
    public int solve(int[] A) {
        Arrays.sort(A);
        for(int i : A){
            System.out.print(i+" ");
        }
        return 0;
    }
}