package scaler.strings;

import java.util.*;

public class ChangeCharToMinimizeDistinctChars {
    public static void main(String args[]) {
        Solx s = new Solx();
        String A = "abcabbccd";
        int B = 3;
        int countMinDistChar = s.solve(A, B);
        System.out.println(countMinDistChar);
    }
}
class Solx{
    public int solve(String A, int B) {
        int countMinDistChar = 0;
        Map<Character,Integer> treeMap = new TreeMap<>();
        for(int i=0;i<A.length();i++){
            if(!treeMap.containsKey(A.charAt(i))){
                treeMap.put(A.charAt(i),1);
            }else{
                int val = treeMap.getOrDefault(A.charAt(i),0);
                treeMap.put(A.charAt(i),++val);
            }
        }
        int sum = 0,countKeys=0;
        Set<Map.Entry<Character,Integer>> entrySet =treeMap.entrySet();
        Iterator<Map.Entry<Character,Integer>> i =entrySet.iterator();
//        Collections.sort(entrySet,)
        while(i.hasNext() && sum<=B){
            Map.Entry<Character,Integer> entry = i.next();
            int val=entry.getValue();
            sum +=val;
            countKeys++;
        }
        return treeMap.size()-countKeys;
    }
}
