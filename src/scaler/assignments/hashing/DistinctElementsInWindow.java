package scaler.assignments.hashing;

import java.util.HashSet;
import java.util.Set;

public class DistinctElementsInWindow {
    public static void main(String args[]){
        int[] A = new int[]{5,3,2,5,1,5,2};
        A = new int[]{2,2,2,1,5,6,8,9};
        int k = 4;
        DistinctElementsInWindow d = new DistinctElementsInWindow();
        int[] x = d.solve(A,k);
        for(int i : x) {
            System.out.println(i);
        }
    }
    public int[] solve(int[] A, int k){
        int x=0;
        int[] output = new int[A.length-k+1];
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<k;i++){
            set.add(A[i]);
        }
        output[0] = set.size();
        for(int i=1;i<=A.length-k;i++){
            set.remove(A[i-1]);
            set.add(A[i+k-1]);
            output[i] = set.size();
        }
        return output;
    }
}
