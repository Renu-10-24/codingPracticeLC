package scaler.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SortStackWithOneAuxStack {

public List<Integer> solve(List<Integer> A) {
    //implement sorting using stacks
    //move elements into a stack
    Stack<Integer> stack = new Stack<>();
    for(int i=0;i<A.size();i++){
        stack.push(A.get(i));
    }
    Stack<Integer> auxStack = new Stack<>();
    while(!stack.isEmpty()) {
        if(auxStack.isEmpty()){
            auxStack.push(stack.pop());
        }
        while ((!auxStack.isEmpty() && !stack.isEmpty()  && auxStack.peek() <= stack.peek())) {
            auxStack.push(stack.pop());
        }
        while(!auxStack.isEmpty() && !stack.isEmpty() && stack.peek() < auxStack.peek()){
            int temp = stack.pop();
            if(stack.empty()){
                stack = new Stack<>();
            }
            while(!auxStack.isEmpty() && auxStack.peek() > temp){
                stack.push(auxStack.pop());
            }
            auxStack.push(temp);
        }
    }
    List<Integer> out = new ArrayList<>(auxStack);
    return out;
}


    static void main() {
        SortStackWithOneAuxStack s = new SortStackWithOneAuxStack();
        List<Integer> out=s.solve(new ArrayList<>(Arrays.asList(10, 2,3,51,6)));
//        out = s.solve(new ArrayList<>(Arrays.asList(44,19,1,20,25,80,90,91,50,45,83,78,50,16,78,23,25,20,38,14)));
        out = s.solve(new ArrayList<>(Arrays.asList(1,3,2,5,7,6,4,2,1)));

//        out = s.solve(new ArrayList<>(Arrays.asList(65,1)));
        for(int i : out){
            System.out.println(i);
        }
    }
}