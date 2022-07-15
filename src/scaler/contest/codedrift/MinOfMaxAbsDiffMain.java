package scaler.contest.codedrift;
/******************************************************************************

 Welcome to GDB Online.
 GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
 C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
 Code, Compile, Run and Debug online from anywhere in world.

 *******************************************************************************/
import java.util.Arrays;
import java.lang.Math;
public class MinOfMaxAbsDiffMain
{
    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] A = new int[]{1,4,10,30};
        int[] B = new int[]{2,15,20};
        int[] C = new int[]{10,12};
        Solution s = new Solution();
        int x = s.minimize(A,B,C);
        System.out.println(x);
    }
}
class Solution {
    static int reqd = Integer.MAX_VALUE;
    int currDiff=0;
    public int minimize(final int[] A, final int[] B, final int[] C) {
        int nearestB1=0,nearestB2=0,nearestC1=0,nearestC2=0;

        for(int i=0;i<A.length;i++){
            boolean isB1B2 = false,isC1C2 = false;
            int j = Arrays.binarySearch(B,0,B.length,A[i]);
            System.out.println("Target : "+A[i]+" to be found in B");
            System.out.println(j+" element to be inserted at index ..");
            if(j<0){
                if((-j-1)==B.length){
                    nearestB1= B.length-1;
                }else if(-j-2 <0){
                    nearestB1 = 0;
                }else{
                    isB1B2=true;
                    nearestB1 = -j-1;
                    nearestB2 = -j-2;
                }
            }
            if(j==B.length){
                nearestB1 = j-1;
            }
            if(j>0 && j<B.length){
                nearestB1=j;
            }

            int k = Arrays.binarySearch(C,0,C.length,A[i]);
            System.out.println("Target : "+A[i]+" to be found in C");
            System.out.println(k+" element to be inserted at index ..");
            if(k<0){
                if((-k-1)==C.length){
                    nearestC1= C.length-1;
                }else if(-k-2 <0){
                    nearestC1 = 0;
                }else{
                    isC1C2 =true;
                    nearestC1 = -j-1;
                    nearestC2 = -j-2;
                }
            }
            if(k==C.length){
                nearestC1 = j-1;
            }
            if(k>0 && k<C.length){
                nearestC1=k;
            }

            if(isB1B2 && isC1C2){
                getMinDiff(A[i],nearestB1,nearestC1);
                getMinDiff(A[i],nearestB2,nearestC1);
                getMinDiff(A[i],nearestB1,nearestC2);
                getMinDiff(A[i],nearestB2,nearestC2);
            }else if(isB1B2){
                getMinDiff(A[i],nearestB1,nearestC1);
                getMinDiff(A[i],nearestB2,nearestC1);
            }else if(isC1C2){
                getMinDiff(A[i],nearestB1,nearestC1);
                getMinDiff(A[i],nearestB1,nearestC2);
            }else{
                getMinDiff(A[i],nearestB1,nearestC1);
            }
        }
        return reqd;
    }

    public int getMinDiff(int x,int y,int z){
        int currDiff = Math.max(Math.max(x-y,y-z),z-x);
        if(currDiff<reqd){
            reqd=currDiff;
        }
        return reqd;
    }

}

