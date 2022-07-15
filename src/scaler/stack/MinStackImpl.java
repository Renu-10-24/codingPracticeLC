package scaler.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Scanner;

public class MinStackImpl {
    public static void main(String args[]) {
        SolUsingStack s = new SolUsingStack();
        s.pop();
        s.push(10);
        s.push(20);
        int x = s.getMin();
        System.out.println(x);
        s.push(30);
        s.push(4);
        x= s.getMin();
        System.out.println("Min : "+x);
        s.top();
        s.pop();
        x=s.getMin();
        System.out.println("Min : "+x);
        s.top();
        s.pop();
        x=s.getMin();
        System.out.println("Min : "+x);
        s.pop();
        x=s.getMin();
        System.out.println("Min : "+x);
        int T = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            //no of testcases.
            T = scanner.nextInt();
            for (int i = 0; i <= T; i++) {
                char c = scanner.next().charAt(0);
                if (c == 'P') {
                    int value = Integer.parseInt(scanner.next());
                    s.push(value);
                } else if (c == 'p') {
                    s.pop();
                } else if (c == 't') {
                    s.top();
                } else if (c == 'g') {
                    s.getMin();
                }
            }
        }
    }
}
    class Sol1 {
    //implementing stack with Array list - dynamic array in java
        List<Integer> stack = new ArrayList<Integer>();
        List<Integer> minStack = new ArrayList<Integer>();

        public void push(int x) {
                int index = stack.size();
                stack.add(x);
                if (minStack.isEmpty() || x <= getMin()) {
                    minStack.add(x);
                }
                System.out.println("pushed to stack at index : "+index);

        }

        public void pop() {
            if (stack.isEmpty()) {
                System.out.println("stack empty");
                return;
            } else {
                int top = stack.get(stack.size() - 1);
                System.out.println("Removed : "+top);
                stack.remove(stack.size() - 1);
                if(getMin()==top){
//                    minStack.pop();
                }
            }
        }

        public int top() {
            int x =0;
            if (!stack.isEmpty()) {
                x = stack.get(stack.size() - 1);
                System.out.println("top : " + x);
                return x;
            }
            else {
                System.out.println("top : " + -1);
                return -1;
            }
        }

        public int getMin() {
            if (!minStack.isEmpty()) {
                int x = minStack.get(minStack.size() - 1);
//            minStack.remove(minStack.size() - 1);
//                System.out.println("min : "+x);
                return x;
            } else
                return -1;
        }
    }
class SolUsingStack {
    //using built in stack java
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        int index = stack.size();
        stack.push(x);
        if (minStack.isEmpty() || x <= getMin()) {
            minStack.push(x);
        }
        System.out.println("pushed "+x+ " to stack at index : "+index);

    }

    public void pop() {
        if (stack.isEmpty()) {
            System.out.println("stack empty");
            return;
        } else {
            int top = stack.peek();
            System.out.println("Removed : "+top);
            stack.pop();
            if(getMin()==top){
                minStack.pop();
            }
        }
    }

    public int top() {
        int x =0;
        if (!stack.isEmpty()) {
            x = stack.peek();
            System.out.println("top : " + x);
            return x;
        }
        else {
            System.out.println("top : " + -1);
            return -1;
        }
    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            int x = minStack.peek();
//            minStack.remove(minStack.size() - 1);
//            System.out.println("min : "+x);
            return x;
        } else
            return -1;
    }
}
