package scaler.homework.arrays;

public class LongestConsecutive1sFlipKZeros {
    public static void main(String args[]) {
        SFlipK0s s = new SFlipK0s();
        int[] nums = {};
        int k=0;
        nums=new int[]{1,1,1,0,0,0,1,1,1,1,0};
//        nums = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        nums = new int[]{0,0,0,1};
        k = 2;
        int x = s.longestOnes(nums, k);
        System.out.println(x);
    }
}
class SFlipK0s {
    public int longestOnes(int[] nums, int k) {
        int start=0,end = 0,flip=0,currLen = 0, length=0, maxLength = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                end++;
                if(flip == k){
                    currLen = end-start;
                    if(currLen>maxLength){
                        maxLength=currLen;
                    }
                }
            }
            if(nums[i]==0){
                flip++;
                if(flip<=k) {
                    end++;
                }else if(flip==k+1){
                    length = end-start;
                    if(length>maxLength){
                        maxLength=length;
                    }
                    flip=k;
                    while(nums[start]==1){
                        start++;
                    }
                    start++;
                    end=i+1;
                }
            }
        }
        return maxLength;
    }
}