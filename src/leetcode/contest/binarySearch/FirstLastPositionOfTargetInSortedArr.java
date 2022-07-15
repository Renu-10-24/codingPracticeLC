package leetcode.contest.binarySearch;

public class FirstLastPositionOfTargetInSortedArr {

	public static void main(String[] args) {
		int[] nums = new int[] {5,7,7,8,8,10};
		int target = 8;
//		int[] output = searchRange(nums,target);
		nums = new int[] {1};
		target = 1;
		int[] output = searchRange(nums,target);
		System.out.println("Indices that have the target element : ");
		for(int index : output) {
			System.out.println(index);
		}
	}
    public static int[] searchRange(int[] nums, int target) {
            int lo = 0, hi = nums.length;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] < target) {
                    lo = mid + 1;
                }else {
                    hi = mid;
                }
            }
            
            int i=lo;
            for(;nums.length>0 && i<nums.length && nums[i] == target;i++) {
            }
            int[] output = new int[2];
            if(i-lo==0){
                output[0]=-1;
                output[1]=-1;
                return output;
            }else{
                output[0]=lo;
                output[1]=i-1;
            }
            return output; 
        }
  //  
    public long minimumTime(int[] time, int totalTrips) {
        long lo = 0, hi = 100_000_000_000_000L;
        while (lo < hi) {
            long need = lo + (hi - lo) / 2;
            long trips = 0;
            for (int t : time) {
                trips += need / t;
            }
            if (trips < totalTrips) {
                lo = need + 1;
            }else {
                hi = need;
            }
        }
        return lo;
    }
}
