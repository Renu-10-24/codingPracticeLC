package scaler.advanced.arrays.subarrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxNonNegativeSubarray {
    public static void main(String args[]) {
        Solution s = new Solution();
        int[] A = new int[]{1376710097, 1330573317, 1687926652};
//        A = new int[]{1, 2, 5, -7, 2, 5};
//        A= new int[]{-846930886, -1714636915, 424238335, -1649760492};
        int[] output = s.maxset(A);
        for(int i : output) {
            System.out.println(i);
        }
    }
}
class Solution {
    public int[] maxset(int[] A) {
        // Kadane's algorithm to find the max subarraysum...
        long ans = 0;
        long sum = 0;
        int startIndex = 0;
        List<Integer> temp = new ArrayList<Integer>();
        Map<Long, List<Integer>> map = new HashMap<Long, List<Integer>>();
        Map<Long, Integer> startIndexMap = new HashMap<Long, Integer>();
        List<Integer> output = null;
        for (int i = 0; i < A.length; i++) {
            if(A[i]>=0) {
                sum += A[i];
            }
            if (A[i]>=0 && sum >= ans) {
                ans = sum;
                // for first insert, update startIndex.
                if (temp.isEmpty()) {
                    startIndex = i;
                    startIndexMap.put(ans, startIndex);
                }
                if (!map.containsKey(ans)) {
                    map.put(ans, temp);
                    // startIndexMap.put(ans,startIndex);
                }
                temp.add(A[i]);
            }
            if(A[i]<0 && i != A.length-1 && temp.size()>0) {
                sum = 0;
                temp = new ArrayList<Integer>();
            }
            if (i == A.length - 1) {
                List<Integer> currList = map.get(ans);
                if (temp != null && currList != null && temp.size() > currList.size()) {
                    map.put(ans, temp);
                }
            }
        }
        output = map.get(ans);
        if (output == null) {
            return new int[0];
        }
        int[] outputArr = new int[output.size()];
        for (int i = 0; i < outputArr.length; i++) {
            outputArr[i] = output.get(i);
        }
        return outputArr;
    }
}