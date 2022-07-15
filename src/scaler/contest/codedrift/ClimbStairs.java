package scaler.contest.codedrift;
import java.util.Map;
import java.util.HashMap;
public class ClimbStairs {
    public static void main(String args[]) {
        Solution7 s = new Solution7();
        int x = s.climbStairs(6);
        System.out.println(x);
    }
}

class Solution7 {
    Map<Integer,Integer> fibmap = new HashMap<Integer,Integer>();
    //If a person can climb  1 or 2 stairs at a time, what are the ways in which a person can climb A stairs.
    //It is nothing but fibonacci series of A.
    public int climbStairs(int A) {
        if(fibmap.containsKey(A)){
            return fibmap.get(A);
        }
        int value = 0;
        if(A==1 || A==0){
            value = 1;
        }else{
            value = climbStairs(A-1)+climbStairs(A-2);
        }
        fibmap.put(A,value);
        return value;
    }
}
