package scaler.assignments;

public class CountElementsLTEB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sol s = new Sol();
		int[] A = new int[] {1, 3, 3, 4, 4, 7, 8, 8, 16, 20, 20, 22, 24, 24 };
//		System.out.println(s.solve(A, 3));
		System.out.println(s.solve(A, 24));
		System.out.println(s.solve(A, 1));
//		s.solve(A,21);
//		s.solve(A, 24);
	}

}

class Sol {
	public int solve(int[] A, int B) {
		// using binary search
		int t = 0;
		int low = 0;
		int high = A.length - 1;
		if (B < A[low])
			return 0;
		if (B > A[high])
			return A.length;
		int mid = findMid(low, high);
		while (low != high - 1) {
			if (B < A[mid]) {
				// System.out.println("in lt : midE "+A[mid]);
				high = mid;
				mid = findMid(low, high);
			} else if (B > A[mid]) {
				// System.out.println("in gt : midE "+A[mid]);
				low = mid;
				mid = findMid(low, high);
			} else if (B == A[mid]) {
				// System.out.println("in eq : midE "+A[mid]);
				t = mid;
				while (t < A.length && A[t] == B) {
					// System.out.println("in while ");
					t++;
				}
				// System.out.println("t "+t);
				return t;
			}
		}
		// index of search element, or index to search the element if not present
		if (low == high - 1) {
			if (B < A[high]) {
				return low + 1;
			} else {
				return high + 1;
			}
		}
		return 0;
	}

	int findMid(int low, int high) {
		int mid = low + (high - low) / 2;
		return mid;
	}
}
