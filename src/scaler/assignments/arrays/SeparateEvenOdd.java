package scaler.assignments.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeparateEvenOdd {
	public static void main(String[] args) {
		int t = 0, arr[][], arrLength[];
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
		List<Integer> evenlist = new ArrayList<Integer>();
		List<Integer> oddlist = new ArrayList<Integer>();
		for (int i = 0; i < t; i++) {
//			evenlist = new ArrayList<Integer>();
//			oddlist = new ArrayList<Integer>();
			for (int x = 0; x < arrLength[i]; x++) {
				if (!(arr[i][x] % 2 == 0)) {
					oddlist.add(arr[i][x]);
				} else {
					evenlist.add(arr[i][x]);
				}
			}
			if (!oddlist.isEmpty()) {
				for (int x : oddlist) {
					System.out.print(x);
				}
			}
			System.out.println();
			if (!evenlist.isEmpty()) {
				for (int y : evenlist) {
					System.out.print(y);
				}
				System.out.println();
				evenlist.clear();
				oddlist.clear();
			}
		}
	}
}