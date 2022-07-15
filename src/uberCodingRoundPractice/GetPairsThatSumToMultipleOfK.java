package uberCodingRoundPractice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GetPairsThatSumToMultipleOfK {
    public static void main(String args[]){
        Sol1 s = new Sol1();
        int [] A = new int[]{1, 2, 3, 4, 5};
        int k = 3;
        int x = s.solve(A,k);
        System.out.println(x);
    }
}
class Sol1{
//    You are given an array of integers 'a' and an integer k. Your task is to calculate the number of ways
//    to pick two different indices i<j that a[i] + a[j] is divisible by k.
    public int solve(int[] A, int k){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
//        can be simplified using an array of size k, to store key value pairs
//        ----------------------------------------------------------------------------------------
        for(int i=0;i<A.length;i++){
            int x = A[i]%k;
            int val = map.getOrDefault(x,0);
            map.put(x,++val);
        }
        Set<Map.Entry<Integer,Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer,Integer>> i = entrySet.iterator();
        int count = 0;
        while(i.hasNext()){
            Map.Entry<Integer,Integer> entry = i.next();
            int key = entry.getKey();
            int val = entry.getValue();
            if(key==0 || key == (k-key)){
                count += val*(val-1)/2;
            }else if(key<(k-key)){
                int val1 = map.getOrDefault(k - key, 0);
                count += val * val1;
            }
//            map.remove(key);
//            map.remove(k-key);
        }
        return count;
    }

}