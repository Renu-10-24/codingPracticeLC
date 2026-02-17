package scaler.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] A) {
        Stack<Integer> postFix = new Stack<>();
        Map<String,String> operators = new HashMap<>();
        operators.put("*","*");
        operators.put("/","/");
        operators.put("+","+");
        operators.put("-","-");

        int result = 0;
        for(int i= 0;i<A.length;i++){
            try {
                if (!operators.containsKey(A[i])) {
                    postFix.push(Integer.parseInt(A[i]));
                } else {
                    int x = postFix.pop();
                    int y = postFix.pop();
                    switch (A[i]) {
                        case "*":
                            result = y * x;
                            break;
                        case "+":
                            result = y + x;
                            break;
                        case "-":
                            result = y - x;
                            break;
                        case "/":
                            result = x != 0 ?
                            y / x : 0;
                    }
                    postFix.push(result);
                }
            }catch(ArithmeticException | NumberFormatException ae){
                ae.printStackTrace();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        if(!postFix.isEmpty())
        return postFix.pop();
        return 0;
    }

    static void main() {
        ReversePolishNotation r = new ReversePolishNotation();
        String[] strings = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(r.evalRPN(strings));
        strings = new String[]{"2","2","/"};
        System.out.println(r.evalRPN(strings));
    }
}
