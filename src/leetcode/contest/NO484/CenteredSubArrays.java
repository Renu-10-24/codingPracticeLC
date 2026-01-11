package contest.NO484;

import java.util.HashSet;
import java.util.Set;

        class CenteredSubArrays {
            public int centeredSubarrays(int[] nums) {
                int count = 0;
                for (int start = 0; start < nums.length; start++) {
                    Set<Integer> set = new HashSet<>();
                    int sum = 0;
                    for (int i = start; i < nums.length; i++) {
                        sum += nums[i];
                        set.add(nums[i]);
                        if (set.contains(sum)) {
                            count++;
                        }
                    }
                }
                return count;
            }
            static void main() {
                CenteredSubArrays c = new CenteredSubArrays();
                int[] nums = new int[]{8, 9, 0};
                nums = new int[]{-1, 1, 0};
                int x = c.centeredSubarrays(nums);
                System.out.println(x);
            }
        }