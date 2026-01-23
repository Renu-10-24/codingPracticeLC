package capitalOnePrep;

public class MaxSubarraySum {
    public static int maxSubArray(int[] nums) {
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }



    public static int dummyMethod(int[] nums,int target) {
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public void printStartEndIndexOfAllSubarraysOfSizeK(int[] nums, int k){
        int n =nums.length;
        System.out.print("[");
        for(int i: nums) {
            System.out.print(i+" ");
        }
        System.out.print("]");
        System.out.println("K : "+k);
        for(int i=0,j=(k-1);i<=n-k&&j<=nums.length-1;i++,j++){
            //j is end index of subarray
//            for(int j=(k-1+i);j<=nums.length-1;j++){
                System.out.println("["+i+","+j+"]");
            }
        }


    static void main() {
        MaxSubarraySum m = new MaxSubarraySum();
        int[] nums= new int[]{-2,1,-3,4,-1,2,1,-5,4};
        m.printStartEndIndexOfAllSubarraysOfSizeK(nums,3);
        int answer = m.maxSubArray(nums);
        System.out.println(answer);
        nums = new int[]{-1};
        m.printStartEndIndexOfAllSubarraysOfSizeK(nums,1);
        answer = m.maxSubArray(nums);
        System.out.println(answer);
        nums = new int[]{5,4,-1,7,8};
        m.printStartEndIndexOfAllSubarraysOfSizeK(nums,2);
        answer= m.maxSubArray(nums);
        System.out.println(answer);
        //migrating to parameterized tests instead of adding testcases like this.

    }
}
