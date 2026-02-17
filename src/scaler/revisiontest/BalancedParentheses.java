package scaler.revisiontest;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParentheses {
    public String solve(String A) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> matchingBraces = new HashMap<>();
        matchingBraces.put('{','}');
        matchingBraces.put('[',']');
        matchingBraces.put('(',')');
        for(int i =0 ;i<A.length();i++){
            char ch = A.charAt(i);
            if(matchingBraces.keySet().contains(ch)){
                stack.push(ch);
            }else if (matchingBraces.values().contains(ch)){
                if(!stack.isEmpty() && matchingBraces.get(stack.peek()) == ch){
                    stack.pop();
                }else{
                    return "No";
                }
            }
        }
        if(stack.empty()){
            return "Yes";
        }
            return "No";
    }

    static void main() {
        BalancedParentheses b = new BalancedParentheses();
        String result = b.solve("");
        System.out.println(result);
    }
}