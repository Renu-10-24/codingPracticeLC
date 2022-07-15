package scaler.assignments.hashing;
import java.util.*;
public class FindAllDuplicates {
    public static void main(String args[]) {
        Sol4 s = new Sol4();
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> output = s.findDuplicates(nums);
        for(int i :output){
            System.out.println(i);
        }
    }
}

class Sol4{
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int val = map.getOrDefault(nums[i],0);
            map.put(nums[i],++val);
        }
        Set<Map.Entry<Integer,Integer>> entryset = map.entrySet();
        Iterator i = entryset.iterator();
        List<Integer> list = new ArrayList<Integer>();
        while(i.hasNext()){
            Map.Entry<Integer,Integer> entry = (Map.Entry<Integer,Integer>)i.next();
            int key = entry.getKey();
            int val = entry.getValue();
            if(val>1){
                list.add(key);
            }
        }
        return list;
    }
}