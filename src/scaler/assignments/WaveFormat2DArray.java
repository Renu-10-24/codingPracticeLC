package scaler.assignments;

import java.util.Scanner;

public class WaveFormat2DArray {

	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		Scanner s = new Scanner(System.in);
		int rows, cols, A[][];
		rows = s.nextInt();
		cols = s.nextInt();
		A = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				A[i][j] = s.nextInt();
			}
		}
		for (int i = 0; i < cols; i++) {

			if (i % 2 == 0) {
				for (int j = 0; j < rows; j++) {
					System.out.println(A[i][j]);
				}
			} else {
				for (int j = rows - 1; j >= 0; j--) {
					System.out.println(A[i][j]);
				}
			}
		}
	}
}