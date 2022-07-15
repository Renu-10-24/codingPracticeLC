package leetcode.medium;

import java.util.*;

public class IntersectionOfArrays {
    public static void main(String args[]) {
        Sation s = new Sation();
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        int[] output = s.intersect(nums1, nums2);
        for(int i=0;i<output.length;i++){
            System.out.print(output[i]+" ");
        }
    }
}
class Sation {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer,Integer> map1 = new HashMap<Integer,Integer>();
            Map<Integer,Integer> map2 = new HashMap<Integer,Integer>();
            List<Integer> outputList = new ArrayList<Integer>();

            for(int i=0;i<nums1.length;i++){
                int val = map1.getOrDefault(nums1[i],0);
                map1.put(nums1[i],++val);
            }
            for(int i=0;i<nums2.length;i++) {
                int val = map2.getOrDefault(nums2[i], 0);
                map2.put(nums2[i], ++val);
            }
            Set<Integer> keys=map1.keySet();
            Iterator<Integer> keysIterator = keys.iterator();
            while(keysIterator.hasNext()) {
                int key = keysIterator.next();
                if(map2.containsKey(key)){
                    int val1 = map1.get(key);
                    int val2 = map2.get(key);
                    if(val1>val2){
                        while(val2>0){
                            outputList.add(key);
                            val2--;
                        }
                    }else{
                        while(val1>0){
                            outputList.add(key);
                            val1--;
                        }
                    }
                }
            }

            int[] output = new int[outputList.size()];
            for(int i=0;i<outputList.size();i++){
                output[i] = outputList.get(i);
            }
            return output;
        }
}