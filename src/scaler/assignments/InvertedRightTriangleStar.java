package scaler.assignments;

import java.util.Scanner;

public class InvertedRightTriangleStar {
	public static void main(String[] args) {
		int t = 0;
		try (Scanner s = new Scanner(System.in)) {
			t = s.nextInt();
		}
		for (int i = 1; i <= t; i++) {
			for (int j = 1; j <= t -i+1; j++) {
				if (i == 1) {
					System.out.print("*");
				} else if (j == 1 || j == t - i+1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
