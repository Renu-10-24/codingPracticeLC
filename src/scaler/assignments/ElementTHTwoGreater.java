package scaler.assignments;

import java.util.ArrayList;
//Get all elements in the array with distinct elements that have atleast 2 greater elements
public class ElementTHTwoGreater {
	public static void main(String[] args) {
		ArrayList<Integer> integers = new ArrayList<Integer>();
		integers.add(1);
		integers.add(2);
		integers.add(5);
		integers.add(8);
		integers.add(4);
		integers.add(9);
		
		solve(integers);
	}
	public static ArrayList<Integer> solve(ArrayList<Integer> list){
		int maxElement = Integer.MIN_VALUE;
		int nextToMax = Integer.MIN_VALUE;
		for(int i : list) {
			if(i>maxElement) {
				nextToMax = maxElement;
				maxElement = i;
			}else if(i>nextToMax) {
				nextToMax = i;
			}
		}
		list.remove(nextToMax);
		list.remove(maxElement);
		return list;
	}

}
