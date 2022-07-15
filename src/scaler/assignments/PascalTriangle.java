package scaler.assignments;

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution4 s = new Solution4();
		int A = 9;
		System.out.println(s.ncr(8,5));
		System.out.println(s.ncr(8,3));
		int[][] pascal = s.solve(A);
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < A; j++) {
				// printing pascal nos.
				System.out.print(pascal[i][j]);
			}
			System.out.println();
		}
	}

}

class Solution4 {
	public int[][] solve(int A) {
		int[][] pascalMatrix = new int[A][A];
		if(A==0) {
			return new int[0][0];
		}else {
		pascalMatrix[0][0] = 1;
		for (int t = 1; t < A; t++) {
//			System.out.print(" " + 0);
			pascalMatrix[0][t] = 0;
		}
		for (int i = 1; i < A; i++) {
			for (int j = 0; j <= i; j++) {
				pascalMatrix[i][j] = ncr(i, j);
			}
			for (int k = i + 1; k < A; k++) {
				pascalMatrix[i][k] = 0;
			}
		}
		}
		return pascalMatrix;
	}

	int ncr(int n, int r) {
		double p = 1;
		if (r == 1)
			return n;
		if (r == 0 || n == r) {
			return 1;
		}
		if ((n - r) < r) {
			r = n - r;
		}
		
		while (r >= 1) {
			p = p * n/r;
			n=n-1;
			r--;
		}
		return (int)Math.round(p);
	}
}
