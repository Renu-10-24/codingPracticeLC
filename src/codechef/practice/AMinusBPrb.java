package codechef.practice;

import java.util.Scanner;

public class AMinusBPrb {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int val1 = sc.nextInt();
			int val2 = sc.nextInt();
			int ans = val1 - val2;
			int x = ans;
			int digitCount = 0;
			while (ans > 0) {
				digitCount++;
				ans /= 10;
			}
			x--;
			if (x < Math.pow(10, digitCount)) {
				x++;
			}
			System.out.println(x);
		}
	}
}
