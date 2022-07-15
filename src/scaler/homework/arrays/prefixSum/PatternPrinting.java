package scaler.homework.arrays.prefixSum;
//        1 0 0
//        1 2 0
//        1 2 3

// second pattern
//                1
//              2 1
//            3 2 1

public class PatternPrinting {
    public static void main(String args[]){
        Solution s = new Solution();
        int a = 6;
        int [][] output =s.solve(a);
        for(int i=0;i<a;i++){
            for(int j=0;j<a;j++){
                System.out.print(output[i][j]+" ");
            }
            System.out.println();
        }
        a=1;
        output  = s.solve_pattern2(1);
        for(int i=0;i<a;i++){
            for(int j=0;j<a;j++){
                System.out.print(output[i][j]+" ");
            }
            System.out.println();
        }
    }
}
class Solution {
    public int[][] solve(int A) {
        int[][] output = new int[A][A];
        for(int i=0;i<A;i++){
            for(int j=0;j<=i;j++){
                output[i][j]=j+1;
//                System.out.print(output[i][j]+" ");
            }
//            System.out.println();
        }
        return output;
    }

    public int[][] solve_pattern2(int A) {
        int[][] output = new int[A][A];
        for(int k=0;k<A;k++){
//            output[k] = new int[A];
            int j=0;
            for(;j<A-k-1;j++){
                 System.out.print(" ");
                output[k][j]=0;
            }
            for(int i=k+1;i>0;i--){
                  System.out.print(i+" ");
                output[k][j++]=i;
            }
             System.out.println();
        }
        return output;
    }
}