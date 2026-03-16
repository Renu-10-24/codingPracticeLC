package scaler.degree.dsa1;

public class SumOfArray {
    public long solve(int[] A, int[] B) {
        int carry=0, ansDigit =0;
        long prevAnswer=0L,answer=0L;
        int a = A.length;
        int b = B.length;
        int countDigits=0;
        if(a>=b){
            for(int i=a-1,j=b-1;i>=0;i--,j--){
                if(j<0){
                    ansDigit = carry+A[i];
                }else{
                    ansDigit = carry+A[i]+B[j];
                }
                if(i>0) {
                    if (ansDigit > 9) {
                        carry = ansDigit / 10;
                        ansDigit = ansDigit % 10;
                    } else {
                        carry = 0;
                    }
                }
                countDigits++;

                answer = (int)Math.pow(10,countDigits-1)*ansDigit+prevAnswer;
                prevAnswer = answer;
            }
//            if(carry >0){
//                countDigits =0;
//                while(answer>0){
//                    answer /=10;
//                    countDigits++;
//                }
//                answer = ((int)Math.pow(10,(countDigits)))+prevAnswer;
//            }
            return answer;
        }else{
            return solve(B,A);
        }
    }

    static void main() {
        SumOfArray s = new SumOfArray();
        int[] A = new int[]{9,9,9,6,5};
        int[] B = new int[]{2,0,0,0,4};
        long ans=s.solve(A,B);
        System.out.println(ans);
        //this approach fails for last digit is a ten, ansdigit is 0, and carry is 1.
        A=  new int[]{9,6,8,0};
        B = new int[]{9,4,8};
        ans=s.solve(A,B);
        System.out.println(ans);
    }
}
