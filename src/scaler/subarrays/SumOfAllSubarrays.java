package scaler.subarrays;

public class SumOfAllSubarrays {
    public static void main(String args[]){
    Solution s = new Solution();
    int[] A = new int[]{1,2,3,4,-1,2,0,-7,9,-5};
    A = new int[]{6,5,4,3,2,1};
    long x = s.subarraySum(A);
    System.out.println(x + " -40%7 "+ -40%7 );
    }
}
class Solution {
    public long subarraySum(int[] A) {
        long allSubarraySum = 0;
        for(int x=0;x<A.length;x++){
            long subarraySum=0;
            for(int i=x;i<A.length;i++){
                subarraySum += A[i];
                allSubarraySum += subarraySum;
            }
        }
        return allSubarraySum;
    }
    public long subarraySum_slidingWindow(int[] A) {
        long allSubarraySum = 0;
        for(int x=0;x<A.length;x++){
            long subarraySum=0;
            for(int i=x;i<A.length;i++){
                subarraySum += A[i];
                allSubarraySum += subarraySum;
            }
        }
        return allSubarraySum;
    }
}
