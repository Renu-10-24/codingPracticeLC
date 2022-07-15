package Recursion;

public class Sum1ToN {

	public static void main(String[] args) {
		int n = 10;
		Sum1ToN s = new Sum1ToN();
		System.out.println(s.sum(n));
	}
	public int sum(int n) {
		if(n == 1) {
			return 1;
		}
		return n+sum(n-1);
	}
}
