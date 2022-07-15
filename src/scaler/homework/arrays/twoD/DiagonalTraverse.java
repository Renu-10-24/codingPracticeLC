package scaler.homework.arrays.twoD;

public class DiagonalTraverse {
    public static void main(String args[]){
        S s = new S();
        int[][] mat = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
        int [] output  = s.findDiagonalOrder(mat);
    }
}
class S {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int[] output = new int[n*n];

        return output;
    }
}