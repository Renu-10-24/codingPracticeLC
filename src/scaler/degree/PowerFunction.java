package scaler.degree;

public class PowerFunction {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int power(final int A, final int B) {
        int result =1, halfPower=1;
        if(B==0){
            return 1;
        }
        if(B==1){
            return A;
        }
        if(B==2){
            return A*A;
        }
        halfPower = power(A,B/2);
        System.out.println(halfPower);
        result = halfPower*halfPower;
        if(B%2==0){
            return result;
        }else{
            return result*A;
        }
    }

    static void main() {
        PowerFunction pf = new PowerFunction();
        int a = 2,b=5;
        int result =pf.power(a,b);
        System.out.println(result);
    }
}