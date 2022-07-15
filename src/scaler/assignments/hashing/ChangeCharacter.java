package scaler.assignments.hashing;

import java.util.*;

public class ChangeCharacter {
    public static void main(String args[]){
        Sol1 s = new Sol1();
        String A = "abcabbccd";
        int B = 3;
        int x =s.solve(A,B);
        System.out.println(x);
        A="wfnfozvsrt";
        B=4;
        x =s.solve(A,B);
        System.out.println(x);
    }
}
class Sol1 {
    public int solve(String A, int B) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0;i<A.length();i++){
            int val = map.getOrDefault(A.charAt(i),0);
            map.put(A.charAt(i),++val);
        }

        Collection<Integer> values = map.values();
        Integer[] valuesArr= values.toArray(new Integer[0]);
        Arrays.sort(valuesArr);
        int count = 0;
        int keyCount = map.size();
        int replaced = 0;
        for(int i : valuesArr){
            if((count+i)<=B){
                count += i;
                replaced++;
            }
        }
        return (keyCount-replaced);
    }
}