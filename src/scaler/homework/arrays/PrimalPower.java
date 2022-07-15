package scaler.homework.arrays;

public class PrimalPower {

	public static void main(String[] args) {
		

	}

}
class Stion {
    public int solve(int[] A) {
        int primalPower = 0;
        for(int i=0;i<A.length;i++){
            if(checkPrime(A[i])){
                primalPower++;
            }
        }
        return primalPower;
    }
    public boolean checkPrime(int x){
        boolean isPrime = true;
        if(x<=1){
            return false;
        }
        for(int i=2;i*i<=x;i++){
            if(x%i==0){
                isPrime = false;
            }
        }
        return isPrime;
    }
}