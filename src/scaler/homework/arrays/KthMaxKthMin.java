package scaler.homework.arrays;

import java.util.Arrays;

public class KthMaxKthMin {

	public static void main(String[] args) {
		Ax ax = new Ax();
		int[] A = new int[] { 10, 25, 30, 140, 57 };
		int B = 2;
		int t = ax.solve(A, B);
		System.out.println(t);
		int t1 = ax.solve1(A, B);
		System.out.println(t1);
		A = new int[] { 5, 17, 100, 11 };
		B = 1;
		t = ax.solve(A, B);
		System.out.println(t);
		t1 = ax.solve1(A, B);
		System.out.println(t1);
		A = new int[] { 1, 2, 3, 4, 5 };
		B = 3;
		t = ax.solve(A, B);
		System.out.println(t);
		t1 = ax.solve1(A, B);
		System.out.println(t1);
	}

}

class Ax {
	public int solve1(int[] A, int B) {
		Arrays.sort(A);
		return A[A.length - B] - A[B - 1];
	}

	public int solve(int[] A, int B) {
		if(A.length-B == B-1) {
			return 0;
		}
		for (int a = 0; a < B; a++) {
			for (int i = a + 1; i < A.length; i++) {
				if (A[i] > A[a]) {
					int temp = A[a];
					A[a] = A[i];
					A[i] = temp;
				}
			}
		}
		for (int a = B; a < B + B; a++) {
			for (int i = a + 1; i < A.length; i++) {
				if (A[i] < A[a]) {
					int temp = A[a];
					A[a] = A[i];
					A[i] = temp;
				}
			}
		}
		return A[B - 1] - A[2 * B - 1];
	}
}
