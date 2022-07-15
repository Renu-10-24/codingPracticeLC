package scaler.homework.arrays;
//Printing all diagonals right to left
public class RToLDiagonalMatrix {
    public static void main(String args[]){
        Solution1 s = new Solution1();
        int[][] a = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        a = new int[][]{{1,2,3,4,5,6,7},{1,2,3,4,5,6,7},{9,8,6,5,4,3,2},{5,4,1,1,4,3,6},{9,8,7,5,0,4,2}};
//        a = new int[][]{{1,2,3},{1,2,3},{9,8,6},{5,4,1},{0,4,2}};
        int [][] output = s.diagonal(a);
//        int[][] output = s.diagonalPrintingRectMatrix(a);
        for(int i=0;i<2*a.length-1;i++){
            for(int j=0;j<a.length;j++){
                System.out.print(output[i][j]);
            }
            System.out.println();
        }
    }

}
class Solution1 {
    public int[][] diagonalPrintingRectMatrix(int[][] A){
        int rows=A.length;
        int cols = A[0].length;
        int outputCols=0;
        if(rows <cols) {
            outputCols = rows;
        }else{
            outputCols = cols;
        }
        int[][] output = new int[rows+cols-1][outputCols];
        System.out.println("Diagonal printing rectangular matrix ");
        for(int x = 0;x<cols;x++){
            for(int i=0;i<=x&& i<rows;i++){
                System.out.print(A[i][x-i]+" ");
            }
            System.out.println();
        }
        int limit = 0;
        if(rows<cols){
            limit = rows;
        }else{
            limit = cols;
        }
        for(int x=1;x<limit;x++){
            int r=x;
        for(int i=limit-1,j=rows-x;i>=0;j--){
//            System.out.print("["+r+","+i+"] ");
                System.out.print(A[r++][i--]+" ");
            }
            System.out.println();
        }
        return output;
    }
    public int[][] diagonal(int[][] A) {
        int[][] diagonalMatrix = new int[2*A.length-1][A.length];
        int x = 0;
        for(;x<A.length;x++){
            for(int i=0;i<=x;i++){
                System.out.print(A[i][x-i]+" ");
                diagonalMatrix[x][i]=A[i][x-i];
            }
            System.out.println();
        }

        for(int t=1;t<A.length;t++,x++){
            int y1=0;
        for(int x1 = t,y=A.length-1;x1<A.length;x1++,y--) {
            diagonalMatrix[x][y1++]=A[x1][y];
            System.out.print(A[x1][y] + " ");
        }
            System.out.println();
        }
        return diagonalMatrix;
    }
}
