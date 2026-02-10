package walmart;


import java.util.ArrayList;
import java.util.List;

class SetMatrixZeros {
    public int[][] setZeroes(int[][] matrix) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i=0;i<rows.size();i++){
            int x = rows.get(i);
            for(int y=0;y<matrix[x].length;y++){
                matrix[x][y] = 0;
            }
        }

        for(int i=0;i<cols.size();i++){
            int x = cols.get(i);
            for(int y=0;y<matrix.length;y++){
                matrix[y][x] = 0;
            }
        }

        return matrix;
    }

    static void main() {
        SetMatrixZeros s = new SetMatrixZeros();
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1},{1,1,1}};
        int[][] out = s.setZeroes(matrix);
        for(int i=0;i<out.length;i++){
            for(int j=0;j<out[0].length;j++){
                System.out.print(out[i][j]+" ");
            }
            System.out.println();
        }

        matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        out = s.setZeroes(matrix);
        for(int i=0;i<out.length;i++){
            for(int j=0;j<out[0].length;j++){
                System.out.print(out[i][j]+" ");
            }
            System.out.println();
        }
    }
}