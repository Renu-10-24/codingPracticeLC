package scaler.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinCostToDelete {
    public static void main(String args[]){
        int[] a = new int[]{2,1,4,6,3,8};
        a = new int[]{2,4,1};
        Arrays.sort(a);
        int x = getCostToDelete(a);
        System.out.println(x);
        a = new int[]{-10,5,4,5,1,1,1};
        Arrays.sort(a);
        x=countOfNobleNumbers(a);
        System.out.println("count : "+x);
    }
    public static int getCostToDelete(int[] a){
        int sum=0, curSum=0;
        for(int i = 0;i<a.length;i++){
            curSum +=a[i];
            sum +=curSum;
        }
        return sum;
    }
    public static int countOfNobleNumbers(int[] a){
        int count=0;
        int noOfLesserElements = 0;
        for(int i=0;i<a.length;i++){
            if(i>0 && a[i-1]==a[i]){
                continue;
            }
            if(a[i]==i){
                count++;
            }
        }
        return count;
    }
}
