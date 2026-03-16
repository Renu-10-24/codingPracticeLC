package scaler.degree;

import java.util.HashMap;
import java.util.Map;

public class IsItPalindromicString {
    public int solve(String A) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<A.length();i++) {
            char c= A.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        long oddFreqCount = map.entrySet().stream().mapToInt(e->e.getValue()).filter(i->(i%2!=0)).count();
        if(oddFreqCount >1){
            return 0;
        }else{
            return 1;
        }
    }

    static void main() {
        IsItPalindromicString ps = new IsItPalindromicString();
        String A = new String("aabb");
        int result =ps.solve(A);
        System.out.println(result);
        A = "aabbc";
        result = ps.solve(A);
        System.out.println(result);
        A = "aecbb";
        result = ps.solve(A);
        System.out.println(result);
    }
}
