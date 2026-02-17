package scaler.stack;

import java.util.Stack;

public class MinStackWithStack {
    Stack<Integer> elementStack;
    Stack<Integer> minStack;
    public MinStackWithStack() {
        elementStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        elementStack.push(val);
        if(minStack.empty() || minStack.peek() > val){
            minStack.push(val);
        }
    }

    public void pop() {
        if(elementStack.empty()){
            System.out.println("stack empty");
            return;
        }
        System.out.println("Deleting top  : "+ elementStack.peek());
        int deleted = elementStack.pop();
        //handling duplicates
        if(!elementStack.contains(deleted)) {
            if (minStack.peek() == deleted) {
                minStack.pop();
            }
        }
    }

    public int top() {
        //given top getMin and pop are always on non-empty stacks
        //so idealy we could skip the empty checks
        if(elementStack.isEmpty()){
            return -1;
        }
        return elementStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */