package Recursion;

public class Fibonacci {
    public static void main(String args[]){
        Solution s = new Solution();
        int A =3;
        int x = s.findAthFibonacci(3);
        System.out.println(x);
    }
}
class Solution {
    public int findAthFibonacci(int A) {
        if(A==0 || A==1){
            return A;
        }
        return findAthFibonacci(A-1)+findAthFibonacci(A-2);
    }
}