package scaler.strings;

import java.security.spec.RSAOtherPrimeInfo;

public class ReverseWordsOfString {
    public static void main(String args[]){
        SolA s = new SolA();
        // getting TLE for this code.. should see how to optimize further..

        String a = "am I as clever as you are";
        String x ="";
//        String x = s.solve(a);
//        System.out.println(x);
//        a="crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq hv";
//        x = s.solve(a);
//        System.out.println("ans : "+x);
        a= "e jrkeymu coklj si vohl slje sxtpf xvak p kicqxoqaof uqwftidoi xixfvqbjey n tpkh ylqllzln ljo gvozwv ";
        x=s.solve(a);
        System.out.println("ans : "+x);
    }
}
class SolA {
    public String solve(String A) {
        // A = "am I as clever as you are"
        // A= "era uoy sa revelc sa I ma"
        // reverse entire String
//        System.out.println("before trim : "+"--"+A+"--"+A.length());
        A = A.trim();
//        System.out.println("after  trim : "+"--"+A+"--"+A.length());
        String reverseA = reverseString(A, 0, A.length() - 1);
//        System.out.println("reversed string : ---"+reverseA+"--");
//        System.out.println("reversed length : "+reverseA.length());
        StringBuilder output = new StringBuilder();
        int startIndex = 0,endIndex=0;
        for (int i = 0; i < reverseA.length(); i++) {
            while (reverseA.charAt(i) != ' ') {
                if (i == reverseA.length() - 1) {
                    break;
                }
                i++;
            }
            endIndex = i - 1;
            if(i==reverseA.length()-1){
                endIndex=i;
            }
//            System.out.println("startIndex : "+startIndex+" endIndex : "+endIndex);

            String word = reverseString(reverseA, startIndex, endIndex);
//            System.out.println(word+"------");
            if(endIndex==A.length()-1){
                output.append(word);
            }else{
                output.append(word+" ");
            }
            if(endIndex==A.length()-1){
                return output.toString();
            }
            startIndex = endIndex + 2;
        }
        return "";
    }
    public String reverseString(String s, int startIndex, int endIndex){
        StringBuilder sb = new StringBuilder(s.substring(startIndex,endIndex+1));
//        for(int i=0,j=sb.length()-1;i<j;i++,j--){
//            char x = sb.charAt(i);
//            char y = sb.charAt(j);
//            sb.replace(i,i+1,y+"");
//            sb.replace(j,j+1,x+"");
//        }
            return sb.reverse().toString();
        }
    }