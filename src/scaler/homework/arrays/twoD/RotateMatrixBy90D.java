package scaler.homework.arrays.twoD;

public class RotateMatrixBy90D {
    public static void main(String args[]) {
        Rotate90 r = new Rotate90();
        int[][] A = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20}};
        A = new int[][]{{1, 2}, {3, 4}};
        r.solve(A);
        r.solveNoExtraSpace(A);
    }
}

class Rotate90 {
    public void solve(int[][] A) {
        //A of size n*m
        int n = A.length, m = A[0].length;
        for (int j = 0; j < m; j++) {
            for (int i = n - 1; i >= 0; i--) {
                System.out.printf("%2d ", A[i][j]);
            }
            System.out.println();
        }
    }

    public void solveNoExtraSpace(int[][] A) {
        //solving without extra space
        //find transpose of the matrix. row -> column
//        A  - n*m matrix
        int n = A.length;
        int m = A[0].length;
        //iterating over the lower triangular matrix
        //body diagonal elements remain same in the transpose as in the matrix
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        //now reverse the columns in the transpose matrix to get the matrix rotated by 90 deg
        for (int i = 0; i < n; i++) {
            for (int j = 0, k = n - j - 1; j < k; j++, k--) {
                int temp = A[i][k];
                A[i][k] = A[i][j];
                A[i][j] = temp;
            }
        }

//printing rotated matrix here
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%2d ", A[i][j]);
            }
            System.out.println();
        }

    }
}
