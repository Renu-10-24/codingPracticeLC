package scaler.homework.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CountDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Sos{
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(final int[] A) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<A.length;i++){
            int val=map.getOrDefault(A[i],0);
            map.put(A[i],val+1);
        }
        int counter=0;
        Set<Entry<Integer,Integer>> set = map.entrySet();
        for(Entry<Integer,Integer> a : set) {
        	int val = a.getValue();
        	if(val>1) {
        		counter += val-1;
        	}
        }
		return counter;
    }
}