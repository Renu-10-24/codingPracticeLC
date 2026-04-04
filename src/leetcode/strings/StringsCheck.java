public class StringsCheck {
    public boolean checkStrings(String s1, String s2) {
        int[] evenm1 = new int[26];
        int[] oddm1 = new int[26];
        int[] evenm2 = new int[26];
        int[] oddm2 = new int[26];
        int x1=0,x2=0;
        for(int t1=0;x1<26 && t1 < s1.length();t1=t1+2){
            char c1 = s1.charAt(t1);
            x1 = c1-65;
            evenm1[x1]++;
        }
        for(int t1 = 0;x1<26 && t1 < s2.length();t1=t1+2){
            char c1 = s1.charAt(t1);
            x1 = c1-65;
            oddm1[x1]++;
        }
        for(int i=0;i<26;i=i+2){
            char c2 = s2.charAt(i);
            x2 = c2-65;
            evenm2[x2]++;
        }
        for(int i=1;i<26;i=i+2){
            char c2 = s2.charAt(i);
            x2 = c2-65;
            oddm2[x2]++;
        }
        for(int t1=0;t1<26;t1=t1+2){
            if(evenm1[t1] != evenm2[t1]){
                return false;
            }
        }
        for(int t1=1;t1<26;t1=t1+2){
            if(oddm1[t1]!=oddm2[t1]){
                return false;
            }
        }
        return true;
    }

    static void main() {
        StringsCheck s = new StringsCheck();
        String s1 = "abcdba";
        String s2 = "cabdab";
        boolean ans = s.checkStrings(s1,s2);
        System.out.println(ans);
    }
}
