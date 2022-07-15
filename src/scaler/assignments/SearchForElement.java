package scaler.assignments;

import java.util.Scanner;

public class SearchForElement {

	public static void main(String[] args) {
	      int T = 0, searchFor[] = null,returnArr[];
	        int arr[][] = null;
	        try (Scanner scanner = new Scanner(System.in)) {
	            //no of testcases.
	            T = scanner.nextInt();
	            arr = new int[T][];
	            searchFor= new int[T];
	            for (int i = 0; i < T; i++) {
	              int arrLength = scanner.nextInt();
//	                arr[i].length=arrLength;
	              arr[i] = new int[arrLength];
	                for(int j=0;j<arrLength;j++){
	                    arr[i][j] = scanner.nextInt();
	                }
	                searchFor[i] = scanner.nextInt();
	            }
	        }
	            returnArr= new int[T];
	            for (int i = 0; i < T; i++) {
	            	int j;
	                for( j=0;j<arr[i].length;j++){
	                    if(searchFor[i]==arr[i][j]){
	                        returnArr[i]=1;
	                        break;
	                    }       
	                }
	                if(j>arr[i].length){
	                    returnArr[i]=0;
	                }
	                System.out.println(returnArr[i]);
	            }
	         
	    }
}
