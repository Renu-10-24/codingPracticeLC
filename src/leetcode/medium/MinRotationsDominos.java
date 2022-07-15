package leetcode.medium;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

//https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
public class MinRotationsDominos {

	public static void main(String[] args) {
		Sol s = new Sol();
		int[] tops = { 2, 1, 2, 4, 2, 2 };
		int[] bottoms = { 5, 2, 6, 2, 3, 2 };
//		System.out.println("returning : " + s.minDominoRotations(tops, bottoms));
		tops = new int[] { 2, 2, 4, 3, 3 };
		bottoms = new int[] { 5, 3, 3, 4, 5 };
//		System.out.println("returning : " + s.minDominoRotations(tops, bottoms));
		tops = new int[] { 2, 2, 5, 3, 3 };
		bottoms = new int[] { 3, 3, 3, 4, 6 };
//		System.out.println("returning : " + s.minDominoRotations(tops, bottoms));
		
		Soll soll = new Soll();
		tops = new int[] { 1,2,1,1,1,2,2,2 };
		bottoms = new int[] {2,1,2,2,2,2,2,2};
		System.out.println("Returning : " + soll.minDominoRotations(tops, bottoms));
	}
}

class Sol {
	public int minDominoRotations(int[] tops, int[] bottoms) {
		// find the most frequent value in tops first
		Map<Integer, Integer> treemapTops = new TreeMap<Integer, Integer>();
		Map<Integer, Integer> treemapBottoms = new TreeMap<Integer, Integer>();
		int maxFreq = 0;
		for (int i = 0; i < tops.length; i++) {
			if (!treemapTops.containsKey(tops[i])) {
				treemapTops.put(tops[i], 1);
			} else {
				int val = treemapTops.get(tops[i]);
				treemapTops.put(tops[i], ++val);
			}
			if (!treemapBottoms.containsKey(bottoms[i])) {
				treemapBottoms.put(bottoms[i], 1);
			} else {
				int val = treemapBottoms.get(bottoms[i]);
				treemapBottoms.put(bottoms[i], ++val);
			}
		}
		for (int i = 0; i < tops.length; i++) {
			int val = treemapTops.get(tops[i]);
			if (val > maxFreq) {
				maxFreq = val;
			}
		}

		Set<Integer> topskeyset = treemapTops.keySet();
		for (Integer key : topskeyset) {
			int minRotations = 0;
			for (int i = 0; i < tops.length; i++) {
				if (treemapTops.containsKey(tops[i]) && treemapBottoms.containsKey(tops[i])) {
					if (treemapBottoms.getOrDefault(tops[i], 0) > treemapTops.getOrDefault(tops[i], 0)) {
						if (bottoms[i] != key) {
							if (bottoms[i] == key) {
								minRotations++;
							} else {
								break;
							}
						}
					}
				}
				if (tops[i] != key) {
					if (bottoms[i] == key) {
						minRotations++;
					} else {
						break;
					}
				}
			}
			if (minRotations == tops.length - treemapTops.get(key)) {
				return minRotations;
			}
		}
		return -1;
	}
}

class Soll {
	public int minDominoRotations(int[] tops, int[] bottoms) {
		int[] topsCount = new int[7];
		int[] bottomsCount = new int[7];
		int[] totalCount = new int[7];
		for (int i = 0; i < tops.length; i++) {
			topsCount[tops[i]]++;
			bottomsCount[bottoms[i]]++;
		}
		
		for (int i = 0; i < totalCount.length; i++) {
			int minRotations =0;
			totalCount[i] = topsCount[i] + bottomsCount[i];
			if(totalCount[i] >=tops.length) {
				//find how many min swaps reqd here.
				if(topsCount[i]>=bottomsCount[i]) {
					//iterate over the bottoms array to find if the element is i
					for(int x=0;x<bottoms.length;x++) {
						if(tops[x]!=i) {
							if(bottoms[x]!=i) {
								break;
							}else {
								minRotations++;
							}
						}
					}
					if(minRotations == tops.length-topsCount[i]) {
						return minRotations;
					}
				}else {
					for(int x=0;x<bottoms.length;x++) {
						if(bottoms[x]!=i) {
							if(tops[x]!=i) {
								break;
							}else {
								minRotations++;
							}
						}
					}
					if(minRotations == tops.length-bottomsCount[i]) {
						return minRotations;
					}
				}
			}
		}
		return -1;
	}
}
