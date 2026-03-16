package scaler.degree.dsa1;

public class LongestPalinSubstringSimplified {
    public String longestPalindrome(String A) {
        if(A.length()==1){
            return A;
        }
        int start =0,end =0;
        int len = -1;
        for(int i=0;i<A.length();i++){
            int len1 = expand(A,i,i);
            int len2 = expand(A,i,i+1);
            len = Math.max(len,Math.max(len1,len2));
            if(len > end -start +1){
                int left = i -(len-1)/2;
                int right = i +len/2;
                start =left;
                end = right;
            }
        }
        return A.substring(start,end+1);
    }
    private static int expand(String A, int l, int r){
        while(l>=0 && r<A.length()){
            if(A.charAt(l)==A.charAt(r)) {
                l--;
                r++;
            }else{
                break;
            }
        }
            l++;
            r--;

        return r-l+1;
    }

    static void main() {
        String s = "aaaabaaa";
        LongestPalinSubstringSimplified l = new LongestPalinSubstringSimplified();
//        String ans = l.longestPalindrome(s);
//        System.out.println(ans);
//        s= "abba";
//        ans = l.longestPalindrome(s);
//        System.out.println(ans);

        //calling optimized version
        LongestPalindromicSubstring lOpt = new LongestPalindromicSubstring();
        String s1 = "aaaabaaa";
        String out = lOpt.longestPalindrome(s1);
        System.out.println(out);
        s1="babad";
        out = lOpt.longestPalindrome(s1);
        System.out.println(out);
        s1="cbbd";
        out = lOpt.longestPalindrome(s1);
        System.out.println(out);
        s1="c";
        out = lOpt.longestPalindrome(s1);
        System.out.println(out);
    }
}
//Optimized leetcode solution -- search for longest length possible first, so iterate over length, with possible start indices, then, compare chars for each subarray,
//find a palindromic substring, immediately return, because we cannot get any better than that.
class LongestPalindromicSubstring{
    public String longestPalindrome(String A) {
        int n=A.length();
        for(int len=n;len>0;len--){
            for(int start =0;start<=n-len;start++){
                if(checkPalindrome(start,start+len,A)){
                    return A.substring(start,start+len);
                }
            }
        }
        return "";
    }
    private boolean checkPalindrome(int start, int end, String s){
        int l=start;
        int r = end-1;
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}