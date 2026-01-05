//package leetcode.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SortJumbledMain {
	public static void main(String args[]) {
		int[] mapping = new int[] { 8, 9, 4, 0, 2, 1, 3, 5, 7, 6 };
		int[] nums = new int[] { 991, 338, 38 };
		Sol4 s = new Sol4();
		int[] output = s.sortJumbledContest(mapping, nums);
		s.practiceMethod2();
	}
}

class Sol4 {
	public int[] sortJumbled(int[] mapping, int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		for (int value : nums) {
			list.add(value);
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		list.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int d1 = 0, d2 = 0, x1 = o1, x2 = o2, r1 = 0, r2 = 0;
				int val1 = map.getOrDefault(o1, -1);
				int val2 = map.getOrDefault(o2, -1);
				if (val1 == -1) {
					while (x1 > 0) {
						d1 = x1 % 10;
						r1 = 10 * r1 + mapping[d1];
					}
					map.put(o1, r1);
				}
				if (val2 == -1) {
					while (x2 > 0) {
						d2 = x2 % 10;
						r2 = 10 * r2 + mapping[d2];
					}
					map.put(o2, r2);
				}
				int t1 = map.get(o1);
				int t2 = map.get(o2);
				if (t1 < t2) {
					return -1;
				} else if (t1 == t2) {
					return 0;
				} else {
					return 1;
				}
			}
		});
		int out[] = new int[list.size()];
		int x1=0;
		for (int val : out) {
			out[x1++] = val;
		}
		return out;
	}

	public int[] sortJumbledContest(int[] mapping, int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
//			ascii value of '0' = 48.. so, to get the integer value subtract the ascii value of '0' from the int value
			String[] numCharsArr = ("" + num).chars().mapToObj(q -> "" + mapping[q - '0']).toArray(String[]::new);
			int[] numAsArr = ("" + num).chars().toArray();
			System.out.println("num : "+num);
			for(int i : numAsArr) {
				System.out.println("i : "+i);
			}
			map.put(num, Integer.parseInt(
						String.join("", numCharsArr)));
		}
		return Arrays.stream(nums).boxed().sorted((o, p) -> map.get(o)- map.get(p))
				.mapToInt(v -> v).toArray();
	}

	public int[] sortJumbledPractice(int[] mapping, int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			Stream<String> streamStr = ("" + num).chars().mapToObj(q -> "" + mapping[q - '0']);
			Stream<Object> streamObj = ("" + num).chars().mapToObj(q -> "" + mapping[q - '0']);
			String[] numCharsArr = ("" + num).chars().mapToObj(q -> "" + mapping[q - '0']).toArray(String[]::new);

//			equivalent syntax for this above line
			String[] numCharsArr1 = ("" + num).chars().mapToObj(q -> "" + mapping[q - '0']).toArray(x->new String[x]);

			map.put(num, Integer.parseInt(
						String.join("", numCharsArr)));
		}
		return Arrays.stream(nums).boxed().sorted((o, p) -> map.get(o)- map.get(p))
				.mapToInt(v -> v).toArray();
	}

	public void practiceMethods(int[] mapping, int[] nums) {
		//to convert primitive int array to stream of Integer and then sort them using the
//		 compare method of the argument
//		 which is Comparator - a functional interface
//		Arrays.stream(int[] arr) - returns an IntStream - stream of ints
//		Arrays.stream(nums).sorted() - for natural order sorting
//		for stream to primitive int
//		Arrays.stream(nums).toArray();
		//for custom comparator- we need to use the boxed stream
//		stream.mapToInt - to convert from Stream of Integers to IntStream
		Arrays.stream(nums).boxed().sorted((o1,o2)->o1.compareTo(o2)).mapToInt(o->o).toArray();
//		IntStream to int[]  vs Stream of Integers to Integer[]

	}

	public void practiceMethod2() {
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);

		Integer[] array = intList.stream()
		                             .filter(x -> x > 2)
		                             .toArray(x -> {
		                                System.out.println("x --> " + x);
		                                return new Integer[x];
		                              });

		System.out.println("array length         : " + array.length);
		System.out.println("array elements here  : ");
		Stream.of(array).forEach(System.out::println);


	    int[] array2 = intList.stream()
	                             .filter(x -> x > 2)
	                             .mapToInt(x->x)
	                             .toArray();
	    for(int i : array2) {
	    	System.out.println(array2);
	    }

	}
}
//approach 2
class Sol45 {
//    public int[] sortJumbled(int[] mapping, int[] nums) {
//		List<leetcode.contest.Pair> pairs = new ArrayList<leetcode.contest.Pair>();
//		for (int num : nums) {
//            int x = num;
//            int y = 0, multpr = 1;
//            if(x == 0){
//                y=mapping[x];
//            }
//            while(x>0){
//                y= y+ multpr*(x%10);
//                multpr *= 10;
//                x /= 10;
//            }
//            Pair p = new Pair(num,y);
//			pairs.add(p);
//        }
//        for (Pair p : pairs) {
//            System.out.println(p.x);
//		}
//		Collections.sort(pairs, new Comparator<Pair>() {
//			@Override
//			public int compare(Pair p1, Pair p2) {
//				return p1.y-p2.y;
//			}
//		});
//		int out[] = new int[pairs.size()];
//		int x1=0;
//		for (leetcode.contest.Pair p : pairs) {
//            System.out.println(p.x);
//			out[x1++] = p.x;
//		}
//		return out;
//	}
}
