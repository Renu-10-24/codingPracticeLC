package leetcode.contest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class AlternatingArray {

	public static void main(String[] args) {
		Solxn s = new Solxn();
		int[] nums = new int[] {3,1,3,2,4,3};
		int x = s.minimumOperations(nums);
		System.out.println("x : "+x);

	}

}
class Solxn {
    public int minimumOperations(int[] nums) {
        Map<Integer,Integer> map1 = new HashMap<Integer,Integer>();
        Map<Integer,Integer> map2 = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                int val1 = map1.getOrDefault(nums[i],0);
                map1.put(nums[i],++val1);
            }else{
                int val2 = map1.getOrDefault(nums[i],0);
                map2.put(nums[i],++val2);
            }
        }
        Iterator<Map.Entry<Integer,Integer>> i1 =map1.entrySet().iterator();
        Iterator<Map.Entry<Integer,Integer>> i2 =map2.entrySet().iterator();
        int max1 = 0;
        int maxKey1=0;
        int max2 = 0;
        int maxKey2=0;
        while(i1.hasNext()) {
        	Entry<Integer,Integer> entry = i1.next();
        	int val = entry.getValue();
        	int key = entry.getKey();
        	if(val>max1) {
        		max1 = val;
        		maxKey1= key;
        	}
        }
        while(i2.hasNext()) {
        	Entry<Integer,Integer> entry = i2.next();
        	int val = entry.getValue();
        	int key = entry.getKey();
        	if(val>max2) {
        		max2 = val;
        		maxKey2 = key;
        	}
        }
        int x = map1.size()-max1;
        int y = map2.size()-max2;
        if(x > y) {
        	if(maxKey1 != maxKey2) {
        		return x + y;
        	}else {
        		return x + map2.size();
        	}
        }else {
        	if(maxKey1 != maxKey2) {
        		return x + y;
        	}else {
        		return x + map1.size();
        	}
        }
        
        
    }
}