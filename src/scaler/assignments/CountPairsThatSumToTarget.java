package scaler.assignments;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CountPairsThatSumToTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sol1 s1 = new Sol1();
		Sol2 s2 = new Sol2();
		Sol3 s3 = new Sol3();
		Sol4 s4 = new Sol4();
		int[] A = new int[] { 15, 50, 10, 50, 60, -10, 45, 0, 10 };
		int[] A1 = new int[] { 1, 2, 3, 2, 1 };
		int[] A2 = new int[] { 1, 1, 1 };
		int[] A3 = new int[] { 1, 1, 6, 7, 3, 3, 10, 9, 3, 6 };
		int[] A4 = new int[] { 2, 4, 9, 1, 9, 7, 6, 4, 9 };
//		System.out.println(s1.solve(A,60));
//		System.out.println(s2.solve(A,60));
//		System.out.println(s3.solve(A, 60)); //6
//		System.out.println(s3.solve(A1,5));  //2
//		System.out.println(s3.solve(A2,2));  //3
//		System.out.println(s3.solve(A3,4));  //6 
//		System.out.println(s3.solve(A4,8));  //3
		
	//using treemap	
		System.out.println(s4.solve(A, 60)); //6
		System.out.println(s4.solve(A1,5));  //2
		System.out.println(s4.solve(A2,2));  //3
		System.out.println(s4.solve(A3,4));  //6 
		System.out.println(s4.solve(A4,8));  //3
	}

}

class Sol1 {
	public int solve(int[] A, int B) {
		Arrays.sort(A);
		int countOfPairs = 0;
		for (int p1 = 0, p2 = A.length - 1; p1 < p2;) {
			if (A[p1] + A[p2] == B) {
				countOfPairs++;
				p1++;
			} else if (A[p1] + A[p2] < B) {
				p1++;
			} else if (A[p1] + A[p2] > B) {
				p2--;
			}
		}
		return countOfPairs;
	}
}

class Sol2 {
	public int solve(int[] A, int B) {
		int countOfPairs = 0;
		// hashset when there are no duplicates in the array.
		Set<Integer> hashSet = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (!hashSet.contains(B - A[i])) {
				hashSet.add(A[i]);
			} else {
				countOfPairs++;
			}
		}
		return countOfPairs;
	}
}

class Sol3 {
	public int solve(int[] A, int B) {
		int countOfPairs = 0;
		HashMap<Integer, Integer> hashmapFreq = new HashMap<Integer, Integer>();
		TreeSet<Integer> treeset = new TreeSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (!hashmapFreq.containsKey(A[i])) {
				hashmapFreq.put(A[i], 1);
			} else {
				int value = hashmapFreq.get(A[i]);
				hashmapFreq.put(A[i], value + 1);
			}
		}

		for (int i = 0; i < A.length; i++) {
			treeset.add(A[i]);
		}
		Object[] arr = treeset.toArray();

		for (int i = 0; i < arr.length; i++) {// && countOfPairs<=arr.length*(arr.length-1)/2
			int el_i = (int) arr[i];
			if (el_i > (B - el_i)) {
				break;
			}
			if (treeset.contains(B - el_i)) {
				int freqX = hashmapFreq.get(el_i);
				int freqY = hashmapFreq.get(B - el_i);
				if (el_i == B - el_i) {
					countOfPairs += freqX * (freqX - 1) / 2;
				} else {
					countOfPairs += freqX * freqY;
				}
			}
		}
		return countOfPairs;
	}
}
//using TreeMap
class Sol4 {
	public int solve(int[] A, int B) {
		int countOfPairs = 0;
		TreeMap<Integer, Integer> treemapFreq = new TreeMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			if (!treemapFreq.containsKey(A[i])) {
				treemapFreq.put(A[i], 1);
			} else {
				int value = treemapFreq.get(A[i]);
				treemapFreq.put(A[i], value + 1);
			}
		}
		
		Object[] objArray=treemapFreq.keySet().toArray();
		for (int i = 0; i < objArray.length; i++) {
			int el_i = (int) objArray[i];
			if (el_i > (B - el_i)) {
				break;
			}
			if (treemapFreq.containsKey(B - el_i)) {
				int freqX = treemapFreq.get(el_i);
				int freqY = treemapFreq.get(B - el_i);
				if (el_i == B - el_i) {
					countOfPairs += freqX * (freqX - 1) / 2;
				} else {
					countOfPairs += freqX * freqY;
				}
			}
		}
		return countOfPairs;
	}
}