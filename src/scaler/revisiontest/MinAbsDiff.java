package scaler.revisiontest;

import java.util.Arrays;

public class MinAbsDiff {
    public int solve(int[] A) {
        A=Arrays.stream(A).sorted().toArray();
        int minAbsDiff = Integer.MAX_VALUE;
        for(int i=0;i<A.length-1;i++){
            int x = Math.abs(A[i]-A[i+1]);
            if(x<minAbsDiff){
                minAbsDiff =x;
            }
        }
        return minAbsDiff;
    }

    static void main() {
        MinAbsDiff m = new MinAbsDiff();
        int[] A = new int[]{};
        m.solve(A);
    }
}
