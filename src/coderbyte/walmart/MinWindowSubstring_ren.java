package coderbyte.walmart;

class MinWindowSubstring_ren {

    public static String MinWindowSubstring(String s1,String s2) {
        int[] need =new int[27];
        int[] have = new int[27];
        int required = 0; // count no of distinct chars in the needed string strArr[1]
        // count of matched chars along with their index counts matched implies we found a match,
        // and from then we can shrink the window size
        for(int i =0;i<s2.length();i++){
            char ch = s2.charAt(i);
            if(need[ch-'a']==0){
                required++;
            }
            need[ch-'a']++;
        }
            String s = new String();

        int l=0, bestL=0;
        int formed = 0;
        int minSubstrLen = Integer.MAX_VALUE;
        int windowLen = s1.length();
        for(int r =0;r<s1.length();r++) {
            char ch = s1.charAt(r);
            int idxR = ch - 'a';
            have[idxR]++;
            if (need[idxR] >0 && have[idxR] == need[idxR]) { //required count met for char at idxR
                formed++;
            }
            if (formed == required && l <=r) {
                //shrink window size
                System.out.println("found the initial substring match, have to work on the shrink page from here ");
                //work on increasing l and check if the checks are still met
                windowLen = r - l + 1;
                if(windowLen < minSubstrLen) {
                    minSubstrLen = windowLen;
                    bestL = l;
                }
                char cleft = s1.charAt(l);
                int idxL = cleft - 'a';
                have[idxL]--;

                if(need[idxL] > 0 && have[idxL] < need[idxL]){
                    formed--;
                }
            }
        }

            return s1;
        }

        public static void main (String[] args) {
            // keep this function call here
//            Scanner s = new Scanner(System.in);
            String s1 = new String("aaabaaddae");
            String s2 = new String("aed");
            s1 = new String("aabdccdbcacd");
            s2 = new String("aad");
            System.out.print(MinWindowSubstring(s1,s2));
        }

    }