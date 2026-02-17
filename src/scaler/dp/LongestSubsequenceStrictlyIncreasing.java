package scaler.dp;

import java.util.Arrays;

public class LongestSubsequenceStrictlyIncreasing {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int longest = 0;
        for (int c: dp) {

            longest = Math.max(longest, c);
        }

        return longest;
    }

    static void main() {
        LongestSubsequenceStrictlyIncreasing  l = new LongestSubsequenceStrictlyIncreasing();
        int[] nums = new int[]{7,9,6,7,8,9,12};
        System.out.println(l.lengthOfLIS(nums));
    }
}