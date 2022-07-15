package Recursion;

//Java code to print all possible
//subsequences for given array using
//recursion
import java.util.*;
import java.util.stream.IntStream;

public class GenerateSubseq {
	// Driver code
	public static void main(String[] args) {
//		int[] arr = { 1, 2, 3 };
		int[] arr = {2,3,1};
	    arr = IntStream.of(arr).boxed().sorted(Comparator.reverseOrder()).mapToInt(x->x).toArray();
		// Auxiliary space to store each path
		ArrayList<Integer> path = new ArrayList<>();
		GFG.printSubsequences(arr, 0, path);
	}
}

class GFG {

//Recursive function to print all
//possible subsequences for given array
	public static void printSubsequences(int[] arr, int index, ArrayList<Integer> path) {

		// Print the subsequence when reach
		// the leaf of recursion tree
		if (index == arr.length) {
			// Condition to avoid printing
			// empty subsequence
			if (path.size() > 0)
				System.out.println(path);
				int[] pathArr = path.stream().mapToInt(i-> i).toArray();
		}

		else {

			// Subsequence without including
			// the element at current index
			printSubsequences(arr, index + 1, path);

 			path.add(arr[index]);

			// Subsequence including the element
			// at current index 
			printSubsequences(arr, index + 1, path);

			// Backtrack to remove the recently
			// inserted element
			path.remove(path.size() - 1);
		} 
		return;
	}

}