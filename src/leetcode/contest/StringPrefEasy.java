package leetcode.contest;

import java.util.StringTokenizer;

public class StringPrefEasy {

	public static void main(String[] args) {
		Solution s = new Solution();
		String sentence = "India is my country all indians are my brothers and sisters isSmileSir";
		String pref= "is";
		int x = s.isPrefixOfWord(sentence,pref);
		System.out.println(x);
	}

}
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int count = 0;
        StringTokenizer strTknzr = new StringTokenizer(sentence," ");
        while(strTknzr.hasMoreTokens()){
            String token = strTknzr.nextToken();
            if(token.startsWith(searchWord)){
                count++;
            }
        }
        return count;
    }
}