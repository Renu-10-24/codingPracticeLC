package scaler.stack;

import java.util.Stack;

public class PassingGame {
    public int solve(int A, int B, int[] C) {
        Stack<Integer> stack = new Stack<>();
        stack.push(B);
        for(int i=0;i<A;i++){
            if(C[i]!=0){
                stack.push(C[i]);
            }else{
                stack.pop();
            }
        }
        return stack.peek();
    }

    static void main() {
        PassingGame p = new PassingGame();
        int A= 10, B=23;
        int[] C = new int[]{86, 63, 60, 0, 47, 0, 99, 9, 0, 0};
        int out = p.solve(A,B,C);
        System.out.println(out);
    }
}
