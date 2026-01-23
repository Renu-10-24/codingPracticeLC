package concurrency.assignment.one;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ArrayCreator implements Callable<List<Integer>> {
    private static int n=10;
    public ArrayCreator(int n){
        this.n = n;
    }
    public List<Integer> call(){
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        return list;
    }
}