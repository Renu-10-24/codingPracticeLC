package walmart;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class TopKFreqElements {
    public int[] topKFrequent_optimized_with_minHeap(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        //priority queue is a min heap
        Queue<Integer> minHeap = new PriorityQueue<>((n1,n2) -> map.get(n1).compareTo(map.get(n2))); //n1, n2 are keys and we are comparing the values to sort keys
        for(int num : map.keySet()) {
            minHeap.add(num);
            System.out.println(minHeap.toString());
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] out =minHeap.stream().mapToInt(Integer::intValue).toArray();
        return out;
    }

    public int[] topKFrequent_optimized_with_grouping_by_freq_STREAMS(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        List<Integer>[] groupByFreqArray = new List[nums.length+1];
        //array at index i stores list of elements that have a freq i
        for (int i : map.keySet()) {
            if (groupByFreqArray[map.get(i)] == null) {
                groupByFreqArray[map.get(i)] = new ArrayList<>();
            }
            groupByFreqArray[map.get(i)].add(i);
        }
        //since we need the top k elements
        List<Integer> outList = new ArrayList<>();
//        for(int i=groupByFreqArray.length-1;i>=k;i--){
//            if(null !=groupByFreqArray[i]) {
//                if (outList.size() < k) {
//                    outList.addAll(groupByFreqArray[i]);
//                }
//            }
//        }

        for (int i = groupByFreqArray.length - 1; i >= k; i--) {
//            Optional.ofNullable(groupByFreqArray[i])
//                    .filter(list -> outList.size() < k)
//                    .ifPresent(outList::addAll);
            List<Integer> list = groupByFreqArray[i];
            if(null != list){
                if(list.size()<k){
                    outList.addAll(list);
                }
            }
        }

        int[] out =outList.stream().mapToInt(Integer::intValue).toArray();
        return out;
    }

    public int[] topKFrequent_optimized_with_grouping_by_freq(int[] nums, int k) {
            if(k==nums.length){
                return nums;
            }
            Map<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<nums.length;i++){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }

            List<Integer>[] groupByFreqArray = new List[nums.length+1];
            //array at index i stores list of elements that have a freq i
            for (int i : map.keySet()) {
                if (groupByFreqArray[map.get(i)] == null) {
                    groupByFreqArray[map.get(i)] = new ArrayList<>();
                }
                groupByFreqArray[map.get(i)].add(i);
            }
            //since we need the top k elements
            List<Integer> outList = new ArrayList<>();

            for (int i = groupByFreqArray.length - 1; i >= 0; i--) {
                List<Integer> list = groupByFreqArray[i];
                if(null != list){
                    if(outList.size()<k){
                        outList.addAll(list);
                    }else{
                        break;
                    }
                }
            }

            int[] out =outList.stream().mapToInt(Integer::intValue).toArray();
            return out;
        }

    public int[] topKFrequent_Using_Custom_comparator_likeinpriorityq(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        //note we cannot use the values() - > that is a set of values - repeated values are lost. so get stream of keys, sorted by values desc with a custom comparator and limit to k

        Comparator<Map.Entry<Integer,Integer>> compareByValue = (e1,e2)->e1.getValue().compareTo(e2.getValue());
        int[] keysOrderedByFreqDesc_limited_k = map.entrySet().stream().sorted(compareByValue.reversed()).mapToInt(e->e.getKey()).limit(k).toArray();
        return keysOrderedByFreqDesc_limited_k;
    }


    public int[] topKFrequent_streamified(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Map<Integer,Long> freqMap = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        //priority queue is a min heap
        Queue<Integer> minHeap = new PriorityQueue<>((n1,n2) -> freqMap.get(n1).compareTo(freqMap.get(n2))); //n1, n2 are keys and we are comparing the values to sort keys
        minHeap.addAll(freqMap.keySet());
        while(minHeap.size()>k){
            minHeap.poll();
        }

        int[] out =minHeap.stream().mapToInt(Integer::intValue).toArray();
        return out;
    }

    static void main() {
        TopKFreqElements t = new TopKFreqElements();
        int[] nums = new int[]{1,2,1,2,1,2,3,1,3,2};
        nums = new int[]{2,2,1,1,3,2,2,4,4,4,4,4,2,2,1,1,3};
//        nums = new int[]{1};
        int[] out = t.topKFrequent_optimized_with_grouping_by_freq(nums,2); // if we need top k values, we should use a min heap , adding all elements and root would be the smallest, deleting till
        for(int i : out ){
            System.out.println(i);
        }
    }
}