package Recursion;

public class MergeSort {

	public static void main(String[] args) {
		SolnMerge s = new SolnMerge();
		int[] A = new int[] { 4, 1, 3, 2, 0, -1, 7, 10, 9, 20 };
		s.mergeSort(A, 0, A.length - 1);
	}
}

class SolnMerge {
	public void mergeSort(int[] A, int start, int end) {
		int mid;
		if(start==end) {
			return;
		}
		if (start < end) {
			mid = (end + start) / 2;
			mergeSort(A, start, mid);
			mergeSort(A, mid+1, end);
			merge(A, start, mid, end);
			for(int i=start;i<=end;i++)
				System.out.println("index : "+i+"element : " +A[i]);
		}
	}

	public void merge(int[] A, int start, int mid, int end) {
		int[] sortedArray = new int[end-start+1];
		int ptr1 = start;
		int ptr2 = mid+1;
		for (int i = 0;i<end-start+1;) {
			while (ptr1 <= mid && ptr2 <= end) {
				if (A[ptr1] > A[ptr2]) {
					sortedArray[i++] = A[ptr2];
					ptr2++;
				} else {
					sortedArray[i++] = A[ptr1];
					ptr1++;
				}
			}
			
			while(ptr1<=mid) {
				sortedArray[i++] = A[ptr1];
				ptr1++;
			}
			while(ptr2<=end) {
				sortedArray[i++] = A[ptr2];
				ptr2++;
			}
		}
		//copy sorted values to input array
		for(int i=start,x=0;i<=end;i++) {
			A[i]=sortedArray[x++];
		}
	}
}
