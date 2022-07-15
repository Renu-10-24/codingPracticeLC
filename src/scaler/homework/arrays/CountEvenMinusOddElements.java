package scaler.homework.arrays;

import java.util.Scanner;

public class CountEvenMinusOddElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = 0, arrLength[], arr[][];
		try (Scanner s = new Scanner(System.in)) {
			t = s.nextInt();
			arrLength = new int[t];
			arr = new int[t][];
			for (int i = 0; i < t; i++) {
				arrLength[i] = s.nextInt();
				arr[i] = new int[arrLength[i]];
				for (int x = 0; x < arrLength[i]; x++) {
					arr[i][x] = s.nextInt();
				}
			}
		}
		for (int i = 0; i < t; i++) { 
			int evenCount = 0, oddCount = 0;
			for (int x = 0; x < arrLength[i]; x++) {
				if ((arr[i][x] & 1) == 0) {
					evenCount += 1;
				} else {
					oddCount += 1;
				}
			}
			int diff = evenCount - oddCount;
			System.out.println(diff > 0 ? diff : -diff);
		}
	}
}
