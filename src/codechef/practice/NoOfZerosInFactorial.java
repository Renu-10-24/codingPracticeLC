package codechef.practice;

import java.util.Scanner;

public class NoOfZerosInFactorial {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int noftimes = sc.nextInt();
			for (int i = 0; i < noftimes; i++) {
				int value = sc.nextInt();
				int count = getValue(value / 5);
				System.out.println(String.valueOf(count));
			}
			for (int i = 0; i < noftimes; i++) {
				int n = sc.nextInt();
				int count = getNoOfZerosInFactorial(n);
				System.out.println(count);
			}
		}
	}

	private static int getValue(int n) {
		if (n <= 5) {
			return n;
		}
		return getValue(n / 5) + n;
	}
	
	private static int getNoOfZerosInFactorial(int n) {
		int x=5;
		int noOfZeros = 0;
		while(n/x>0) {
			noOfZeros += n/x;
			x *= 5;
		}
		return noOfZeros;
	}

}
