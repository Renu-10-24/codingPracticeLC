package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenerateSubsets {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6 };
		arr = new int[] { 3, 2, 5, 1 };
		RecursiveSol rsol = new RecursiveSol();
		ArrayList<Integer> list = new ArrayList<Integer>();
//		IntStream s  = Arrays.stream(arr);
		ArrayList<Integer> input = (ArrayList)Arrays.stream(arr).mapToObj(i->i).toList();
		ArrayList<ArrayList<Integer>>  output = rsol.subsets(input);
		
		System.out.println(output);
	}


	
}
class RecursiveSol {
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        // Generate all subsets in ascending order
        A.sort(null);
        ArrayList<Integer> currList = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>>  output = new ArrayList<ArrayList<Integer>>();
        generateSubsets(A,0,currList,output);
        return output;
    }
    
	public void generateSubsets(List<Integer> input, int index, ArrayList<Integer> currList,ArrayList<ArrayList<Integer>> output) {
		System.out.println();
		if (currList.size()>0) {
			System.out.println(currList);
			output.add(currList);
			return;
		}

		generateSubsets(input, index + 1, currList,output);
		currList.add(input.get(index));
		generateSubsets(input, index + 1, currList,output);
		currList.remove(index);
	}
}