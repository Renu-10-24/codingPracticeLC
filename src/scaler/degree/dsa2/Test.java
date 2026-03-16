package scaler.degree.dsa2;

import java.util.Arrays;

//maxproduct of 3 elements
public class Test {
    public int solve(int[] A) {
        Arrays.sort(A);
        int n = A.length - 1;
        return (int) Math.max(1L * A[n - 2] * A[n - 1] * A[n], 1L * A[0] * A[1] * A[n]);
    }

    static void main() {
        Test t = new Test();
        int[] nums = new int[]{-1,2,1,5};
        int ans=t.solve(nums);
        System.out.println(ans);
    }
}

