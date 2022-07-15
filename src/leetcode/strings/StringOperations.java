package leetcode.strings;

import java.util.HashSet;
import java.util.Set;

public class StringOperations {
    public static void main(String args[]){
        StrOps ops = new StrOps();
        String A = "AbcaZeoB";
        String   output = ops.solve(A);
        System.out.println(output);
    }
}
class StrOps {
    public String solve(String A) {
        StringBuffer sb = new StringBuffer(A);
        sb.append(A);
        Set<Character> hs = new HashSet<>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        for(int i=0;i<sb.length();){
            char ch = sb.charAt(i);
            if(Character.isUpperCase(ch)){
                sb.replace(i,i+1,"");
            }else if(hs.contains(ch)){
                sb.replace(i,i+1,"#");
            }else{
                i++;
            }
        }
        return sb.toString();
    }
}