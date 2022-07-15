package scaler.assignments;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class UniqueElementsInASC {

	public static void main(String[] args) {
		int t = 0, arr[][], arrLength[];
		try (Scanner s = new Scanner(System.in)) {
			t = s.nextInt();
			arrLength = new int[t];
			arr = new int[t][];

			for (int i = 0; i < t; i++) {
				arrLength[i] = s.nextInt();
				arr[i] = new int[arrLength[i]];
				for (int x = 0; x < arrLength[i]; x++) {
					arr[i][x] = s.nextInt();
				}
			}
		}

		for (int i = 0; i < t; i++) {
			TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
			for (int x = 0; x < arrLength[i]; x++) {
				if (!treeMap.containsKey(arr[i][x])) {
					treeMap.put(arr[i][x], 1);
				} else {
					int value = treeMap.get(arr[i][x]);
					treeMap.put(arr[i][x], ++value);
				}
			}
			Set<Entry<Integer, Integer>> entryset = treeMap.entrySet();
//	    List<Integer> returnList = new ArrayList<Integer>();
			for (Entry<Integer, Integer> entry : entryset) {
				if ((int) entry.getValue() == 1) {
//	    		returnList.add((int)entry.getKey());
					System.out.print((int) entry.getKey() + " ");
				}
			}
			System.out.println();
		}
	}
}
