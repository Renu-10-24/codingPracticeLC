package scaler.strings;

public class CountOccurrencesOfWord {
}
class Solution {
    public int solve(String A) {
        int count =0;
        for(int i=0;i<=A.length()-3;i++){
            char c1= A.charAt(i);
            char c2= A.charAt(i+1);
            char c3= A.charAt(i+2);
            if((c1=='b') && (c2=='o') && (c3=='b')){
                count++;
            }
        }
        return count;
    }
}