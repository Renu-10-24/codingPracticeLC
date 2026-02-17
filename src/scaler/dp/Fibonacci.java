package scaler.dp;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private Map<Integer,Integer> map = new HashMap<>();
    static void main() {
        Fibonacci fib = new Fibonacci();
        int n=8;

        int output = fib.topDown(n);
        System.out.println("output : "+output);
        output = fib.bottomUp(n);
        System.out.println("output : "+output);
    }
    private int topDown(int n){
        if(n==0 || n==1){
            return 1;
        }
        int fib_prev = map.containsKey(n-1)? map.get(n-1):topDown(n-1);
        int fib_prev_1 = map.containsKey(n-2)? map.get(n-2):topDown(n-2);
        return fib_prev + fib_prev_1;
    }
    private int bottomUp(int n){
        //local array to store the Fibonacci numbers and use them to compute next values suffices, no recursion ==> no need for global array
        int[] fibArray = new int[n+1];
        fibArray[0]=1;
        fibArray[1]=1;
        for(int i=2;i<=n;i++){
            fibArray[i] = fibArray[i-1]+fibArray[i-2];
        }
        return fibArray[n];
    }
}
