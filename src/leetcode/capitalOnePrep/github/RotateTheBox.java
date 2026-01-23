package capitalOnePrep.github;

class RotateTheBox {
    public char[][] rotateTheBox(char[][] boxGrid) {
        //before rotate, lets handle shift in cells, keep track of empty cells and obstacles.
        //traverse from last column to first
        int m = boxGrid.length , n=boxGrid[0].length;
        for (int row = 0; row < m; row++) {

            int col = n-1;//bottomCol
            int emptyCol = n-1;
            //check if we have * - obstacle or # at the cell
            while (col >= 0) {
                if (boxGrid[row][col] == '*') {
                    emptyCol = col - 1;
                } else if (boxGrid[row][col] == '#') {
                    boxGrid[row][col] = '.';
                    boxGrid[row][emptyCol] = '#';
                    emptyCol--;
                }
                //if empty continue;
                col--;
            }
        }
        //transpose the matrix now
        char[][] output = new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                output[i][j] = boxGrid[m-1-j][i];
            }
        }
        return output;
    }


    static void main() {
        RotateTheBox r = new RotateTheBox();
        int[][] test = new int[][]{{1,2,3},{4,5,6}};
        char[][] box1= new char[][]{{'#','#','*','.','*','.'},{'#','#','*','.','*','.'},{'#','#','*','.','*','.'}};
        char[][] box2 = new char[][]{{'#','.','#'}};
        r.rotateTheBox(box1);
    }
}