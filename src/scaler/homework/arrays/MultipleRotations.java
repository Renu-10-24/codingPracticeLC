package scaler.homework.arrays;

public class MultipleRotations {
	public static void main(String args[]) {
		Soutn s = new Soutn();
		int[] A = new int[] { 1, 2, 3, 4, 5 };
		int[] B = new int[] { 2, 3 };
		int[][] output = s.solve(A, B);
		int b = B.length;
		int a = A.length;
		for (int j = 0; j < b; j++) {
			for (int i = 0; i < a; i++) {
				System.out.println(output[j][i]);
			}
		}
	}
}

class Soutn {
	public int[][] solve(int[] A, int[] B) {
		int a = A.length, b = B.length;
		int[][] output = new int[B.length][A.length];
		// left rotate - from left to right
		for (int j = 0; j < b; j++) {
			int x = 0;
			output[j] = new int[a];
			B[j] = B[j] % a;
			for (int i = a - B[j]; i < a; i++) {
				output[j][x++] = A[i];
			}
			for (int i = 0; i < a - B[j]; i++) {
				output[j][x++] = A[i];
			}
		}
		return output;
	}
}