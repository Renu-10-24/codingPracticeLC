package walmart;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;){
            for(int j=matrix[0].length-1;j>=0;){
                if(matrix[i][j]==target){
                    return true;
                }else if(matrix[i][j]<target){
                    i++;
                }else{
                    j--;
                }
            }
        }
        return false;
    }
    //O(log(m*n)) - binary search in array size m*n
    public boolean searchMatrixOptimized(int[][] matrix, int target){
        int lo= 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int hi= m*n-1;
        int mid= -1;
        int row = -1;
        int col = -1;
        while(lo < hi ){
             mid= (lo+hi)/2;
             row = mid/n;
             col = mid % n;
            if(target == matrix[row][col]){
                return true;
            }else if(target < matrix[row][col]){
                hi = mid -1;
            }else{
                lo = mid +1;
            }
        }
        mid = (lo+hi)/2;
        row = mid /n;
        col = mid %n;
        if(target == matrix[row][col]){
            return true;
        }
        return false;
    }

    static void main() {
        Search2DMatrix s = new Search2DMatrix();
        int[][] matrix = new int[][]{{1,3,7,10},{11,12,16,20},{23,30,34,50}};
        int target = 3;
        boolean result = s.searchMatrixOptimized(matrix, target);
        System.out.println(result);
        target = 16;
        result = s.searchMatrixOptimized(matrix,target);
        System.out.println(result);
    }
}