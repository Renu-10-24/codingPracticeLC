package scaler.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortWith2AuxStacks {
    //to simulate a stack with array, we would have to use a pointer to top, that keeps track of the top element
    //something like this
//    class Stack {
//        int[] nums;
//        int top = -1; //-1 denotes, empty stack, increment top with every push, once the array is full, resize and allocate new array all that is burdensome
//    }
    //so dont waste time implementing this public int[] solve(int[] A) - where we should dump all elements into one stack and start with merge sort from there, using extr stacks
    //so use the arraylist version to simulate stack, list.add and list.getLast - peek, would make it easy to work like a stack, pop would be remove(list.size()-1)
    public List<Integer> solve(List<Integer> A) {
        List<Integer> sortedDesc = mergeSortUsingStack(A);
        //pop all to get asc ordered lsit
        List<Integer> result = new ArrayList<>();
        while(!sortedDesc.isEmpty()){
            result.add(sortedDesc.removeLast());
        }
        return result;
    }
    public List<Integer> mergeSortUsingStack(List<Integer> stack){
        //using list as stack
        //dump half elements to another stack
        List<Integer> result =null;
        List<Integer> modifiableStack = new ArrayList<>(stack);
        List<Integer> aux = new ArrayList<>();
        int mid = modifiableStack.size()/2;
        if(modifiableStack.size()<=1){
            return modifiableStack;
        }
        while(modifiableStack.size()>1) {
            while (modifiableStack.size() > mid) {
                int x = modifiableStack.removeLast();
                aux.add(x);
            }
            List<Integer> sorted1 = mergeSortUsingStack(modifiableStack);
            List<Integer> sorted2 = mergeSortUsingStack(aux);
            result = merge(sorted1,sorted2);
            return result;
        }
        return result;
    }

    //mergeSort would return merged sorted stack when given 2 sorted stacks
    List<Integer> merge(List<Integer> sorted1, List<Integer> sorted2){
        List<Integer> sorted = new ArrayList<>();
        List<Integer> modifiableSorted1 = new ArrayList<>(sorted1);
        List<Integer> modifiableSorted2 = new ArrayList<>(sorted2);
        //because we are using list as stack, we should store in descending order to finally asc order on pop.
        while(modifiableSorted1.size()>0 && modifiableSorted2.size()>0) {
            if (modifiableSorted1.getFirst() > modifiableSorted2.getFirst()) {
                sorted.add(modifiableSorted1.removeFirst());
            } else {
                sorted.add(modifiableSorted2.removeFirst());
            }
        }
        while(modifiableSorted1.size()>0){
            sorted.add(modifiableSorted1.removeFirst());
        }
        while(modifiableSorted2.size()>0){
            sorted.add(modifiableSorted2.removeFirst());
        }
        return sorted;
    }

    public
    static void main() {
        SortWith2AuxStacks s = new SortWith2AuxStacks();
        List<Integer> list = Arrays.asList(5, 17, 100, 11);
        List<Integer> out = s.solve(list);
        for(int i: out){
            System.out.println(i);
        }
    }
}