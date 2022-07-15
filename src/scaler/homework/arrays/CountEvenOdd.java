package scaler.homework.arrays;

import java.util.Scanner;

public class CountEvenOdd {

	    public static void main(String[] args) {
	        int t=0,n[],arr[][];
	        try(Scanner s = new Scanner(System.in)){
	            t=s.nextInt();
	            n= new int[t];
	             arr = new int[t][];
	            for(int i=0;i<t;i++){
	                n[i]=s.nextInt();
	                arr[i] = new int[n[i]];
	                for(int x=0;x<n[i];x++){
	                    arr[i][x]=s.nextInt();
	                }
	            }
	        }
	           
	         for(int i=0;i<t;i++){
	                int evenCount=0;
	                int oddCount=0;
	                int result=0;
	                for(int x=0;x<n[i];x++){
	                    if(arr[i][x]%2==0){
	                        evenCount++;
	                    }else{
	                        oddCount++;
	                    }
	                }
	                result = evenCount-oddCount;
	                if(result<0){
	                    result=-result;
	                }
	                System.out.println(result);
	            }
	        
	    }
	}