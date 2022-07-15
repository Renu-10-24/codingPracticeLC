package scaler.subarrays;
//return index of first element that has the least avg
public class SubarraySizeKLeastAvg {
    public static void main(String args[]){
        Solution1 s= new Solution1();
        int [] a = new int[]{3, 7, 90, 20, 10, 50, 40};
        int B = 3;
        a= new int[]{3, 7, 5, 20, -10, 0, 12};
        B=2;
        a= new int[]{5, 15, 7, 6, 3, 4, 18, 14, 13, 7, 3, 7, 2, 18};
        B=6;
        int x = s.solve(a,B);
        System.out.println(x);
        x = s.solveSlidingWindow(a,B);
        System.out.println(x);
    }
}
class Solution1 {
    public int solve(int[] A, int B) {
    //brute force finding sum of all subarrays and comparing to find min
        //Iterations - (n-k)*k  TC = O(nk) SC = O(1)
        int minSumSubArr=Integer.MAX_VALUE,minSumSubArrStartIndex=0;
            int firstSubArrStart = 0;
            int n = A.length;
            int k = B;
            int lastSubArrStart = (n-k);//n-k

            for(int i=firstSubArrStart;i<=lastSubArrStart;i++) {
                int sum=0;
                //subarr from i to i+k
                for(int x=i;x<i+k;x++) {
                    sum += A[x];
                }
                if (sum < minSumSubArr) {
                    minSumSubArrStartIndex = i;
                    minSumSubArr = sum;
                }
            }
        return minSumSubArrStartIndex;
    }

    public int solveSlidingWindow(int[] A, int B) {
        //sliding window technique to find sum of all subarrays and comparing to find min
        //Iterations =k + (n-k)  TC = O(n) SC = O(1)
        int minSumSubArr=0,minSumSubArrStartIndex=0;
        int firstSubArrStart = 0;
        int n = A.length;
        int k = B;
        int lastSubArrStart = (n-k);//n-k
        int sum=0;
        for(int x=0;x<k;x++) {
            minSumSubArr += A[x];
        }
        minSumSubArrStartIndex =0;
        sum=minSumSubArr;
        for(int i=1;i<=lastSubArrStart;i++) {
            sum += A[i+k-1]-A[i-1];

            if (sum < minSumSubArr) {
                minSumSubArrStartIndex = i;
                minSumSubArr = sum;
            }
        }
        return minSumSubArrStartIndex;
    }
}
