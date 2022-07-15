package scaler.advanced.arrays;

public class FindSmallestPsIngrMissing {
    public static void main(String args[]){
        int[] a = new int[]{-2,1,4,3,2,-8,1,7,6};
        int x =0;
        FindSmallestPsIngrMissing f = new FindSmallestPsIngrMissing();
//        x = f.getSmallestPosIngrMissing(a);
        System.out.println(x);
        Sol5 s = new Sol5();
        a = new int[]{-2,0,4,3,2,-8,1,7,6,-4};
        a= new int[]{ 2, 3, 1, 2};
        x=s.firstMissingPositive(a);
        System.out.println(x);
    }
    public int getSmallestPosIngrMissing(int[] a){
        boolean[] boolArr = new boolean[a.length];
        for(int i=0;i<a.length;i++){
            int x = a[i];
            boolArr[Math.abs(a[i])-1]=true;
        }
        for(int i=0;i<a.length;i++){
            if(boolArr[i]==false){
                return i+1;
            }
        }
        return a.length+1;
    }

}
class Sol5 {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        for(int i=0;i<n;i++){
            if(A[i]<=0){
                A[i]=n;
            }
        }
        for(int i=0;i<n;i++){
            int x = A[i];
            if(A[Math.abs(x)-1] >= 0){ // to skip making the number negative once a particular number is already found..
                A[Math.abs(x)-1] = -A[Math.abs(x)-1];
            }
        }
        for(int i=0;i<n;i++){
            if(A[i]>0){
                return i+1;
            }
        }
        return n+1;
    }
}
