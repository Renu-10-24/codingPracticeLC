package scaler.homework.arrays.twoD;

import java.util.HashMap;
import java.util.Map;

public class RowToColZero {
    public static void main(String args[]){
        SRowCol s = new SRowCol();
        int[][] A = new int[][]{{1,2,3,0},{5,6,7,8},{9,10,0,12},{13,14,15,16}};
        A= new int[][]{
                {51, 21, 90, 38, 57, 12, 11, 1, 68, 60},
                {81, 24, 63, 97, 75, 70, 23, 91, 39, 84},
                {0, 21, 97, 12, 46, 48, 50, 3, 57, 69},
                {44, 8, 42, 34, 99, 0, 98, 10, 53, 67},
                {23, 34, 43, 86, 31, 18, 9, 54, 61, 48},
                {90, 61, 21, 87, 26, 67, 88, 28, 70, 45},
                {98, 14, 5, 92, 1, 4, 44, 99, 67, 98},
                {18, 42, 32, 61, 80, 64, 32, 89, 70, 93},
                {89, 61, 7, 10, 0, 85, 29, 40, 13, 0},
                {85, 63, 66, 43, 56, 67, 99, 0, 67, 66}};
        int n=A.length;
        int m=A[0].length;
        int[][] output = s.solve(A);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                System.out.print(output[i][j]+" ");
            }
            System.out.println();
        }
    }
}
class SRowCol {
    public int[][] solve(int[][] A) {
        int n=A.length;
        int m=A[0].length;
        Map<Integer,Integer> hm = new HashMap<Integer,Integer>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(A[i][j]==0){
                    hm.put(i,j);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(hm.containsKey(i)){
                    for(int j1=0;j1<m;j1++){
                        A[i][j1] = 0;
                    }
                }
                if(hm.containsValue(j)){
                    for(int i1=0;i1<n;i1++){
                        A[i1][j] = 0;
                    }
                }
            }

        }
        return A;
    }
}