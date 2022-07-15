package scaler.homework.arrays.preprocessing;

public class EvenIndexSumForRangeQueries {
    public static void main(String args[]) {
        int[] A = new int[]{3, 4, -2, 8, 6, 2, 1, 3};
        int q_start = 4;
        int evenIndexSum = 0;
        int q_end = 6;
        int[] preprocessArr = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                evenIndexSum += A[i];
            }
            preprocessArr[i] = evenIndexSum;
            System.out.print(preprocessArr[i]+" ");
        }
        System.out.println("Even index sum for 4-8: "+(preprocessArr[q_end]-preprocessArr[q_start-1]));
    }
}
