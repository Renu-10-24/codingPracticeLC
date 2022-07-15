package Recursion;

public class BinarySearch {
    public static void main(String args[]) {
        BS bs = new BS();
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 5;
        int isFound = bs.search(nums, target);
        System.out.println(isFound);
    }
}
//getting stack overflow, have to fix it..
class BS {
    public int search(int[] nums, int target) {
        int startIndex =0, endIndex = nums.length-1;
        int mid = (endIndex - (endIndex-startIndex)/2);
        if(target==nums[mid]){
            return mid;
        }else if(target <nums[mid]){
           return search(nums,startIndex,mid-1,target);
        }else{
            return search(nums,mid+1,endIndex, target);
        }
    }
    public int search(int[] nums,int startIndex, int endIndex, int target){
        int mid = (endIndex - (endIndex-startIndex)/2);
        if(startIndex > endIndex || (startIndex==endIndex && nums[startIndex] != target)){
            return -1;
        }
        /*if(mid==nums.length-1 && target>nums[mid]){
            return -1;
        }
        if(mid==0 && target<nums[mid]){
            return -1;
        }*/
        if(nums[mid]==target){
            return mid;
        }else if(target <nums[mid]){
            return search(nums,startIndex,mid-1,target);
        }else{
            return search(nums,mid+1,endIndex,target);
        }
    }
}