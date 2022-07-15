package scaler.homework.arrays.preprocessing;
//Count ways to make sum of odd and even indexed elements equal by removing an array element
public class SpecialIndex {
    public static void main(String args[]) {
        Solx s1 = new Solx();

        int q_start = 4;
        int q_end = 6;
        boolean isEven = true;
        int[] A = null;
        A = new int[]{4, 3, 2, 7, 6, -2};
        int prefixSumEven =0;
        int prefixSumOdd =0;
        int x=0;
//        s1.preprocessPrefixSum(A);
//
//        prefixSumEven = s1.prefixSum(isEven, 0, 3);
//        System.out.println("Preprocessing prefixSumEven : " + prefixSumEven);
//        prefixSumOdd = s1.prefixSum(!isEven, 0, 3);
//        System.out.println("Preprocessing prefixSumOdd  : " + prefixSumOdd);
//        int x = s1.solveForSpclIndex(A);
//        System.out.println("Bruteforce : " + x);
//        x = s1.solve_spclIndex_prefixSum(A);
//        System.out.println("Preprocessing : " + x);

        A = new int[]{ 1, 2, 3, 7, 1, 2, 3 };
        A = new int[]{1, 2, 3, 4, 5, 6, 13, 1, 2, 3, 4, 5, 6};

        x = s1.solve_spclIndex_prefixSum(A);
        System.out.println("Count of spl index elements : " + x);

    }

}
class Solx{
    public int solveForSpclIndex(int[] A){
        //brute force approach
        int countSpclIndex = 0;
        for (int spclIndex = 0; spclIndex < A.length; spclIndex++) {
            int evenIndexSum = 0, oddIndexSum = 0;
            for (int i = 0; i < A.length; i++) {
                if(spclIndex==i) {
                    continue;
                }else if (i < spclIndex) {
                    if (i % 2 == 0) {
                        evenIndexSum += A[i];
                    } else {
                        oddIndexSum += A[i];
                    }
                } else {
                    if (i % 2 == 0) {
                        oddIndexSum += A[i];
                    } else {
                        evenIndexSum += A[i];
                    }
                }
                if(oddIndexSum == evenIndexSum){
                    countSpclIndex++;
                }
            }
            System.out.println("odd  : "+oddIndexSum);
            System.out.println("even : "+evenIndexSum);
        }
        System.out.println("countSpclIndex: " + (countSpclIndex));
        return countSpclIndex;
    }
    int[] prefixEvenSumArr = null;
    int[] prefixOddSumArr = null;
    public void preprocessPrefixSum(int[] A){
        //using the preprocessing technique to find the prefix even index sum and odd index sum.
        int prefixEvenIndexSum = 0, prefixOddIndexSum = 0;
        prefixEvenSumArr = new int[A.length];
        prefixOddSumArr = new int[A.length];
        prefixEvenSumArr[0]=A[0];
        prefixOddSumArr[0]=0;
        for (int i = 0; i < A.length; i++) {
            if(i%2==0){
                prefixEvenIndexSum += A[i];
            }else{
                prefixOddIndexSum += A[i];
            }
            prefixEvenSumArr[i] = prefixEvenIndexSum;
            prefixOddSumArr[i] = prefixOddIndexSum;
        }
    }

    public int prefixSum(boolean isBefore, boolean isEven, int left, int right){
        if(!isBefore){
            if(isEven) {
                return prefixEvenSumArr[right] - prefixEvenSumArr[left];
            }else{
                return prefixOddSumArr[right] - prefixOddSumArr[left];
            }
        }else {
            if (isEven) {
                if (right % 2 == 0) {
                    return prefixEvenSumArr[right - 1];
                } else {
                    return prefixEvenSumArr[right];
                }

            } else {
                if (right % 2 != 0) {
                    return prefixOddSumArr[right - 1];
                } else {
                    return prefixOddSumArr[right];
                }
            }
        }
    }

    public int solve_spclIndex_prefixSum(int[] A) {
        int splInd = 0;
        int count= 0;
        boolean isEven=true;
        int befX=0;
        int aftX=0;
        //invoke preprocessing for prefix sums both for even and odd indices
        preprocessPrefixSum(A);
        boolean isBefore=true;
        for (int left = 0,right = A.length-1; splInd < A.length;splInd++) {
            if(splInd==0){
                befX=0;
            }else {
                int befEvenSum = prefixSum(isBefore,isEven, left, splInd);
                int befOddSum = prefixSum(isBefore,!isEven, left, splInd);

                befX= befEvenSum-befOddSum;
            }

            int aftEvenSum = prefixSum(!isBefore,isEven,splInd,right);
            int aftOddSum = prefixSum(!isBefore,!isEven,splInd,right);

            aftX= aftEvenSum-aftOddSum;

            if(befX==aftX){
                count++;
            }
        }
        return count;
    }
}
