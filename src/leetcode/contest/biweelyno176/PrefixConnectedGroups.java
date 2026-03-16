package contest.biweelyno176;

import java.util.HashMap;
import java.util.Map;

class LongestCommonPrefix {

    public String longestCommonPrefix(String[] str) {
        int minIndex = str.length;
        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<str.length;i++){
            if(str[i].length()<minLen){
                minIndex = i;
                minLen = str[i].length();
            }
        }
        String longestCommonPrefix = str[minIndex];
        for(int i=0;i<str.length;){
            while(!str[i].startsWith(longestCommonPrefix)){
              longestCommonPrefix = longestCommonPrefix.substring(0,--minLen);

            }
            if(minLen ==0){
                return "";
            }
            if(minLen > 0 ){ //str[i].startsWith(longestCommonPrefix.substring(0,minLen))){
                i++;
            }
        }

        return longestCommonPrefix.substring(0,minLen);
    }
}
public class PrefixConnectedGroups {
    public int prefixConnected(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            String prefix = words[i].substring(0,k);
            map.put(prefix,map.getOrDefault(prefix,0)+1);
        }
        int result =map.entrySet().stream().mapToInt(entry->entry.getValue()).filter(i->i>1).toArray().length;
        return result;
    }

    static void main() {
        PrefixConnectedGroups p = new PrefixConnectedGroups();
        String[] words = new String[]{"apple","apply","banana","bandit"};
        int k=2;
        System.out.println(p.prefixConnected(words,k));
        words = new String[]{"car","cat","cartoon"};
        k=3;
        System.out.println(p.prefixConnected(words,k));
        words = new String[]{"bat","dog","dog","doggy","bat"};
        k=3;
        System.out.println(p.prefixConnected(words,k));
        words = new String[]{"jjsfz","jjyjefwylzxbxuwufzdhrmfbdbuwiyqdhlkzfehhrmurembtvzufcemmnvdae"};
        k=2;
        System.out.println(p.prefixConnected(words,k));
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = new String[]{"flower", "flow", "flight"};
        String lcpString = lcp.longestCommonPrefix(strs);
        System.out.println(lcpString);
    }

}