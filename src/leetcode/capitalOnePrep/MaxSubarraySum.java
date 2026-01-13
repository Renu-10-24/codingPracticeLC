package capitalOnePrep;

class MaxSubarraySum {
    public int maxSubArray(int[] nums) {
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

    static void main() {
        MaxSubarraySum m = new MaxSubarraySum();
        int[] nums= new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int answer = m.maxSubArray(nums);
        System.out.println(answer);
        nums = new int[]{-1};
        answer = m.maxSubArray(nums);
        System.out.println(answer);
        nums = new int[]{5,4,-1,7,8};
        answer= m.maxSubArray(nums);
        System.out.println(answer);
    }
}
