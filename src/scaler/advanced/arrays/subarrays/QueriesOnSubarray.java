package scaler.advanced.arrays.subarrays;

public class QueriesOnSubarray {
    public static void main(String args[]){
//        suppose we have like q queries..
        int q = 8;
        int[] arr = new int[]{1,3,4,6,2,8,6,5,10,12,14,16,9};
        int queries[][] = new int[][]{{0,3},{4,7},{0,4},{7,11},{9,11},{2,5},{3,8},{4,9}};
        Sol1 s= new Sol1();
        s.isSubarrayIncr(arr,queries);
    }
}
class Sol1{

    public boolean[] isSubarrayIncr(int[] arr, int [][] queries){
        int prefixArr[] = new int[arr.length];
        boolean[] outputArr = new boolean[arr.length];
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]<arr[i+1]){
                prefixArr[i] =1;
            }
            if(i!=0) {
                prefixArr[i] = prefixArr[i - 1] + prefixArr[i];
            }
        }
        for(int i=0;i<queries.length;i++){
//            for query l-r => pfArr[r-1]-pfArr[l-1]
            int l = queries[i][0];
            int r = queries[i][1];
            int x = prefixArr[r-1]-prefixArr[l-1];
            if(x==l-r+1){
                outputArr[i]=true;
            }else{
                outputArr[i]=true;
            }
        }
        return outputArr;
    }
}