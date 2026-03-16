package scaler.degree.dsa1;

import java.util.*;
//when asked for subarray, I found out the StrictlyIncreasingSubseq with max sum. Find the subarray in the other file
public class StrictlyIncreasingSubseqMaxSum {
    public long solve(int[] A) {
        List<Set<Integer>> possibleSubarrays = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        set.add(A[0]);
        possibleSubarrays.add(set);
        boolean addedtoExisting =false;
        for(int i=1;i<A.length;i++){
            addedtoExisting =false;
            for(Set<Integer> s : possibleSubarrays){
                int x = s.stream().max(Comparator.naturalOrder()).get();
                if(x<A[i]){
                    s.add(A[i]);
                    addedtoExisting=true;
                }
            }
            if(!addedtoExisting){
                Set<Integer> newSet = new HashSet<>();
                newSet.add(A[i]);
                possibleSubarrays.add(newSet);
            }
        }
        //process sum for each subarray here
        long maxSum = 0; // all elements are >=0
        for(Set<Integer> aset : possibleSubarrays){
            long sum = aset.stream().mapToLong(a->((long) a)).sum();
            if(sum > maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }

    static void main() {
        int[] A = new int[]{5,4,2,3,4,6};
        StrictlyIncreasingSubseqMaxSum s = new StrictlyIncreasingSubseqMaxSum();
        long result = s.solve(A);
        System.out.println("1 : "+result);
        A = new int[]{8,10,4,2,6,11,12,5,6,7,8,9,10};
        result = s.solve(A);
        System.out.println("2 : "+result);

        System.out.println(1<<3);
    }
}

