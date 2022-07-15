package Recursion;

public class APowerN {
    public static void main(String args[]){
        int a=11;
        int n=4;
        APowerN aPowN= new APowerN();
        int x =aPowN.recursivePower(a,n);
        System.out.println(x);
        a= 11;
        n=5;
        x =aPowN.recursivePower(a,n);
        System.out.println(x);
        a=0;
        n=0;
        x =aPowN.recursivePower(a,n);
        System.out.println(x);
        a= -1;
        n= 1;
        int m=20;
        x= aPowN.pow(a,n,m);
        System.out.println(x);
        a= 71045970;
        n= 10;
        m=64735492;
        x= aPowN.powLong(a,n,m);
        System.out.println(x);
        a= 71045970;
        n= 11;
        m=64735492;
        x= aPowN.powLong(a,n,m);
        System.out.println(x);
    }
    public int recursivePower(int a, int n){
        int x=1;
        if(n==0){
            return 1;
        }
        if(n==1){
            return a;
        }
        x = recursivePower(a,n/2);
        if((n&1)==1){
            return x*x*a;
        }else{
            return x*x;
        }
    }

        public int powLong(int A, int B, int C) {
            //calculating (A^B) mod C
            if(B==0){
                return 1%C;
            }
            if(B==1){
                if(A<0){
                    return C+(A%C);
                }
                return A%C;
            }
            int x = powLong(A,B/2,C);
            int y =(int)(((long)x*x)%C);
            if((B&1)==0){
                return y;
            }else{
                if(A<0){
                    return (int)((long)y*(C+((long)A%C)))%C;
                }
                long z = ((long)y*(A%C));
                z = z%C;
                return (int)z;
            }
        }

    public int pow(int A, int B, int C) {
        //calculating (A^B) mod C
        if(B==0){
            return 1%C;
        }
        if(B==1){
            if(A<0){
                return C+(A%C);
            }
            return A%C;
        }
        int x = pow(A,B/2,C);
        int y = (x*x)%C;
        if((B&1)==0){
            return y;
        }else{
            if(A<0){
                return (y*(C+(A%C)))%C;
            }
            return (y*(A%C))%C;
        }
    }
}
