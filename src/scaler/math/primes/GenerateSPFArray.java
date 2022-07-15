package scaler.math.primes;

public class GenerateSPFArray {
    //similar to generating isPrimeArr
    public static void main(String args[]){
        GenerateSPFArray spf = new GenerateSPFArray();
        int n =50;
        int[] outputSpfArray = spf.getSpfArray(n);
//        for(int i : outputSpfArray){
//            System.out.println(i);
//        }
        int[] outputSegmentedSieve = spf.spfSegmentedSieveForRange(37,55);
        for(int i : outputSegmentedSieve){
            System.out.println(i);
        }
    }
    //Sieve of erastothenes way of getting factors of all numbers till N
    public int[] getSpfArray(int n){
        int[] spfArray = new int[n+1];
        for(int i=0;i<spfArray.length;i++){
            spfArray[i]=i;
            System.out.println(i);
        }
        GetAllPrimesTillN genPrime = new GetAllPrimesTillN();
        for(int i=2;i*i<=n;i++){
            if(genPrime.isPrime(i)){
                for(int j=i*i;j<=n;j=j+i){
                    if(spfArray[j]==j) {
                        spfArray[j] = i;
                    }
                }
            }
        }
        return spfArray;
    }
    //Segmented sieve of Erastothenes to get Prime numbers for a given range of numbers
//    public int[] spfSegmentedSieve(int[] numbers){
    public int[] spfSegmentedSieveForRange(int min, int max){
        GetAllPrimesTillN gPrimes = new GetAllPrimesTillN();
        int n = max-min+1;
        int[] spfSegmentedSieve = new int[n];
        //initialize with numbers from min to max
        int minVal = min;
        for(int i=0;i<n;i++){
            spfSegmentedSieve[i] = minVal++;
        }
        for(int t=2;t*t<=max;t++){
            if(gPrimes.isPrime(t)){
            for(int j1=(min/t)*t+t;j1<=max;j1=j1+t){
                int x = j1-min;
                if(spfSegmentedSieve[x]>t) {
                    spfSegmentedSieve[x] = t;
                }
            }

            }
        }
        return spfSegmentedSieve;
    }

    public int[] spfSegmentedSieve(int[] numbers){
        GetAllPrimesTillN gPrimes = new GetAllPrimesTillN();
        int min = numbers[0];
        int max = numbers[0];
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]>max){
                max = numbers[i];
            }else if(numbers[i]<min){
                min = numbers[i];
            }
        }
        int n = max-min+1;
        int[] spfSegmentedSieve = new int[n];
        //initialize with numbers from min to max
        int minVal = min;
        for(int i=0;i<n;i++){
            spfSegmentedSieve[i] = minVal++;
        }
        for(int t=2;t*t<=max;t++){
            if(gPrimes.isPrime(t)){
                for(int j1=(min/t)*t+t;j1<=max;j1=j1+t){
                    int x = j1-min;
                    if(spfSegmentedSieve[x]>t) {
                        spfSegmentedSieve[x] = t;
                    }
                }
            }
        }
        for(int i=0;i<spfSegmentedSieve.length;i++){
            System.out.println(spfSegmentedSieve[i]);
        }
//        for(int i=0;i<numbers;) {
//        }

        return null;
    }
}
