package scaler.subarrays;

public class ReverseSubarray {

	public static void main(String[] args) {
		int startIndex=2,endIndex=5;
		int [] arr = new int[] {1,2,3,4,5,56,67,100, 52,45};
		for(int i=startIndex;i<endIndex;i++) {
			int temp = arr[startIndex];
			 arr[startIndex] = arr[endIndex];
			 arr[endIndex] = temp;
		}
		for(int i : arr) {
			System.out.println(i);
		}
	}

}
