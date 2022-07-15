package slidingWindow.scaler;

public class MaxSumSubarray {

}
class Solution {
    public int maxSubArray(final int[] A) {
        int maxSubArrSumLenK=0,sum =0,k=0,maxSubArrSum=A[0];
            for(int x=0;x<A.length;x++){
                maxSubArrSumLenK += A[x];
                k=x+1;
                //applying sliding window technique for subarray size k
                int startIndex = 1;
                int endIndex = A.length-1-(k-1);//n-k
                sum = maxSubArrSumLenK;
                if(sum > maxSubArrSum) {
                    maxSubArrSum = sum;
                }
                //window from startIndex to endIndex 
                for(int i=startIndex;i<=endIndex;i++){
                    sum += (- A[i-1]) + A[i+k-1];
                      if(sum > maxSubArrSum) {
                        maxSubArrSum = sum;
                    }
                }
            }
            return maxSubArrSum;
        }
}