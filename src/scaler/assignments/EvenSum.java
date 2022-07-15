package scaler.assignments;

public class EvenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution5 s= new Solution5();
		int [] A= new int[] {8, 55, 35, 68, 86, 3, 38, 48, 92, 97, 78, 14, 57, 25, 24, 17, 77, 97, 71, 31, 40, 46, 40, 57, 18, 94, 84, 0, 22, 4, 21, 80, 74, 71, 76, 20, 48, 43, 68, 32, 67, 0, 23, 7, 6, 25, 94, 5, 35, 65, 93, 74, 13, 32, 41, 31, 49};
		System.out.println(s.solve(A));
	}

}
class Solution5 {
    public int solve(int[] A) {
        int evensum =0;
        int minOdd =Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++){
            if(A[i]<minOdd && A[i]%2!=0) {
            	minOdd=A[i];
            }
            evensum+=A[i];
            System.out.println("element : "+A[i]);
            System.out.println("sum here : "+evensum);
            }
        if(evensum%2!=0) {
        	return (evensum-minOdd);
        }
        return evensum;
    }
}
