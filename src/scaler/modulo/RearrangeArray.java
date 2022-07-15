package scaler.modulo;

import java.util.ArrayList;

public class RearrangeArray {
    public static void main(String args[]){
        Sol7 s = new Sol7();
        ArrayList<Integer> list = new ArrayList<>();
//        4, 0, 2, 1, 3
        list.add(4);
        list.add(0);
        list.add(2);
        list.add(1);
        list.add(3);
        s.arrange(list);
    }
}
class Sol7 {
    public void arrange(ArrayList<Integer> a) {
        int n = a.size();
        for(int i=0;i<n;i++){
            int x = a.get(i);
            x *= n;
            a.set(i, x);
        }
        for(int i=0;i<n;i++){
            int x = a.get(i);
            int y = a.get(x/n);
            a.set(i, x+y/n);
            System.out.print(" "+a.get(i));
        }
        for(int i=0;i<n;i++){
            int x = a.get(i);
            int y = x%n;
            a.set(i,y);
            System.out.print(" "+a.get(i));
        }
    }
}