package capitalOnePrep;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put((Character)'(',(Character)')');
        map.put((Character)'{',(Character)'}');
        map.put((Character)'[',(Character)']');
        Stack<Character> stack = new Stack<>();
        char [] c = s.toCharArray();
        if((c.length%2)!=0){
            return false;
        }
        for(char ch: c ){
            if(map.containsKey(ch)){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char x=stack.peek();
                if(map.get(x)==ch){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    static void main() {
        ValidParentheses v = new ValidParentheses();
        String s = "()[]{}";
        s= "(]";
        s="([]";
        s="([])";
        s= "([)]";
        v.isValid(s);
    }
}