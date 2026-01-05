package leetcode.contest;

public class EqualIndexAndDivisibleByK {

	public static void main(String[] args) {
		S2 s =new  S2();
		int[] nums = new int[] {3,1,2,2,2,1,3};
		int k = 2;
		int x = s.countPairs(nums, k);
		System.out.println(x);
		nums = new int[] {1,2,3,4};
		k= 1;
		x = s.countPairs(nums, k);
		System.out.println(x);
	}

}
class S2 {
    public int countPairs(int[] nums, int k) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;i<nums.length;i++){
            if(nums[i]==nums[j] && ((i*j)%k==0)){
                count++;
            }
        }
    }
        return count;
    }
}