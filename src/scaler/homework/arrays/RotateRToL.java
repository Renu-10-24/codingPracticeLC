package scaler.homework.arrays;

import java.util.*;

public class RotateRToL {
	public static void main(String[] args) {
		// Reading input
		int arrLen = 0, B;
		int[] arr;
		try (Scanner scanner = new Scanner(System.in)) {
			arrLen = scanner.nextInt();
			arr = new int[arrLen];
			for (int i = 0; i < arrLen; i++) {
				arr[i] = scanner.nextInt();
			}
			B = scanner.nextInt();
		}

		// left rotate - from left to right
		B = B % arrLen;
		for (int i = arrLen - B; i < arrLen; i++) {
			System.out.print(arr[i] + " ");
		}
		for (int i = 0; i < arrLen -B; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
