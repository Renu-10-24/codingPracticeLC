package scaler.assignments;

public class NoOfSetBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		S1 s = new S1();
		System.out.println(s.numSetBits(35));
		System.out.println("11 : 0 "+s.checkBit(11,0));
		System.out.println("11 : 0 "+s.checkBitWithLeftShift(11,0));
	}

}

class S1 {
	public int numSetBits(int A) {
		int x = 0;
		while (A > 0) {
			if ((A & 1) == 1) {
				x++;
			}
			A = A >> 1;
			System.out.println(A);
		}
		return x;
	}

	public boolean checkBit(int A, int bitPosition) {
		A = A >> bitPosition;
		if ((A & 1) == 1) {
			return true;
		} else {
			return false;
		}
	}
	public boolean checkBitWithLeftShift(int A, int bitPosition) {
		A = A << (30-bitPosition);
		if ((A & 1) == 1) {
			return true;
		} else {
			return false;
		}
	}
}