package scaler.degree.ps2test;

import java.util.HashMap;
import java.util.Map;

public class StringsMap {
    static void main() {
        String A = "abaaaacbb";
        String B = "abc";
        StringsMap sm = new StringsMap();
        int a = sm.solve(A,B);
        System.out.println(a);
    }
public int solve(String A,String B){
        Map<Character,Integer> m = new HashMap<>();
        char[] aArr = A.toCharArray();
        char[] bArr = B.toCharArray();
        for(char c: aArr){
            m.put(c,m.getOrDefault(c,0)+1);
        }
        for(char d: bArr){
            m.put(d,m.getOrDefault(d,0)-1);
        }
        for(Map.Entry<Character,Integer> e : m.entrySet()){
            int v = e.getValue();
            if(v<0){
                return 0;
            }
        }
        return 1;
    }
}
