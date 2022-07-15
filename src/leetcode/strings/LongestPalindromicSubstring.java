package leetcode.strings;

public class LongestPalindromicSubstring {
    public static void main(String args[]){
        Soly s =new Soly();
        String str = "cbabaddababatjtjtyyti";
        String x =null;
//        String x = s.longestPalindrome(str);
//        System.out.println(x);
//        str="cbabadababa";
//        x = s.longestPalindrome(str);
//        System.out.println(x);
//        str="sxsgregcbabadababa";
//        x = s.longestPalindrome(str);
//        System.out.println(x);
//    aaaabaaa
//        str="aaaabaaa";
//        x = s.longestPalindrome(str);
//        System.out.println(x);

//        "abcda"
        str="abcda";
        x = s.longestPalindrome(str);
        System.out.println(x);
    }
}
class Soly {
    public String longestPalindrome(String A) {
        int maxPalinLen = 1;

        int currOddPalinLen=1;
        int currEvenPalinLen=0;
        StringBuilder sb = new StringBuilder(A);

        String output=sb.substring(0,1);
        String output1=new String();

        if(A.length()==1){
            return A;
        }
        if(A.length()==2){
            if(A.charAt(0)!=A.charAt(1)){
                return A.charAt(0)+"";
            }
            return A;
        }
        for(int right=1;right<A.length()-1;right++) {
            currOddPalinLen=1;
            for (int i = right, x1 = i - 1, x2 = i + 1; i < A.length() && x1 >= 0 && x2 < A.length(); ) {
                char c1 = A.charAt(x1);
                char c2 = A.charAt(x2);
                if (c1 == c2) {
                    currOddPalinLen += 2;
                    if (currOddPalinLen > maxPalinLen) {
                        output = sb.substring(x1, x2 + 1);
                        maxPalinLen = currOddPalinLen;
                    }
                    if(maxPalinLen==A.length()){
                        return A;
                    }
                    x1--;
                    x2++;
                } else {
                    break;
                }
            }
        }
        for(int right=0;right<A.length()-1;right++) {
            currEvenPalinLen=0;
            for (int x1 = right, x2 = right + 1; right < A.length() && x1 >= 0 && x2 < A.length(); ) {
                char c1 = A.charAt(x1);
                char c2 = A.charAt(x2);
                if (c1 == c2) {
                    currEvenPalinLen += 2;
                    if (currEvenPalinLen > maxPalinLen) {
                        maxPalinLen = currEvenPalinLen;
                        output1 = sb.substring(x1, x2 + 1);
                    }
                    if(maxPalinLen==A.length()){
                        return A;
                    }
                    x1--;
                    x2++;

                } else {
                    break;
                }
            }
        }

        if(output1.length()>output.length()){
          return output1;
        }else{
            return output;
        }
//        return A.substring(0,1);
    }
}