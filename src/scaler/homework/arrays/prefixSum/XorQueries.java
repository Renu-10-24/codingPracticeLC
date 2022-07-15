package scaler.homework.arrays.prefixSum;

public class XorQueries {
    public static void main(String args[]){
        Sol1 xorQueries = new Sol1();
        int[] A = new int[]{1,0,0,0,1};
        int[][] B = new int[][]{{2,4},{1,5},{3,5}};
        int[][] output = xorQueries.solve(A,B);
        for(int i=0;i<B.length;i++){
            System.out.println(output[i][0]+" "+output[i][1]);
        }
    }
}

class Sol1 {
    public int[][] solve(int[] A, int[][] B) {
        int[] prefixXor = new int[A.length];
        int[] prefixUnset = new int[A.length];
        int[][] output = new int[B.length][2];
        prefixXor[0]=A[0];
        if(A[0]==0){
            prefixUnset[0]=1;
        }

        for(int i=1;i<A.length;i++){
            prefixXor[i]=prefixXor[i-1]^A[i];
            if(A[i]==1){
                prefixUnset[i]=prefixUnset[i-1];
            }else{
                prefixUnset[i]=prefixUnset[i-1]+1;
            }
        }

        for(int i=0;i<B.length;i++){
            if(B[i][0]==1){
                output[i][0]= prefixXor[(B[i][1]-1)];
                output[i][1]=prefixUnset[B[i][1]-1];
            }else {
                output[i][0] = prefixXor[(B[i][1] - 1)] ^ prefixXor[(B[i][0] - 2)];
                output[i][1]=prefixUnset[B[i][1]-1]-prefixUnset[B[i][0]-2];
            }
        }
        return output;
    }
}