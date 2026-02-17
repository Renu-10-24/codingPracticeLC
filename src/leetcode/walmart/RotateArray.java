package walmart;
//rotate by 90 degrees -> transpose of matrix

public class RotateArray {
    public void rotate_extra_space(int[][] matrix) {
        int[][] out = new int[matrix[0].length][matrix.length];

        for (int col = matrix.length - 1; col >= 0; col--) {
            for (int row = 0; row < matrix[0].length; row++) {
                out[row][col] = matrix[matrix.length - 1 - col][row];
            }
        }
        for (int row = 0; row < matrix[0].length; row++) {
            for (int col = 0; col <= matrix.length - 1; col++) {
                System.out.print(out[row][col] + " ");
            }
            System.out.println();
        }
    }

    public void rotate_inplace(int[][] matrix) {
        //find transpose
        for (int row = 0; row < matrix.length; row++) {
            for (int col = row+1; col < matrix[0].length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0, rev_col = matrix[0].length - 1; col < rev_col; col++, rev_col--) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][rev_col];
                matrix[row][rev_col] = temp;
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }


    static void main() {
        RotateArray rotateArray = new RotateArray();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        rotateArray.rotate_extra_space(matrix);
        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; // applies for only square matrix as per question
        rotateArray.rotate_inplace(matrix);
    }
}