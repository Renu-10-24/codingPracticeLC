package scaler.stack;

import java.util.Stack;

public class DoubleCharacterTrouble {
    public String solve(String A) {
        char c[] = A.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<c.length;i++){
            if(!stack.isEmpty()){
                if(stack.peek() == c[i]){
                    stack.pop();
                }else{
                    stack.push(c[i]);
                }
            }else{
                stack.push(c[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            char pop = stack.pop();
            sb.append(pop);
        }
        return sb.reverse().toString();
    }

    static void main() {
        DoubleCharacterTrouble d = new DoubleCharacterTrouble();
        String out = d.solve("abccbc");
        System.out.println(out);
        out = d.solve("ab");
        System.out.println(out);
    }
}
