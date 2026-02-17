package scaler.revisiontest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class LargestNumberFormedAsString {
    public String largestNumber(int[] A) {
        int n = A.length;
        String[] s = new String[n];
        for(int i=0;i<n;i++){
            s[i] =String.valueOf(A[i]);
        }
        Comparator<String> cmpString = (a,b)->(b+a).compareTo(a+b);
        String result = Arrays.stream(s).sorted(cmpString).collect(Collectors.joining(""));
        return result;
    }

    static void main() {
        LargestNumberFormedAsString l = new LargestNumberFormedAsString();
        int[] A = new int[]{9,5,34,30,3};
        String result = l.largestNumber(A);
        System.out.println("Res : "+result);
        A = new int[]{9,5,2,0,3};
        result = l.largestNumber(A);
        System.out.println("res: "+result);
    }
}