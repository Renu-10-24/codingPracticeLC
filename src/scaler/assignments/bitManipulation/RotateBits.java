package scaler.assignments.bitManipulation;

public class RotateBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sn s = new Sn();
		long a = 0;
//		System.out.println("1 left shift 31 times..."+(a<<31));
		System.out.println(s.reverse(a));
	}

}
class Sn {
	public long reverse(long a) {
		long lastBit = 0;
		long sum = 0;
		for(int i=0;i<32;i++) {
        	lastBit= a&1;
        	if(lastBit==1) {
        		lastBit =lastBit<<(32-i-1);
        		sum +=lastBit;
//        		System.out.println("rotate once");
//        		System.out.println("sum is "+sum);
        	}
        	a=a>>1;
//        	System.out.println(sum);
        }
        return sum;
	}
}
