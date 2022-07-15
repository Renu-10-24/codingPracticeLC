package leetcode.contest;

public class SumOfThree {

	public static void main(String[] args) {
		Solution1 s =new Solution1();
		long num = 33l;
		long[] output = s.sumOfThree(num);
		for(long x : output) {
			System.out.println(x);
		}
	}

}
class Solution1 {
    public long[] sumOfThree(long num) {
        long[] output = null;
        if(num%3==0){
        	output = new long[3];
        	output[1] = num/3;
        	output[0] = output[1]-1;
        	output[2] = output[1]+1;
        }
        return output;
    }
}