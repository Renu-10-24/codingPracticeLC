package scaler.degree.dsa1;

public class BoundaryElements{
        public int[] solve(int[][] A) {
            int row = 0,x=0,col=0;
            int[] output= new int[2*(A.length+A[0].length)-4];
            for(;col<A[0].length;col++){
                output[x++]=A[row][col];
            }
            for(row=row+1,col=col-1;row < A.length;row++){
                output[x++]=A[row][col];
            }
            for(col=col-1,row=row-1;col >=0;col--){
                output[x++]=A[row][col];
            }
            for(row=row-1,col=col+1;row >0;row--){
                output[x++]=A[row][col];
            }
            return output;
        }

    static void main() {
        BoundaryElements b = new BoundaryElements();
        int[][] A= new int[][]{{1,1,},{1,1}};
        int[] out = b.solve(A);
        for(int i : out){
            System.out.print(i+" ");
    }
    }
}
