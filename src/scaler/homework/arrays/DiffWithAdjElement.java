package scaler.homework.arrays;

public class DiffWithAdjElement {

	public static void main(String[] args) {
		Solution s= new Solution();
		int[] a = new int[] {6, 2, 4, 4, 3};
		int [] output = s.solve(a);
		for(int x : output) {
			System.out.print(x+" ");
		}
	}

}
class Solution {
    public int[] solve(int[] A) {
        int[] outputDiffArray = new int[A.length];
        if(A.length==1){
            return outputDiffArray;
        }
        int i=0;
        for(;i<A.length-1;i++){
            outputDiffArray[i]=A[i+1]-A[i];
        }
        outputDiffArray[i]=A[i]-A[i-1];
        return outputDiffArray;
    }
}