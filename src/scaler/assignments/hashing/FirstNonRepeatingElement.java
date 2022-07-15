package scaler.assignments.hashing;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingElement {
    public static void main(String args[]){
        Solution s = new Solution();
        int [] A = new int[]{10, 5, 3, 4, 3, 5, 6};
        int x= s.solve(A);
        System.out.println(x);
    }
}
//similarly , we can be asked for the first repeating element as well..

class Solution {
    public int solve(int[] A) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<A.length;i++){
            int val=map.getOrDefault(A[i],0);
            map.put(A[i],++val);
        }
        for(int i=0;i<A.length;i++){
            int val=map.get(A[i]);
            if(val==1){
                return A[i];
            }
        }
        return -1;
    }
}