package scaler.degree;

public class SubarrayWith0Sum {
    public int solve(int[] A) {
        int l=0;
        int reqSum = 3;
        int currSum = 0;
        for(int r=0;l<=r &&r<A.length;){
            currSum += A[r];
            if(currSum < reqSum){
//                currSum +=A[r];

            }else if(currSum > reqSum){
                currSum -= A[l];
                l++;
            }
            if(currSum==reqSum && l<=r){
                return 1;
            }
            r++;
        }
        return 0;
    }

    static void main() {
        SubarrayWith0Sum subarrayWith0Sum = new SubarrayWith0Sum();
        int[] a = new int[]{1,2,3,4,5};
        int foundSumZero = subarrayWith0Sum.solve(a);
        System.out.println(foundSumZero);
        a = new int[]{4,-1,1};
        foundSumZero = subarrayWith0Sum.solve(a);
        System.out.println(foundSumZero);
    }
}
