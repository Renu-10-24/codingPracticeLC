package scaler.homework.arrays;

import java.util.Arrays;
import java.lang.System;


public class MinAbsDiffOfElementsInArray {
    public static void main(String args[]) {
        Sol4 s = new Sol4();
        int[] a = new int[]{5, 17, 100, 11};
        int output = s.solve(a);
        System.out.print(output);
    }
}
class Sol4 {
    public int solve(int[] A) {
        int minAbsDiff =Integer.MAX_VALUE;
        Arrays.sort(A);
        for(int i=0;i<A.length-1;i++){
            int x = Math.abs(A[i]-A[i+1]);
            if(x<minAbsDiff){
                minAbsDiff=x;
            }
        }
        return minAbsDiff;
    }
}
