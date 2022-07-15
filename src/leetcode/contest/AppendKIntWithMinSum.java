package leetcode.contest;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class AppendKIntWithMinSum {

	public static void main(String[] args) {
		Sn3 s = new Sn3();
		int[] nums = new int[] {1,4,25,10,25};
		int k = 2;
		long x = s.minimalKSum(nums, k);
		System.out.println(x);
	}

}
class Sn3 {
	
    public long minimalKSum(int[] nums, int k) {
    	Set<Integer> s = new TreeSet<Integer>();
    	for(int i=0;i<nums.length;i++) {
    		s.add(nums[i]);
    	}
    	Iterator<Integer> i = s.iterator();
    	long t = 0L;
    	int prev_x = 1;
    	while(i.hasNext()) {
    		int x = i.next();
    		if(k>(x-prev_x-1)) {
    			t = t+sum(x,prev_x);
    		}else {
    			t = t+ sum(prev_x+k-1,prev_x);
    		}
    		
    		prev_x = x;
    	}
    	return t;
    }
    public long sum(int x, int prev_x) {
    	long sum = 0L;
    	for(int i = prev_x+1;i<x;i++) {
    		sum += i;
    	}
    	return sum;
    }
}