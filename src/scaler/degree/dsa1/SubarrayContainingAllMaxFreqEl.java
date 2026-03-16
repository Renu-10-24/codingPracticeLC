package scaler.degree.dsa1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

//Chef.md
public class SubarrayContainingAllMaxFreqEl {
    public int solve(int[] A) {
        int left=0,right=0, max= 0;
        Map<Integer,Integer> freqmap = new HashMap<>();
        Map<Integer,Integer> firstOcr = new HashMap<>();
        Map<Integer,Integer> lastOcr = new HashMap<>();
        for(int i=0;i<A.length;i++){
            int num = A[i];
            int val = freqmap.getOrDefault(num,0)+1;
            freqmap.put(num,val);
            firstOcr.putIfAbsent(num,i);
            lastOcr.put(num,i);
            if(val >max){
                max =val;
            }
        }
        System.out.println("fron the loop   : "+max);
        max = (int)(freqmap.values().stream().max(Comparator.naturalOrder())).get();
        System.out.println("fron the stream : "+max);
        int finalMax = max;
        // in Production , use this -->  .peek(val -> log.debug("After filter: {}", val))
        Set<Integer> set = freqmap.entrySet().stream().filter(e->e.getValue()== finalMax).map(e-> e.getKey()).collect(Collectors.toSet());
        System.out.println(set);
        int firstIndex = firstOcr.entrySet().stream().filter(e ->set.contains(e.getKey())).peek(debug("After filtering keys for maxFreq")).map(e->e.getValue()).peek(debug("values of filtered key")).min(Comparator.naturalOrder()).get();
        int lastIndex = lastOcr.entrySet().stream().filter(e ->set.contains(e.getKey())).peek(System.out::println).map(e->e.getValue()).peek(System.out::println).max(Comparator.naturalOrder()).get();
        for(int i=0;i<A.length;i++){
            if(freqmap.get(A[i])==max){
                left =i;
                break;
            }
        }
        for(int j=A.length-1;j>=0;j--){
            if(freqmap.get(A[j])==max){
                right =j;
                break;
            }
        }
        System.out.println("From streams : firstIndex : "+firstIndex);
        System.out.println("From streams : lasstIndex : "+lastIndex);
        System.out.println("From loop    : left       : "+left);
        System.out.println("From loop    : right      : "+right);
        return lastIndex-firstIndex+1;
    }
    public static <T> Consumer<T> debug(String stage) {
        return value -> System.out.println(stage + ": " + value);
    }
    static void main() {
        SubarrayContainingAllMaxFreqEl s = new SubarrayContainingAllMaxFreqEl();
        int[] nums = new int[]{3, 2, 1, 2, 5, 6};
        int ans=s.solve(nums);
        System.out.println(ans);
        nums = new int[]{1, 2, 2, 3, 3};
        ans = s.solve(nums);
        System.out.println(ans);
    }
}