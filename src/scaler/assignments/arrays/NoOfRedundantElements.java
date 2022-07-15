package scaler.assignments.arrays;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class NoOfRedundantElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NoOfRedundantElements n = new NoOfRedundantElements();
		int[] A = new int[] { 156629687, 156629687, 950873097, -816928664, 633452756, 156629687, -816928664, 950873097, 950873097 };
		int a = 950873097;
		System.out.println(a);
		n.solve(A);
	}
	public int solve(final int[] A) {
        HashMap<Integer,Integer> hashMap = new HashMap();
        for(int i=0;i<A.length;i++){
            if(hashMap.containsKey(A[i])){
                int value = hashMap.get(A[i]);
                hashMap.put(A[i],++value);
            }else{
                hashMap.put(A[i],1);
            }
        }
        int sum=0;
        Set<Entry<Integer,Integer>> entrySet = hashMap.entrySet();
        for(Entry<Integer,Integer> entry : entrySet){
            int value = entry.getValue();
            sum = sum+value-1;
        }
        return sum;
}
}
