package contests;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class fibG {
    public static void main(String args[]){
    Sol6 s = new Sol6();
    int[] a = new int[]{3,1,3,1,2,2,6,1,1,6,1};
    int x = s.oneAndTwo(a);
    System.out.println(x);
    }
}

class Sol6 {
    public final long m = (long)Math.pow(10,9)+7;
    public Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    public int oneAndTwo(int[] A) {
        long sum=0L;
        int max=A[0];
        Map<Integer,Integer> mapEle = new HashMap<Integer,Integer>();
        for(int i=0;i<A.length;i++){
            if(A[i]>max){
                max = A[i];
            }
            int val = mapEle.getOrDefault(A[i],0);
            mapEle.put(A[i],++val);
        }
        int[] outputArr = new int[max];
        long pfSum=0L;
        for(int i=1;i<=max;i++){
            pfSum += (long)fibonacci(i)%m;
            pfSum %= m;
            outputArr[i-1] = (int)pfSum;
        }

        Set<Map.Entry<Integer,Integer>> set = mapEle.entrySet();
        Iterator<Map.Entry<Integer,Integer>> i = set.iterator();
        while(i.hasNext()){
            Map.Entry<Integer,Integer> entry = i.next();
            int key = entry.getKey();
            int val = entry.getValue();
            int fOfX = outputArr[key-1];
//            int gOfX = sumOfF(fOfX);
            sum += ((long)fOfX*val)%m;
            sum %= m;
        }
        return (int)sum;
    }
    public int fibonacci(int x){
        int val = map.getOrDefault(x,0);
        int prefixSum = 0;
        int val1=0, val2= 0;
        if(val != 0){
            return val;
        }
        if(x==1 || x==2){
            map.put(x,x);
            return x;
        }
        long x1 = 0L;
        long x2 = 0L;
        long sum = 0L;
        val1 = map.getOrDefault(x-1,0);
        val2 = map.getOrDefault(x-2,0);
        if(val1 != 0){
            x1= val1;
        }else{
            x1= fibonacci(x-1)%m;
        }
        if(val2 != 0){
            x2= val2;
        }else{
            x2= fibonacci(x-2)%m;
        }
        sum = (int)(((long)(x1+x2))%m);
        sum %= m;
        map.put(x,(int)sum);
        return (int)sum;
    }
    public int sumOfF(int x){
        long sum=0L;
        for(int i=1;i<=x;i++) {
            sum += fibonacci(i);
        }
        return (int)sum;
    }
}
