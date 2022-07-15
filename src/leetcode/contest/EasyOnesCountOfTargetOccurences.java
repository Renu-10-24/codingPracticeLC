package leetcode.contest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class EasyOnesCountOfTargetOccurences {

	public static void main(String[] args) {
		So3 s = new So3();
		int[] nums = new int[] {1,100,200,1,100};
		int key = 1;
		int count= s.mostFrequent(nums, key);
		System.out.println(count);
		nums = new int[]{2,2,2,2,3};

	}

}
class So3 {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==key){
                int y = map.getOrDefault(nums[i],0);
                map.put(nums[i],++y);
            }
        }
        Set<Map.Entry<Integer,Integer>> entrySet= map.entrySet();
        int max = Integer.MIN_VALUE;
        int maxKey = nums[1];
        Iterator<Map.Entry<Integer,Integer>> i = entrySet.iterator();
        while(i.hasNext()) {
        	Entry<Integer,Integer> e = i.next();
        	int k = e.getKey();
        	int v = e.getValue();
        	if(v>max) {
        		max =v;
        		maxKey = k;
        	}
        }
        return maxKey;
    }
}