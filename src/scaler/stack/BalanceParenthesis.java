package scaler.stack;

import java.util.Stack;

public class BalanceParenthesis {
    public static void main(String args[]){
        Solution s = new Solution();
        int x = s.solve("(()())");
        System.out.println(x);
        x = s.solve("(()");
        System.out.println(x);
    }
}
class Solution {
    public int solve(String A) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<A.length();i++) {
            char ch = A.charAt(i);
            if (ch == '('){
                stack.push(ch);
            }else if (ch == ')'){
                if(!stack.empty()){
                    stack.pop();
                }else{
                    return 0;
                }
            }
        }
        if(!stack.empty()){
            return 0;
        }
        return 1;
    }
}
