package Recursion;

public class DecimalToBinary {

	public static void main(String[] args) {
		int number  = 233;
		DecimalToBinary dtob = new DecimalToBinary();
		System.out.println(dtob.decimalToBinary(number));
		System.out.println(dtob.decimalToBinaryString(number,""));
		System.out.println(dtob.binaryToDecimalIterative(11101001));
	}
	public long decimalToBinary(int number) {
		if(number ==0 || number ==1) {
			return number;
		}
		return decimalToBinary(number/2) * 10 +number%2;
	}
	public String decimalToBinaryString(int number, String result) {
		System.out.println("number : "+number);
		result = number%2+result;
		System.out.println("result : "+result+ " number>>1 : "+(number>>1));
		if((number/2) == 0) {
			return result;
		}
		return decimalToBinaryString((number>>1),result);
	}
	public int binaryToDecimalIterative(long binNum) {
		System.out.println();
		int number = 0;
		for(int i=0;binNum>0;i++) {
			if((binNum&1)==1) {
				number += 1<<i;
			}
			binNum=binNum/10;
		}
		return number;
	}
}
