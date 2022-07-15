package Recursion;

public class StringPalindrome {
    public static void main(String args[]){
        Sol11 s = new Sol11();
        int x = s.solve("madam");
        System.out.println( x);
    }
}
class Sol11 {
    public int solve(String A) {
        return isPalindrome(A,0,A.length()-1);
    }
    public int isPalindrome(String A, int index1,int index2){
        if(index1>index2){
            return 1;
        }
        char ch1 = A.charAt(index1);
        char ch2 = A.charAt(index2);
        if(ch1 == ch2){
            return isPalindrome(A,++index1,--index2);
        }
        return 0;
    }
}