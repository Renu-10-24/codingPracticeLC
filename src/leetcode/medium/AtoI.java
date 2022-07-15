package leetcode.medium;

import java.util.Scanner;

public class AtoI {

	public static void main(String[] args) {

		String inputString = "    -8968664575647-5477.9762casar";
		Soln s = new Soln();
		System.out.println("input : "+inputString);
		System.out.println("op is : "+s.myAtoi(inputString));
		inputString = "      -";
		System.out.println("input : "+inputString);
		System.out.println("op is : "+s.myAtoi(inputString));
		inputString = "      ";
//		System.out.println("input : "+inputString);
//		System.out.println("op is : "+s.myAtoi(inputString));
//		inputString = "      -4238nrnfiheruerbr";
//		System.out.println("op is "+s.myAtoi(inputString));
//		inputString = "42";
//		System.out.println("input : "+inputString);
//		System.out.println("op is : " + s.myAtoi(inputString));
	}
}

class Soln {
	public int myAtoi(String s) {
		boolean isNegative = false, isPositive = false;
		int result = 0;
		StringBuilder sb = new StringBuilder();
//    	s="      -4238nrnfiheruerbr";
		s = s.trim();
		if (!s.matches("[+-]{0,1}[0-9]*.*")) {
//			System.out.println("pattern no match :-)");
			return 0;
		} else {
			if(s.isEmpty()) {
				return 0;
			}
			if ('-' == s.charAt(0)) {
				isNegative = true;
			} else if ('+' == s.charAt(0)) {
				isPositive = true;
			} else if (Character.isDigit(s.charAt(0))) {
				isPositive = true;
				sb.append(s.charAt(0));
			}
			int i = 1;// first char is either sign or a digit..
			while (i < s.length()) {
				if (Character.isDigit(s.charAt(i))) {
					sb.append(s.charAt(i));
//				System.out.println("sb value is : "+sb.toString());
					i++;
				} else {
					break;
				}
			}
//			System.out.println("no match at index " + i + " char : " + s.charAt(i));
			if(i==1&&(isNegative || isPositive)) {//having only sign and no digits after
				return 0;
			}
			try {
				result = Integer.parseInt(sb.toString());
//			System.out.println("result : "+result);
			} catch (NumberFormatException ne) {
                	// overflow
                if(isNegative){
                    return Integer.MIN_VALUE;
                }else if(isPositive){
                    return Integer.MAX_VALUE;
                }
			}
		
			if (isNegative) {
					result = -result;
			}

		}
		return result;
	}
}
