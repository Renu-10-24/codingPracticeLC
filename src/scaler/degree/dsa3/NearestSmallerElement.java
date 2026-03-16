package scaler.degree.dsa3;

import java.util.Stack;

public class NearestSmallerElement {
    public int[] prevSmaller(int[] A) {
        Stack<Integer> stack= new Stack<>();
        int[] out = new int[A.length];
        for(int i=0;i<A.length;i++){
            if(stack.empty()){
                out[i] = -1;
                stack.push(A[i]);
            }else if(stack.peek()<A[i]){
                out[i]=stack.peek();
                stack.push(A[i]);
            }else if(stack.peek()>= A[i]){
                while(!stack.empty() && stack.peek()>=A[i]){
                    stack.pop();
                }
                if(stack.empty()){
                    out[i]=-1;
                }else{
                    out[i] = stack.peek();
                }
                stack.push(A[i]);
            }
        }
        return out;
    }

    static void main() {
        NearestSmallerElement n = new NearestSmallerElement();
        int[] A = new int[]{8,23,22,16,22};
        int[] out = n.prevSmaller(A);
        for(int i : out)
        System.out.println(i);
    }
}