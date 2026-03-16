Longest Palindromic Substring
Problem Description

Given a string A of size N, find and return the longest palindromic substring in A.

Substring of string A is A[i...j] where 0 <= i <= j < len(A)

Palindrome string:
A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.

Incase of conflict, return the substring which occurs first ( with the least starting index).



Problem Constraints
1 <= N <= 6000



Input Format
First and only argument is a string A.



Output Format
Return a string denoting the longest palindromic substring of string A.



Example Input
Input 1:
A = "aaaabaaa"
Input 2:

A = "abba


Example Output
Output 1:
"aaabaaa"
Output 2:

"abba"


Example Explanation
Explanation 1:
We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
Explanation 2:

We can see that longest palindromic substring is of length 4 and the string is "abba".


User Code

public class Solution {
public String longestPalindrome(String A) {
if(A.length==1){
return A;
}
int start =0,end =0;
for(int i=0;i<A.length();i++){
int len1 = expand(A,i,i);
int len2 = expand(A,i,i+1);
int len = Math.max(len1,len2);
if(len > end -start +1){
int left = i -(len-1)/2;
int right = i +len/2;
start =left;
end = right;
}
}
return A.substring(start,end+1);
}
private static int expand(String A, int l, int r){
while(l>=0 && r<A.length() && A.charAt(l)==A.charAt(r)){
l--;
r++;
}
return r-l+1;
}
}
 
