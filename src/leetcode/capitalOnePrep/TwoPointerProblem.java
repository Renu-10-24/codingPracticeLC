package capitalOnePrep;

public class TwoPointerProblem {

    static void main() {
        LongestSubstringWithoutRepeatingChars l = new LongestSubstringWithoutRepeatingChars();
        String s = "abcabcbb";
        int answer = l.lengthOfLongestSubstring(s);
        System.out.println(s+" : "+ answer);
        s=" ";
        answer = l.lengthOfLongestSubstring(s);
        System.out.println(s+" : "+answer);
        s="bbbbb";
        answer = l.lengthOfLongestSubstring(s);
        System.out.println(s+" : "+ answer);
        s="pwwkew";
        answer = l.lengthOfLongestSubstring(s);
        System.out.println(s+" : "+ answer);
        s="auxsl";
        answer = l.lengthOfLongestSubstring(s);
        System.out.println(s+" : "+ answer);
    }
}

class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        int maxLength=0, len=0;
        int left=0,right=0;
        //2 pointer
        Integer[] chars = new Integer[128];
        if(s.length()==1){
            return s.length();
        }
        for(;right<s.length();){
            char ch = s.charAt(right);

            Integer index = chars[ch];
            if(index != null && index>= left && index < right){
                //update len and maxLength
                //move the left to index+1;
                len = right-left;
                if(len>maxLength){
                    maxLength = len;
                }
                left = index+1;
            }
            chars[ch]=right;
            len = right -left;

            right++;
        }
        //when string has no repeating characters at all
        len = right - left;
        if(len>maxLength){
            maxLength =len;
        }
        return maxLength;
    }
}