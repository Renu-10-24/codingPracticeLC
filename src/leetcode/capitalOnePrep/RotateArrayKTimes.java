package capitalOnePrep;

public class RotateArrayKTimes {
    static void main() {
        RotateArrayKTimes r = new RotateArrayKTimes();
        int[] nums = new int[]{0,1,2,3,4,5,6,7};
        r.rotate_using_extra_space(nums,2);
        r.rotate_reversing_array(nums,2);
        nums=new int[]{1};
        r.rotate_reversing_array(nums,2);
    }

    public void rotate_using_extra_space(int[] nums, int k) {
        int[] temp = new int[nums.length];
        int i = 0;
        k = k % nums.length;
        for (i = 0; i < k; i++) {
            temp[i] = nums[nums.length - k + i];
        }
        for (int j = 0; j < nums.length - k; j++) {
            temp[i++] = nums[j];
        }
        for (int i1 = 0; i1 < nums.length; i1++) {
            nums[i1] = temp[i1];
        }
    }

    public void rotate_inplace_cyclic_placement(int[] nums, int k) {
        int n =nums.length;

        for (int i = 0; i < k; i++) {
            int j =0;
            while(j<n) {
                j = j + k * i;
            }
            int temp = nums[j];
            int t= j;
            while(j>=0){
            nums[j] = nums[j -k];
            j = j-k;
            }
            nums[i] =temp;
        }
    }

    //reversing the array elements in place
    public void rotate_reversing_array(int[] nums, int k) {
        int start =0, end = nums.length-1;
        k=k%(end+1);
        if(start ==end){
            return;
        }
        reverse(nums,start,end);
        reverse(nums,0,k-1);
        reverse(nums,k,end);
    }
    public void reverse(int[] nums, int start, int end ){
        for(int i=start, j=end;i<j;i++,j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}