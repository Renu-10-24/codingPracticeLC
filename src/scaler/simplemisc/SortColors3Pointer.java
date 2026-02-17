package scaler.simplemisc;

 public class SortColors3Pointer {
    public void sortColors(int[] nums) {
        //3 pointers p0 - tracking start of 0s, curr tracking start of end of 1s and p2 tracking start of 2s
        //initially both p0, curr at 0
        int curr = 0;
        int p0=0,p2= nums.length-1;
        while(curr<=p2){
            if(nums[curr] == 0){
                //swap with p0
                int temp = nums[curr];
                nums[curr++]=nums[p0];
                nums[p0++] = temp;
            }else if(nums[curr] ==2){
                int temp = nums[curr];
                nums[curr]=nums[p2];
                nums[p2--]=temp;
            }else{
                curr++;
            }
        }
        System.out.println();
        for(int i : nums){
            System.out.println(i);
        }
    }


     static void main() {
         SortColors3Pointer s= new SortColors3Pointer();
         int[] nums = new int[]{2,0,2,1,0,1};
         s.sortColors(nums);
         nums = new int[]{1,2,2,0,0,2,1,1,1,2,1,2,2,0,2,1,0};
         s.sortColors(nums);
     }
}