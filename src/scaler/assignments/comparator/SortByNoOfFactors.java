package scaler.assignments.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class SortByNoOfFactors implements Comparator<Integer> {
    public static void main(String args[]){
        SortByNoOfFactors sof = new SortByNoOfFactors();

        Integer[] A =new Integer[]{12,1,5,9,3,6,10};
        System.out.println("Printing no of factors of i : ");
        for(int i : A) {
            System.out.println("Factors of i "+i+" "+sof.getNoOfFactors(i));
        }
        Arrays.sort(A);
        System.out.println("Using comparator of the class..... ");
        for(int i : A) {
            System.out.println(i);
        }
        A =new Integer[]{12,1,5,9,3,6,10};
        System.out.println("Using anonymous inner comparator....");
        Arrays.sort(A, (o1, o2) -> {
            int x1 = sof.getNoOfFactors(o1);
            int x2 = sof.getNoOfFactors(o2);
            if (x1 < x2) {
                return -1;
            } else if (x1 == x2) {
                return 0;
            } else {
                return 1;
            }
        });
        for(int i : A) {
            System.out.println(i);
        }
    }
    public int getNoOfFactors(int number){
        int countOfFactors = 2;
        if(number==1){
            return 1;
        }
        if(number==2){
            return 2;
        }
        for(int i=2;i<= number/2;i++){
            if(number%i==0){
                countOfFactors++;
            }
        }
        return countOfFactors;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        int x1 = this.getNoOfFactors(o1);
        int x2 = this.getNoOfFactors(o2);
        if (x1 < x2) {
            return -1;
        } else if (x1 == x2) {
            return 0;
        } else {
            return 1;
        }
    }
}
