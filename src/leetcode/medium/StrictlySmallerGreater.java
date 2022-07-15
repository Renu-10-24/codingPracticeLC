package leetcode.medium;

import java.util.Arrays;

public class StrictlySmallerGreater {
	public static void main(String args[]) {
		Solution s = new Solution();
		int[] A = new int[] { 913, 440, 865, 72, 612, 445, 101, 994, 356, 91, 461, 930, 583, 448, 543, 170, 333, 107,
				425, 73, 172, 416, 899, 826, 659, 561, 314, 25, 110 };
		System.out.println(s.solve(A));
	}
}

class Solution {
	public int solve(int[] A) {
		int countMax = 0, max = Integer.MIN_VALUE, countMin = 0, min = Integer.MAX_VALUE;

		for (int i = 0; i < A.length; i++) {
			if (A[i] > max) {
				max = A[i];
			}
			if (A[i] < min) {
				min = A[i];
			}
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] == max) {
				countMax++;
			}
			if (A[i] == min) {
				countMin++;
			}
		}
		if (max == min) {
			return 0;
		}
		return A.length - countMax - countMin;
	}
}
