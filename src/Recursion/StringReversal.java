package Recursion;

public class StringReversal {

	public static void main(String[] args) {
		String str = "hello world !!";
		StringReversal sr = new StringReversal();
		System.out.println(sr.reverseString(str));
	}
	public String reverseString(String s) {
		if(s.isEmpty()) {
			return s;
		}
		return reverseString(s.substring(1))+s.charAt(0);
	}
}
