package capitalOnePrep;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int val=map.getOrDefault(ch,0);
            map.put(ch,++val);
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int val=map.getOrDefault(ch,0);
            if(val == 1){
                return i;
            }
        }
        return -1;
    }

    static void main() {
        FirstUniqueCharacterInString f = new FirstUniqueCharacterInString();
        String s = "leetcode";
        f.firstUniqChar(s);
    }
}