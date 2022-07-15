package leetcode.contest;

import java.util.Arrays;

public class SortOddEvenIndices {
    public static void main(String args[]) {
        Sol6 s = new Sol6();
        int[] nums = new int[]{4, 1, 2, 3};
        int[] out = s.sortEvenOdd(nums);
        for(int i : out){
            System.out.println(i);
        }
    }
}
class Sol6 {
    public int[] sortEvenOdd(int[] nums) {
        int[] evenArr = new int[(nums.length+1)/2];
        int[] oddArr = new int[nums.length/2];
        int e=0;
        int o=0;
//        Collections.sort(new ArrayList(),Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            if((i&1) == 0){
                evenArr[e++] = nums[i];
            }else{
                oddArr[o++] = nums[i];
            }
        }
//        Arrays.sort(evenArr, Collections.reverseOrder()); ll have to use the Integer type for this..
        Arrays.sort(evenArr);
        Arrays.sort(oddArr);
        reverse(evenArr);
        int x1=0;
        int x2= 0;
        for(int i=0;i<nums.length;i++){
            if((i&1)==0) {
                nums[i] = evenArr[x1++];
            }else{
                nums[i] = oddArr[x2++];
            }
        }
        return nums;
    }
    public static void reverse(int[] arr){
        for(int j=0,i=arr.length-1;j<i && i>=0;j++,i--){
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }
}