package scaler.homework.arrays.twoD;

import java.util.ArrayList;
import java.util.List;

public class SpiralPrinting {
    public static void main(String args[]) {
        Solution s = new Solution();
        int a = 21;
        int[][] output = s.generateSquareMatrix(a);
        int[][] outputRect = s.generateRectMatrix(6,6);

//        int[][] inputRectMatrix = new int[][]{{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8},{13,12,11,10,9}};
//        int[][] inputRectMatrix = new int[][]{{1,2,3},{11,12,4},{10,13,6},{14,23,22,21,8},{13,12,11,10,9}};
        int[][] inputRectMatrix = new int[][]{{1,2,3,4,5,6},{20,21,22,23,24,7},{19,32,33,34,25,8},{18,31,36,35,26,9},{17,30,29,28,27,10},{16,15,14,13,12,11}};
        List<Integer> elementSpiralList  = s.spiralOrder(inputRectMatrix);
        System.out.println("Elements in spiral : ");
        for(int i : elementSpiralList){
            System.out.println(i);
        }
    }
}

class Solution {
    //for square matrix
    public int[][] generateSquareMatrix(int A) {

        int[][] output = new int[A][A];

        int ele =1;
        int i = 0, j = 0;
        for(int k=1 ;i==j && i<(A+1)/2;i++,j++,k=k+2) {
            for (int l = k; l < A ; l++) {
                output[i][j] = ele++;
//                System.out.println("[" + i + "," + j + "] " + output[i][j]);
                j++;
            }
            //i=0;j=A-1
            int i1 = 1, j1 = 0;
            for (int l = k; l < A ; l++) {
                output[i][j] = ele++;
//                System.out.println("[" + i + "," + j + "] " + output[i][j]);
                i++;
            }
            //i=A-1,j=A-1;
            for (int l = k; l < A ; l++) {
                output[i][j] = ele++;
//                System.out.println("[" + i + "," + j + "] " + output[i][j]);
                j--;
            }
            //i=A-1,j=0;
            for (int l = k ; l < A; l++) {
                output[i][j] = ele++;
//                System.out.println("[" + i + "," + j + "] " + output[i][j]);
                i--;
            }
        }
        if((A&1)==1){
            output[--i][--j]=ele;
        }
            for (int x1 = 0; x1 < A; x1++) {
                for (int y1 = 0; y1 < A; y1++) {
                    System.out.printf("%4d ", output[x1][y1]);
                }
                System.out.println();
            }

        return output;
    }

    public int[][] generateRectMatrix(int N, int M){
        int[][] output = new int[N][M];
        int ele =1;
        int i = 0, j = 0,limit =0;
        if(M<N){
            limit = (M+1)/2;
        }else{
            limit = (N+1)/2;
        }

        for(int k=1 ;i==j && i<limit;i++,j++,k=k+2) {
            if(k>=M || k>=N){
                break;
            }
            for (int l = k; l < M; l++) {
                output[i][j] = ele++;
                j++;
            }
            //i=0;j=M-1
            int i1 = 1, j1 = 0;
            for (int l = k; l < N; l++) {
                output[i][j] = ele++;
                i++;
            }
            //i=N-1,j=M-1;
            for (int l = k; l < M; l++) {
                output[i][j] = ele++;
                j--;
            }
            //i=N-1,j=0;
            for (int l = k; l < N; l++) {
                output[i][j] = ele++;
                i--;
            }
        }
        if(M<N && ((M&1)==1)) {
            for (int x = i; x < N-i; x++) {
                output[x][j] = ele++;
            }
        }else if(N<M && ((N&1)==1)){
            for(int x=j;x<M-j;x++){
               output[i][x] = ele++;
            }
        }
        if(N==M && ((M&1)==1) && ((N&1)==1)){
            output[i][j]=ele;
        }
        for (int x1 = 0; x1 < N; x1++) {
            for (int y1 = 0; y1 < M; y1++) {
                System.out.printf("%4d ", output[x1][y1]);
            }
            System.out.println();
        }
        return output;
    }
    //printing elements of a rectangular matrix n*m in spiral order
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> elementSpiralList = new ArrayList<>();
        int N = matrix.length;
        int M= matrix[0].length;
        int i = 0, j = 0,limit =0;
        if(M<N){
            limit = (M+1)/2;
        }else{
            limit = (N+1)/2;
        }

        for(int k=1 ;i==j && i<limit;i++,j++,k=k+2) {
            if(k>=M || k>=N){
                break;
            }
            for (int l = k; l < M; l++) {
                elementSpiralList.add(matrix[i][j]);
                j++;
            }

            for (int l = k; l < N; l++) {
                elementSpiralList.add(matrix[i][j]);
                i++;
            }
            for (int l = k; l < M; l++) {
                elementSpiralList.add(matrix[i][j]);
                j--;
            }
            for (int l = k; l < N; l++) {
                elementSpiralList.add(matrix[i][j]);
                i--;
            }
        }
        if(M<N && ((M&1)==1)) {
            for (int x = i; x < N-i; x++) {
                elementSpiralList.add(matrix[x][j]);
            }
        }else if(N<M && ((N&1)==1)){
            for(int x=j;x<M-j;x++){
                elementSpiralList.add(matrix[i][x]);
            }
        }
        if(N==M && ((M&1)==1) && ((N&1)==1)){
             elementSpiralList.add(matrix[i][j]);
        }
    return elementSpiralList;
    }
}

