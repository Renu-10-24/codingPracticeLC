package scaler.assignments;

import java.util.*;

public class SearchElementMultipleArrays {

	public static void main(String[] args) {

		int t = 0, searchFor[], arrLength[], arr[][];
		try (Scanner s = new Scanner(System.in)) {
			t = s.nextInt();
			arrLength = new int[t];
			arr = new int[t][];
			searchFor = new int[t];
			for (int i = 0; i < t; i++) {
				arrLength[i] = s.nextInt();
				arr[i] = new int[arrLength[i]];
				for (int x = 0; x < arrLength[i]; x++) {
					arr[i][x] = s.nextInt();
				}
				searchFor[i] = s.nextInt();
			}
		}
		int[] isFoundIntArr = new int[t];

		for (int i = 0; i < t; i++) {
			int low = 0, high = arrLength[i] - 1, mid = 0;
			Arrays.sort(arr[i]);
			isFoundIntArr[i] = 0;
			while (low <= high) {
				mid = low + (high - low) / 2;
				if (searchFor[i] < arr[i][mid]) {
					high = mid - 1;
				} else if (searchFor[i] > arr[i][mid]) {
					low = mid + 1;
				} else if (searchFor[i] == arr[i][mid]) {
					isFoundIntArr[i] = 1;
					break;
				}
			}
			// index of search element, or index to search the element if not present
			if (low > high) {
				isFoundIntArr[i] = 0;

			}
		}

		for (int i = 0; i < t; i++) {
			System.out.println(isFoundIntArr[i]);
		}
	}
}