package capitalOnePrep;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class AreTheyValidAnagrams {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        int slen = s.length();
        int tlen = t.length();
        if(slen != tlen){
            return false;
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int val = map.getOrDefault(ch,0);
            map.put(ch,++val);
        }
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            int val =map.getOrDefault(ch,0);
            if(val==0){
                return false;
            }else{
                map.put(ch,--val);
            }
        }
        Collection<Integer> values = map.values();
        for(int i : values){
            if(i>0){
                return false;
            }
        }
        return true;
    }

    static void main() {
        AreTheyValidAnagrams a = new AreTheyValidAnagrams();
        String x = "anagram", b= "nagaram";
        a.isAnagram(x,b);
    }
}