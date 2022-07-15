package Recursion;

public class IsPalindrome {

	public static void main(String[] args) {
		String str = "MADAM";
		IsPalindrome isP = new IsPalindrome();
		System.out.println(isP.isPalin(str));
	}

	public boolean isPalin(String s) {
		System.out.println(s);
		if (s.length() == 1) {
			return true;
		}
		if (s.charAt(0) == s.charAt(s.length() - 1)) {
			return isPalin(s.substring(1, s.length()-1)); // endIndex is excluded.
		} else
			return false;
	}

}
