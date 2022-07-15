package scaler.assignments.bitManipulation;

public class AddTwoBinaryStrings {
	public static void main(String[] args) {
		Solution s = new Solution();
		// bit wise operator RHS is n and LHS is no.of times the operator is applied
		System.out.println("1<<20 : 1 multiplied with 2 20 times =1*2^20 = 1048576 " + (1 << 20));

		System.out.println("20<<1 : to multiply 20 by 2 : which gives 20*2 " + (20 << 1));
		System.out.println("20>>1 : to divide 20 by 2 : which gives 20/2 " + (20 >> 1));
		StringBuilder sb = new StringBuilder();
		sb.append("");
		System.out.println(sb.toString());
		int carry = 1;
		sb.insert(0, carry);
		System.out.println(sb.toString());
//		System.out.println("100 + 11 : ");
//		System.out.println("return val : " + s.addBinary("100", "11"));
//		System.out.println("10000 + 1111 : ");
//		System.out.println("return val : " + s.addBinary("10000", "1111"));
//		System.out.println("1000000 + 1111 : ");
//		System.out.println("return val : " + s.addBinary("1000000", "1111"));
//		System.out.println("100 + 11111000 : ");
//		System.out.println("return val : " + s.addBinary("100", "11111000"));
//		System.out.println("111 + 1111 : ");
//		System.out.println("return val : " + s.addBinary("111", "1111"));
//		System.out.println("10 1011 0111   + 1 0000 1101 1000   : ");
//		System.out.println("return val : " + s.addBinary("1010110111", "1000011011000"));
		//1110000000010110111010100100111
		//101001
		System.out.println(" 111 0000 0000 1011 0111 0101 0010 0111  + 10 1001  : ");
		System.out.println("return val : " + s.addBinary("1110000000010110111010100100111", "101001"));
	}
}

class Solution {
	public String addBinary(String A, String B) {
		int digit = 0, carry = 0, a = 0, b = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = A.length() - 1, j = B.length() - 1;; i--, j--) {
			if (i >= 0)
				a = A.charAt(i) - '0';
			if (j >= 0)// minus char 0 which has ascii value of 48
				b = B.charAt(j) - '0';
			if (i >= 0 && j >= 0) {//when carry is 1 and digits are 0,0 - reset carry
				digit = a + b + carry;
				if(carry==1 && digit == 1) {
					carry = 0;
				}
				if (digit == 2) {
					digit = 0;
					carry = 1;
				} else if (digit == 3) {
					digit = 1;
					carry = 1;
				}
				sb.insert(0, digit);
			} else if (i < 0 && j < 0) {
				if (carry == 1) {
					sb.insert(0, carry);
				}
				return sb.toString();
			} else if (i < 0) {
				digit = b + carry;
				if(carry==1 && digit == 1) {
					carry = 0;
				}
				if (digit == 2) {
					digit = 0;
					carry = 1;
				} else if (digit == 3) {
					digit = 1;
					carry = 1;
				}
				sb.insert(0, digit);
			} else if (j < 0) {
				digit = a + carry;
				if(carry==1 && digit == 1) {
					carry = 0;
				}
				if (digit == 2) {
					digit = 0;
					carry = 1;
				} else if (digit == 3) {
					digit = 1;
					carry = 1;
				}
				sb.insert(0, digit);
			}
		}
	}
}
