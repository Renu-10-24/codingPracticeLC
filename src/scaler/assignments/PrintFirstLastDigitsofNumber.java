package scaler.assignments;
import java.util.*;
public class PrintFirstLastDigitsofNumber {
    public static void main(String[] args) {
        int t = 0, arr[];
		try (Scanner s = new Scanner(System.in)) {
			t = s.nextInt();
			arr = new int[t];
			for(int i=0;i<t;i++){
			    arr[i]=s.nextInt();
			}
        }
        for(int i=0;i<t;i++){
            int firstDigit = arr[i]%10;
            int lastDigit = arr[i]/10;
            while(lastDigit>=10){
                lastDigit/=10;
            }
            if(lastDigit==0) {
            	lastDigit=firstDigit;
            }
            System.out.println(lastDigit+" "+firstDigit);
        }
    }
}

