package leetcode.bitManipulation;

public class Division {
	public static void main(String args[]) {
	Solution s = new Solution();
	int dividend =1,divisor = 1;
	
	int result = s.divide(10,3);
	System.out.println(result);
	}
}
class Solution {
    public int divide(int dividend, int divisor) {
        int i =0;
        boolean isNegative = false;
        if((dividend < 0 && divisor >0)  && (dividend>0 && divisor<0)){
            isNegative = true;
        }
        if(dividend<0){
            dividend = -dividend;
        }
        if(divisor<0){
            divisor = -divisor;
        }
        while(divisor>=1){
            dividend = dividend<<i;
            divisor = divisor<<i;
        }
        if(isNegative)
            return -dividend;
        return dividend;
    }
}