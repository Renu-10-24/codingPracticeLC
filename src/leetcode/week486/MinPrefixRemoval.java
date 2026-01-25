package week486;

public class MinPrefixRemoval {
    public int minimumPrefixLength(int[] nums) {
        int n=nums.length-1,count =n;
        for(int i=n;i>0;i--){
            if(nums[i]>nums[i-1]){
                // System.out.println(count);
                count =i-1;
            }else{
                break;
            }
        }
        return count;
    }

    static void main() {
        MinPrefixRemoval min = new MinPrefixRemoval();
        int[] nums = new int[]{1,-1,2,3,3,4,5};
        nums = new int[]{4,3,-2,-5};
        nums = new int[]{1,2,3,4};
        int out = min.minimumPrefixLength(nums);
    }
}