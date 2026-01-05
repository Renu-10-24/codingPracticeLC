package scaler.assignments.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberFromGivenArr {
    public static void main(String args[]){
        Largest l = new Largest();
        int[] A =new int[]{3,30,34,5,9};
        String s = l.largestNumberPossible(A);
        System.out.println(s);
    }
}
class Largest {
    public String largestNumberPossible(int[] A){
        String[] stringNumbers = new String[A.length];
        for(int i=0;i<A.length;i++){
            stringNumbers[i] = ""+A[i];
        }
        Arrays.sort(stringNumbers,new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length();
                int len2 = o2.length();
                int t= 0;
                char ch1 = ' ';
                char ch2 = ' ';
//                System.out.println("o1>o2      : "+(o1+o2)>(o2+o1));

                if(len1>len2){
                    t=len2;
                }else{
                    t=len1;
                }
                System.out.println("o1      : "+o1);
                System.out.println("o2      : "+o2);
                int i=0;
                for(;i<t;i++){
                    ch1 = o1.charAt(i);
                    ch2 = o2.charAt(i);

                    if(ch1<ch2){
                        return 1;
                    }else if(ch1>ch2){
                        return -1;
                    }else{
                        continue;
                    }
                }
                if(len1>len2) {
                    ch1 = o1.charAt(i);
                }else{
                    ch1 = o2.charAt(i);
                }
                if(ch1=='0')
                    return 1;
                else
                    return -1;
            }
        });
        StringBuffer outputBuf = new StringBuffer();
        for(int i=0;i<A.length;i++){
            outputBuf.append(stringNumbers[i]);
        }
        return outputBuf.toString();
    }
}