package Recursion;

import java.lang.*;
        import java.util.*;

public class StringReverse {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String reverseStr = reverse(str,0,str.length()-1);
        System.out.println(reverseStr);
    }
    public static String reverse(String str,int start, int end){
        char ch = str.charAt(start);
        if(start==(str.length()-1)){
            return ch+"";
        }
        return reverse(str,start+1,end)+(ch+"");
    }
}