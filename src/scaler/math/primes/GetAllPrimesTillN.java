package scaler.math.primes;

import java.util.ArrayList;
import java.util.List;

public class GetAllPrimesTillN {

    public static void main(String args[]) {
        //get all primes from 2 - N inclusive of both
        int n = 37;
        List<Integer> output = getListOfPrimesTillN(n);
        for(int i : output){
            System.out.println(i);
        }
    }

    public static boolean isPrime(int n){
        int count = 0;
        if(n==2){
            return true;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    //sieve of erastothenes
    public static List<Integer> getListOfPrimesTillN(int n){
        boolean isPrimeArr[] = new boolean[n+1];
        for(int i=2;i<=37;i++){
            isPrimeArr[i] = true;
        }
        isPrimeArr[0]= false;
        isPrimeArr[1]= false;
        for(int i=2;i*i<=n;i++){
            if(isPrime(i)){
                for(int j=i*i;j<=n;j=j+i){
                    isPrimeArr[j]=false;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(isPrimeArr[i]){
                list.add(i);
            }
        }
        return list;
    }

}

