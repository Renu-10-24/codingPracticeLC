package Recursion;

public class SumOfDigitsOfANumber {
    public static void main(String args[]){
        Sol2 s = new Sol2();
        int A = 34462346;
        int x = s.solve(A);
        System.out.println(x);
    }
}
class Sol2 {
    public int solve(int A) {
        return sumOfDigitsOfA(A,0);
    }
    public int sumOfDigitsOfA(int A, int currSum){
        if(A==0){
            return currSum;
        }
        currSum = currSum + A%10;
        int x = sumOfDigitsOfA(A/10,currSum);
        return x;
    }
}