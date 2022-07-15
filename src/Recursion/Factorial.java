package Recursion;

public class Factorial {

	public static void main(String[] args) {
		Son1 s = new Son1();
		int A = 5;
		int factorial =s.factorial(A);
		System.out.println("printing fact : "+factorial );

	}

}
class Son1 {
	public int factorial(final int A) {
		if(A==0) {
			System.out.println("A is 0");
			return 1;
		}else {
			System.out.println("print A");
			return factorial(A-1)*A;
		}
	}
}
