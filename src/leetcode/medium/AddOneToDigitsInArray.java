package leetcode.medium;

public class AddOneToDigitsInArray {

	public static void main(String[] args) {
		Solution3 s = new Solution3();
		int[] A = new int[] { 0, 0, 0, 9, 0, 9, 7, 8 };
		A = new int[] { 0 };
		A=new int[] {2, 5, 6, 8, 6, 1, 2, 4, 5 };
		int[] result = s.plusOne(A);
		for (int a : result) {
			System.out.println(a);
		}

	}

}

class Solution3 {
	public int[] plusOne(int[] A) {
		int lastIndex = A.length - 1, startIndexA = 0, firstNonZeroDigitIndex = 0;
		int carry = 1;
		int[] result = null;
		int i = 0, j = 0;
		while (i<A.length && A[i] == 0 ) {
			firstNonZeroDigitIndex = ++i;
		}
		int nines_counter = 0;
		for (i = firstNonZeroDigitIndex; i <= lastIndex; i++) {
			if (A[i] == 9) {
				nines_counter++;
			}
		}

		if (nines_counter == A.length - firstNonZeroDigitIndex) {
			// System.out.println("in here");
			result = new int[A.length - firstNonZeroDigitIndex + 1];
			result[0] = 1;
			for (i = 1; i <= A.length - firstNonZeroDigitIndex; i++) {
				result[i] = 0;
			}
		} else {
			System.out.println("in the 0 condition");
			startIndexA = firstNonZeroDigitIndex;
			lastIndex = A.length - firstNonZeroDigitIndex - 1;
			result = new int[A.length - firstNonZeroDigitIndex];
			for (i = A.length - 1, j = lastIndex; i >= startIndexA && j >= 0; i--, j--) {
				result[j] = A[i] + carry;
				if (result[j] > 9) {
					result[j] = result[j] % 10;
					carry = 1;
				} else {
					carry = 0;
				}
			}
		}
		return result;
	}
}
