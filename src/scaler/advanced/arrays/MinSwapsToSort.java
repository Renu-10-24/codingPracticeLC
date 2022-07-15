package scaler.advanced.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSwapsToSort {
    public static void main(String args[]) {
        Sol53 s = new Sol53();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(0);
        int x =s.solve(list);
        System.out.println("x : "+x);
        list = List.of(2,0,1,3);
        x =s.solve(list);
        System.out.println("x : "+x);
    }
}
class Sol90 {
    public int solve(List<Integer> A) {
        int count=0;
        Pair[] pairs = new Pair[A.size()];
        for(int i=0;i<A.size();i++) {
            int x = A.get(i);
            pairs[i] =  new Pair(x,i);
        }
        Arrays.sort(pairs);
        for(int i=0;i<A.size();i++) {
            int y = A.get(i);
            if(pairs[i].x == y){
                count++;
            }
        }
        return A.size()-1-count;
    }
}
class Sol53 {
    //simple swap technique
    public int solve(List<Integer> A) {
        int count=0;
        // since we have elements 0 to n-1 in the array..
        for(int i=0;i<A.size();i++){
            while(A.get(i) != i) {
                int x = A.get(i);
                int y = A.get(x);
                A.set(i,y);
                A.set(x,x);
                count++;
            }
        }
        return count;
    }

//    try the cycles method next
//    try the Pair wise sorting technique as well..

}
class Pair implements Comparable<Pair>{
    int x;
    int y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair o) {
        if(this.x < o.x) {
            return -1;
        }else if(this.x==o.x) {
            return 0;
        }else {
            return 1;
        }
    }
}