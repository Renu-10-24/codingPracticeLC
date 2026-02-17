package scaler.stack;

import java.util.ArrayList;
import java.util.List;

public class MinStackImplWithList {
List<Integer> elementStack = new ArrayList<>();
List<Integer> minStack = new ArrayList<>();
    public MinStackImplWithList() {

    }

    public void push(int val) {
        elementStack.add(val);
        if(minStack.isEmpty() || minStack.getLast() > val){
            minStack.add(val);
        }
    }

    public void pop() {
        System.out.println("Element at top is removed : "+ top());
        //check for empty
        if(elementStack.isEmpty()){
            System.out.println("Stack Empty");
            return;
        }
        if(elementStack.getLast()==minStack.getLast()){
            minStack.removeLast();
        }
        elementStack.removeLast();
    }

    public int top() {
        System.out.println("element at top is : "+ elementStack.getLast());
        return elementStack.getLast();
    }

    public int getMin() {
        if(minStack.isEmpty()){
            return -1;
        }
        System.out.println("Getting last element inserted into min : "+minStack.getLast());
        return minStack.getLast();
    }

    static void main() {
        MinStackImplWithList minStack = new MinStackImplWithList();
        int min = minStack.getMin();
        System.out.println("Min is : "+min);
        minStack.push(10);
        System.out.println("Pushed 10");
        minStack.pop();
        minStack.top();
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