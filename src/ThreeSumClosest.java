import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] nums = new int[] { -1, 2, 1, -4 };
		nums = new int[] { 0, 0, 0, 0 };
		int target = 1;
		nums = new int[] { 1, 1, 1, 1 };
		target = 4;
		nums = new int[] { 1, 1, 1, 0 };
		target = 100;
		nums = new int[] {-1,2,1,-4};
		target = 1;		
		Solution s = new Solution();
		System.out.println(s.threeSumClosest(nums, target));
	}
}

class Solution {
	public int threeSumClosest(int[] nums, int target) {
		int closestSum = nums[0] + nums[1] + nums[nums.length - 1];
		int currSum = closestSum;
		// sort the array
		Arrays.sort(nums);
		int pointer1 = 0, pointer2 = 0, pairSumReq = 0, currPairSum = 0;
		// nums[i] is fixed, pointer1 and pointer2 keep moving to match target...
		for (int i = 0; i < nums.length; i++) {
			pairSumReq = target - nums[i];
			pointer1 = 0;
			pointer2 = nums.length - 1;
			while (pointer1 < pointer2) {
				if (i == pointer1 || i == pointer2) {
					pointer1++;
					continue;
				}

				currSum = nums[i] + nums[pointer1] + nums[pointer2];
				currPairSum = nums[pointer1] + nums[pointer2];
				if (currPairSum == pairSumReq) {
					return target;
				} else {
					if (currPairSum < pairSumReq) {
						pointer1++;
					} else if (currPairSum > pairSumReq) {
						pointer2--;
					}
				}
				if (Math.abs(target - currSum) < Math.abs(target - closestSum)) {
					closestSum = currSum;
				}
			}
		}
		return closestSum;
	}
}
