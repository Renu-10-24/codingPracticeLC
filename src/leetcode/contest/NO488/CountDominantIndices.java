package contest.NO488;

public class CountDominantIndices {
    //calculating running average - be very careful , always stick to sum and then calculate suffix avg with sum and next element
    public int dominantIndices(int[] nums) {
        int len =nums.length;
        int sum =0,avg =0;
        int count =0;
        for(int i=len-2,j=1;i>=0&& j<=len;i--,j++){
            sum = sum +nums[i+1];
            avg = (sum)/j;
//            output[i]=avg;
            if(nums[i]>avg){
                count++;
            }
        }
        return count;
    }

    static void main() {
        CountDominantIndices c= new CountDominantIndices();
        int[] nums = new int[]{50,98,75,26};
        int output=c.dominantIndices(nums);
        System.out.println(output);
        nums = new int[]{40,51,71};
        output=c.dominantIndices(nums);
        System.out.println(output);
    }
}
