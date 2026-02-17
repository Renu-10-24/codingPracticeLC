package scaler.strings;

public class MinWindowSubstring {
    int l=0;
    int bestLen=Integer.MAX_VALUE;
    int len = 0, bestL = 0;
    public String minWindow(String s, String t) {
        int[] need = new int[26];
        int[] have = new int[26];
        int required=0; //keeps distinct char count of string t
        int formed = 0;

        for(char tc : t.toCharArray()){
            if(need[tc-'a']==0) {
                required++;
            }
            need[tc-'a']++;
        }


        char[] sarr = s.toCharArray();
        for(int r=0;r<sarr.length;r++){
            char sc = sarr[r]; // checking that distinct chars are formed in string s
            int idx =sc-'a';
            have[idx]++;
            if(need[idx] > 0  && have[idx] == need[idx]){
                formed++;
            }
            //found a matching substring , now start shrinking the window size

            while(formed == required  && l<=r  ) {
                len = r-l+1;
                if(len < bestLen){
                    bestLen = len;
                }
                bestL = l;

                char lc = sarr[l]; // checking that distinct chars are formed in string s
                int lidx =lc-'a';
                have[lidx]--;
                if(need[lidx] > 0 && have[lidx] < need[lidx]){
                    formed--;
                }
                l++;
            }

        }
        return bestLen == Integer.MAX_VALUE? "" : s.substring(bestL,bestL+bestLen);
    }
    public static void main(String[] args) {
        MinWindowSubstring m = new MinWindowSubstring();
        String[] s = new String[]{"aaabaaddae", "aed"};
        System.out.println(m.minWindow(s[0],s[1]));      // dae

        s = new String[]{"aabdccdbcacd", "aad"};
        System.out.println(m.minWindow(s[0],s[1]));     // aabd
        s = new String[]{"aabpojnlkntwtdccdbcaacd", "aad"};
        System.out.println(m.minWindow(s[0],s[1]));     // aacd

    }

}