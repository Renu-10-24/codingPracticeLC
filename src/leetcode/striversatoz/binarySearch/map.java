package striversatoz.binarySearch;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class map {
    public int solution(int N, int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        int count =0;
        Set<Map.Entry<Integer,Integer>> entrySet = map.entrySet();
        for(Map.Entry<Integer,Integer> entry : entrySet){
            int key =entry.getKey();
            int val = entry.getValue();
            if(val > N/k){
                count ++;
            }
        }

        return count;
    }

    static void main() {
        map m= new map();
        int[] n = new int[]{2,2,2,2,3,3,3,3,3,4,4,4,5,5,6};
        int count = m.solution(15,n,5);
        System.out.println(count);
        n = new int[]{5,5,5,5,5};
        count = m.solution(5,n,1);
        System.out.println(count);
        //
        n = new int[]{1,2,2,3,1,1,4};
        count = m.solution(7,n,3);
        System.out.println(count);
    }
}