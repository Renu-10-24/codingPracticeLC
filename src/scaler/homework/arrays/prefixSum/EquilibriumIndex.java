package scaler.homework.arrays.prefixSum;

public class EquilibriumIndex {
    public static void main(String args[]){
        Sn s = new Sn();
        int[] A = new int[]{-7, 1, 5, 2, -4, 3, 0};
        A = new int[]{1, 2, 3, 7, 1, 2, 3};
        int x = s.solve(A);
        System.out.println(x);
    }
}
class Sn {
    public int solve(int[] A) {
        int[] befIndexSum =new int[A.length];
        int[] aftIndexSum =new int[A.length];
        befIndexSum[0]=0;
        for(int i=1;i<A.length;i++){
            befIndexSum[i] = befIndexSum[i-1]+A[i-1];
        }
        aftIndexSum[A.length-1]=0;
        for(int i=A.length-2;i>=0;i--){
            aftIndexSum[i] = aftIndexSum[i+1]+A[i+1];
        }

        for(int i=0;i<A.length;i++){
            if(befIndexSum[i]==aftIndexSum[i]){
                return i;
            }
        }
        return 0;
    }
}

