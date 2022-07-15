package scaler.homework.arrays;

import java.util.Scanner;

public class RotateArrayNoExtraSpace {
	public static void main(String[] args) {
		int arrlen = 0, A[], b;
		try (Scanner s = new Scanner(System.in)) {
			arrlen = s.nextInt();
			A = new int[arrlen];
			for (int i = 0; i < arrlen; i++) {
				A[i] = s.nextInt();
			}
			b = s.nextInt();
		}
		b=b%arrlen;
		reverseElements(A, 0, arrlen - 1);
		reverseElements(A, 0, b - 1);
		reverseElements(A, b, arrlen - 1);
		for (int i = 0; i < arrlen; i++) {
			System.out.print(A[i] + " ");
		}
	}

	public static void reverseElements(int[] A, int startIndex, int endIndex) {
		int temp = 0;
		for (int i = startIndex, j = endIndex; i < j; i++, j--) {
			temp = A[j];
			A[j] = A[i];
			A[i] = temp;
		}
	}
}