package scaler.assignments.bitManipulation;

//Given two integers A and B, find a number X such that A xor X 
//is minimum possible,
//and the number of set bits in X equals B.
public class KeepAXorXMin {

	public static void main(String[] args) {
		Sn1 s = new Sn1();
//		System.out.println(s.solve(15, 2));
//		System.out.println(s.solve(4, 6));
//		System.out.println(s.solve(9, 3));
		System.out.println(s.solve(14, 6));
	}
}

class Sn1 {
	public int solve(int A, int B) {
        long reqNo=0,x=0;
      
        for(int i=31;B>0&&i>=0;i--){
            if(((A>>i)&1)==1){
                x=1<<i;
                reqNo +=x;
                B--;
            }
        }
        System.out.println("reqNo : "+reqNo);
        System.out.println("B     : "+B);
        long output = reqNo;
        int counter=0;
        for(int i=0;i<=31&& counter<B;i++){
            if((reqNo & (1<<i))==0){
               output = output + (1<<i); 
               System.out.println("output : "+output);
               counter++;
            }
//            reqNo = (reqNo>>1); 
        }
        return (int)output;
    }
}
