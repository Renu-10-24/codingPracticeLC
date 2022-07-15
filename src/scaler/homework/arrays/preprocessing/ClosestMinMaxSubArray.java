package scaler.homework.arrays.preprocessing;

public class ClosestMinMaxSubArray {
    public  static  void main(String args[]){
        int [] A = new int[]{1,2,3,1,3,4,6,4,6,2,5,1,3};
//        A = new int[]{8,8,8,8,8,8,8};
        int minIndex=-1,maxIndex = -1, ans=A.length;
        int min=A[0], max=A[0];
        for(int i=0;i<A.length;i++){
            if(A[i]>max){
                max =A[i];
            }else{
                if(A[i]<min){
                    min=A[i];
                }
            }
        }
        if(min==max){
            System.out.println(1);
            return;
        }
        for(int i=0;i<A.length;i++){
            if(A[i]==min){
                minIndex = i;
                if(maxIndex != -1){
                    int x = minIndex - maxIndex +1;
                    if(x<ans){
                        ans =x;
                    }
                }
            }
            if(A[i]==max){
                maxIndex = i;
                if(minIndex != -1){
                    int x = maxIndex - minIndex +1;
                        if(x<ans){
                            ans =x;
                        }
                }
            }
        }
        System.out.println(ans);
    }
}
