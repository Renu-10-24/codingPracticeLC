package scaler.degree;

import java.util.Arrays;

public class Closest3Sum {
    public int closestThreesum(int[] A, int B){
        Arrays.sort(A);
        return 0;
    }

    static void main() {
        Closest3Sum c = new Closest3Sum();
        int[] A = new int[]{-1,2,1,-4};
        int B = 1;
        int ans=c.closestThreesum(A,B);
    }
}
