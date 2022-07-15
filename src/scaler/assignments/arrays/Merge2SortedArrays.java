package scaler.assignments.arrays;

public class Merge2SortedArrays {
	public static void main(String[] args) {
		Sol5 s = new Sol5();
		int[] A = new int[] { 3, 4, 4, 5, 7, 8, 9 };
		int[] B = new int[] { 2, 4, 4, 4, 6, 10, 11 };
		s.solve(A, B);
		A = new int[] { 1 };
		B = new int[] { 2 };
		s.solve(A, B);
		A = new int[] { 1,4,5,6,7 };
		B = new int[] { 2 };
		s.solve(A, B);
	}
}

class Sol5 {
	public int[] solve(final int[] A, final int[] B) {
		int a = 0, b = 0, t = 0;
		int[] outputArray = new int[A.length + B.length];
		while (t < outputArray.length) {
			if (((a < A.length && b < B.length) && B[b] < A[a]) || a == A.length) {
				outputArray[t] = B[b];
				t++;
				b++;
			} else if (b < B.length && a < A.length && B[b] == A[a]) {
				outputArray[t] = B[b];
				t++;
				b++;
				outputArray[t] = A[a];
				t++;
				a++;
			} else if (a < A.length) {
				outputArray[t] = A[a];
				t++;
				a++;
			}
		}

		for (int i : outputArray) {
			System.out.print(i+ " ");
		}
		System.out.println();
		return outputArray;
	}
}
