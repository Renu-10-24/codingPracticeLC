package scaler.subarrays;

public class SumOddLengthSubarrays {
    public static void main(String args[]){
        SolSubarr s = new SolSubarr();
        int[] arr = new int[]{2,4,5,2,6};
//        arr = new int[]{3,4,1,2};
//        arr = new int[]{3,4,1};
        arr = new int[]{2,4,5,1};
//        arr = new int[]{2};
        int sum =s.sumOddLengthSubarrays(arr);
        System.out.println(sum);
    }
}
class SolSubarr {
    public int sumOddLengthSubarrays(int[] arr) {
        //using sliding window technique for each odd length, k
        int sum=0;
        int subarrSum = 0;
        for(int k=1; k<=arr.length;k=k+2){
            subarrSum = 0;
            for(int i=0;i<k;i++){
                subarrSum += arr[i];
            }
            int prevsum = subarrSum;
            sum += subarrSum;
            for(int i=1;i<=arr.length-k;i++){
                int currSum  = prevsum -arr[i-1]+arr[i+k-1];
                prevsum=currSum;
                sum += currSum;
            }
        }
        return sum;
    }
}