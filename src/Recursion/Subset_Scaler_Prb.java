package Recursion;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.Comparator;
public class Subset_Scaler_Prb {

	public static void main(String[] args) {
		Stn s = new Stn();
		int[] arr = { 1, 2, 3 };
		int[][] output = s.subsets(arr);
		for(int[] a : output) {
			for(int i : a) {
				System.out.print(i+" ");
			}
		}
	}

}

class Stn {
    public int[][] subsets(int[] A) {
      int[][] output = new int[A.length][];
      List<Integer> path = new ArrayList<>();
      A = IntStream.of(A).boxed().sorted(Comparator.reverseOrder()).mapToInt(x->x).toArray();
	  output = printSubsets(A, 0, path ,output, 0);  
      return output;
    }
    
    public int[][] printSubsets(int[] A, int index, List<Integer> path, int[][] output, int x){
        // Print the subsequence when reach
		// the leaf of recursion tree
		if (index == A.length) {
			// Condition to avoid printing
			// empty subsequence
			if (path.size() > 0){
				// System.out.println(path);
                int[] pathArr = path.stream().mapToInt(i-> i).toArray();
                output[x++]=pathArr;
            }
		}

		else {

			// Subsequence without including
			// the element at current index
			printSubsets(A, index + 1, path,output,x);


 			path.add(A[index]);

			// Subsequence including the element
			// at current index 
			printSubsets(A, index + 1, path, output,x);

			// Backtrack to remove the recently
			// inserted element
			path.remove(path.size() - 1);
		} 
		return output;
	}

    
}