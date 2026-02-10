package walmart.countSubarrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountSubarrays {
    public long countSubarrays(int[] nums, long k) {
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        long count=0;
        int left =0;
        for(int right =0;right<nums.length;right++){
            // maintain decreasing maxDeque
            while(!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <=nums[right]){
                maxDeque.pollLast();
            }

            // maintain increasing minDeque
            while(!minDeque.isEmpty() && nums[minDeque.peekLast()] >=nums[right]){
                minDeque.pollLast();
            }
            maxDeque.addLast(right);
            minDeque.addLast(right);

            //shrink window size if cost > k
           // while(!maxDeque.isEmpty() && !minDeque.isEmpty() && (long) nums[maxDeque.peekFirst()] - ){

            }
        return 9L;
    }
    static void main() {
        Deque<Integer> arrayDeque = new ArrayDeque<>();

        arrayDeque.add(1);
        arrayDeque.addFirst(2);
        arrayDeque.addLast(3);
        System.out.println(arrayDeque);
        for(int i : arrayDeque) {
            System.out.println("i : "+i);
        }
    }
}
