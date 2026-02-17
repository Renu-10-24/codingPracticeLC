package coderbyte.walmart;

public class MinWindowSubstring_ref {

    public static String MinWindowSubstring(String[] strArr) {
        String n = strArr[0];
        String k = strArr[1];

        int[] need = new int[26];
        int required = 0; // number of distinct chars in k that must be satisfied

        for (char c : k.toCharArray()) {
            if (need[c - 'a'] == 0) required++;
            need[c - 'a']++;
        }

        int[] have = new int[26];
        int formed = 0;

        int bestLen = Integer.MAX_VALUE;
        int bestL = 0;

        int l = 0;
        for (int r = 0; r < n.length(); r++) {
            char rc = n.charAt(r);
            int idxR = rc - 'a';
            have[idxR]++;

            if (need[idxR] > 0 && have[idxR] == need[idxR]) {
                formed++;
            }

            // shrink while valid
            while (formed == required && l <= r) {
                int winLen = r - l + 1;
                if (winLen < bestLen) {
                    bestLen = winLen;
                    bestL = l;
                }

                char lc = n.charAt(l);
                int idxL = lc - 'a';
                have[idxL]--;

                if (need[idxL] > 0 && have[idxL] < need[idxL]) {
                    formed--;
                }
                l++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : n.substring(bestL, bestL + bestLen);
    }

    // quick sanity
    public static void main(String[] args) {
        System.out.println(MinWindowSubstring(new String[]{"aaabaaddae", "aed"}));      // dae
        System.out.println(MinWindowSubstring(new String[]{"aabdccdbcacd", "aad"}));   // aabd
        System.out.println(MinWindowSubstring(new String[]{"aabpojnlkntwtdccdbcaacd", "aad"}));   // aacd
    }
}
