package Recursion;

public class FunctionalRecursionExample {
	public static void main(String[] args) {
		String str = "madame";
		boolean x = isPalindrome(0,str);
		System.out.println("x is : "+x);
	}
	 static  boolean isPalindrome(int i, String str) {
		if(i>=str.length()/2)
			return true;
		if((str.charAt(i)) == (str.charAt(str.length()-i-1))) {
			return isPalindrome(i+1,str);
		}
		return false;
	 }
}
