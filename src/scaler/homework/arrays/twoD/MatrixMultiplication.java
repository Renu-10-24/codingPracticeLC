package scaler.homework.arrays.twoD;

public class MatrixMultiplication {
    public static void main(String args[]){
        Solx x = new Solx();
        int[][] A = new int[][]{{1,2,3,4,5},{6,7,8,9,1},{2,3,4,5,6}};
        int[][] B = new int[][]{{1,2},{3,4},{5,6},{7,8},{9,1}};
        int[][] output = x.solve(A,B);
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B[0].length;j++) {
                System.out.println(output[i][j]+" ");
            }
        }
    }
}
class Solx {
    public int[][] solve(int[][] A, int[][] B) {
        int n = A.length;
        int m = A[0].length;
        int l = B[0].length;
        int[][] output = new int[n][l];
        for(int i=0;i<n;i++){
            for(int j=0;j<l;j++){
                for(int k=0;k<m;k++){
                    output[i][j]= output[i][j]+A[i][k]*B[k][j];
                }
            }
        }
        return output;
    }
}
