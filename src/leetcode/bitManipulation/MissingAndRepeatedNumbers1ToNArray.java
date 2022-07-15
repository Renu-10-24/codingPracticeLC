package leetcode.bitManipulation;

public class MissingAndRepeatedNumbers1ToNArray {
    public static void main(String args[]) {
        Solx s = new Solx();
        int[] arr = new int[]{1, 2, 3, 3, 5, 6, 7, 8, 9, 10};
        int[] output = new int[2];
        output = s.repeatedNumber(arr);
        System.out.println(output[0]);
        System.out.println(output[1]);
    }
}
class Solx {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] A) {
        //find xor of all elements from 1 to N
        int[] output = new int[2];
        int xorAllN = 0;
        int xorAllArr = 0;
        for (int i = 0; i < A.length; i++) {
            xorAllN = xorAllN ^ (i + 1);
            xorAllArr = xorAllArr ^ A[i];
        }
        xorAllN = xorAllN ^ 0; //gives xor of all n elements.
        xorAllArr = xorAllArr ^ 0; //xor of all array elements
        int xor = xorAllArr ^ xorAllN;
        //find the set bit in the x^y
        int setBitIndex = 0;
        while (xor > 0) {
            if ((xor & 1) == 1) {
                break;
            }
            xor = xor >> 1;
            setBitIndex++;
        }

        int partition1_xor=0;
        int partition2_xor=0;
        for (int i = 0; i < A.length; i++) {
            if((A[i]&(1<<setBitIndex))==0){
               partition1_xor = partition1_xor^ A[i];
            }else{
                partition2_xor = partition2_xor^ A[i];
            }
            if(((i+1)&(1<<setBitIndex))==0){
                partition1_xor = partition1_xor ^ (i+1);
            }else{
                partition2_xor = partition2_xor ^ (i+1);
            }
        }
        partition1_xor = partition1_xor^0;
        partition2_xor = partition2_xor^0;
        output[0]=partition1_xor;
        output[1]=partition2_xor;
        return output;
    }
}