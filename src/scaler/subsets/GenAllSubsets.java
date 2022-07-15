package scaler.subsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GenAllSubsets {
    public static void main(String args[]) {
        Solution s = new Solution();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        ArrayList<ArrayList<Integer>> arrList = s.subsets(A);
        for(int i= 0;i<arrList.size();i++){
            List<Integer> list = arrList.get(i);
            for(int j= 0;j<list.size();j++){
                System.out.print(" "+list.get(j));
            }
            System.out.println();
        }
    }
}
class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        // Generate all subsets in ascending order
        int n= A.size();
        Collections.sort(A);
        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for(int i=0;i<(1<<n);i++){
            inputList.add(i);
        }
        System.out.println(" input list ");
        for(int i : inputList){
            System.out.println(i);
        }
        Collections.sort(inputList, new LexComparator());
        System.out.println(" sorted list ");
        for(int i : inputList){
            System.out.println(i);
        }
        ArrayList<ArrayList<Integer>> outputList = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<(1<<n);i++){
            //check which bits are set in binary representation of each number generated
            int x = i;
            ArrayList<Integer> arrList = new ArrayList<Integer>();
            for(int j=0;(1<<j)<=i;j++){
                int m = (1<<j);
//              System.out.println("the expr : "+(i&(1<<j)));
                if((i&(1<<j))==(1<<j)){
                    arrList.add(A.get(j));
                }
            }
            outputList.add(arrList);
            Collections.sort(outputList, new ListComparator<>());
        }
        return outputList;
    }
}
class LexComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        for(int i=0;i<31;i++){
            int x= o1 & (1<<i);
            int y= o2 & (1<<i);
            if (x<y) {
                return -1;
            }else{


            }
        }
        int c = o1.compareTo(o2);
        return c;
    }
}
class ListComparator<T extends Comparable<T>> implements Comparator<ArrayList<T>> {
    @Override
    public int compare(ArrayList<T> o1, ArrayList<T> o2) {
        for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
            int c = o1.get(i).compareTo(o2.get(i));
            if (c != 0) {
                return c;
            }
        }
        return Integer.compare(o1.size(), o2.size());
    }
}