package scaler.homework.arrays;

public class AtleastTwoGreater {

	public static void main(String[] args) {
		Soln s = new Soln();
		int[] A = new int[] {11,21,100,78,45};
		s.solve(A);

	}

}
class Soln {
    public int[] solve(int[] A) {
        //since all elements are distinct we can initialize an arry of size A.length-2
        int[] resultArr = new int[A.length-2];
        int maxValue = Integer.MIN_VALUE,nextToMax = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
        	if(A[i]>maxValue){
                nextToMax=maxValue;
                maxValue=A[i];
            }else if(A[i]>nextToMax){
                nextToMax=A[i];
            }
        }
        System.out.println(nextToMax);
        int x=0;
        for(int i=0;i<A.length;i++){
            if(A[i]<nextToMax){
                resultArr[x]=A[i];
                x++;
            }
        }
        return resultArr;
    }
    public int[][] solve1(int A) {
        int[][] resultArr = new int[A][A];
        for(int i=0;i<A;i++){
            for(int j=0;j<=i;j++){
                resultArr[i][j]=j;
            }
            for(int k=i+1;k<A;k++){
                resultArr[i][k]=0;
            }
        }
        return resultArr;
    }
}