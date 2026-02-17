package contest.biweelyno176;

import java.util.Arrays;

public class HouseRobberV {
        long[] dp = new long[100001];
        int n;

        public long rob(int[] nums, int[] colors) {
            Arrays.fill(dp, -1);
            n = nums.length;
            return solve(0, nums, colors);

        }

        public long solve(int index, int[] nums, int[] colors) {
            if (index >= n) {
                return 0;
            }
            if (dp[index] != -1) {
                return dp[index];
            }

            //if it is the last house,
            if (index == n - 1) {
                return nums[index];
            }


            long val1 = 0L, val2 = 0;

            //if chosen to rob ->
            if (colors[index] == colors[index + 1]) {
                val1 = nums[index] + solve(index + 2, nums, colors);
            } else {
                val1 = nums[index] + solve(index + 1, nums, colors);
            }
            //if chosen not to rob
            val2 = solve(index + 1, nums, colors);
            return dp[index] = Math.max(val1, val2);
        }

    static void main() {
        HouseRobberV v = new HouseRobberV();
        int[] nums = new int[]{1,4,3,5};
        int[] colors = new int[]{1,1,2,2};
        System.out.println(v.rob(nums,colors));
        nums = new int[]{3,1,2,4};
        colors = new int[]{2,3,2,2};
        System.out.println(v.rob(nums,colors));
        nums = new int[]{3,1,1,1,1,1};
        colors = new int[]{2,3,2,2,2,2};
        System.out.println(v.rob(nums,colors));
        nums = new int[]{53,26,23};
        colors = new int[]{1,2,2};
        System.out.println(v.rob(nums,colors));
    }
}