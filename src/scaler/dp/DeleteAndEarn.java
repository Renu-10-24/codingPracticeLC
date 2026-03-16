package scaler.dp;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//top down approach with recursion and memoization
class DeleteAndEarn {
    private Map<Integer,Integer> points = new HashMap<>();
    private Map<Integer,Integer> cache = new HashMap<>();
    public int deleteAndEarn(int[] nums) {
        //preprocess and populate the points map
        //find the maxNum in the array
        int maxNum = 0;
        for(int i=0;i<nums.length;i++){
            points.put(nums[i],points.getOrDefault(nums[i],0)+1);
            maxNum = Math.max(maxNum,nums[i]);
        }
        points.values().stream().max(Comparator.naturalOrder());
        int max =0;
        for(int i : points.values()){
            if(i>max){
                max = i;
            }
        }
        for(Map.Entry<Integer,Integer> e : points.entrySet()){
            int key = e.getKey();
            int val = e.getValue();
            points.put(key, key*val);
            System.out.println("key : "+key+ " value : "+points.get(key));
        }
        return maxPoints(maxNum);
    }
    private int maxPoints(int num){
        if(num==0){
            return 0;
        }
        if(num==1){
            return points.getOrDefault(1,0);
        }
        if(cache.containsKey(num)){
            return cache.get(num);
        }
        //apply recurrence relation
        int gain = points.getOrDefault(num,0);
        cache.put(num,Math.max(maxPoints(num-1),maxPoints(num-2)+gain));
        return cache.get(num);
    }
}