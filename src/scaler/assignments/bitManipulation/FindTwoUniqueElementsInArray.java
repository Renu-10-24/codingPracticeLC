package scaler.assignments.bitManipulation;

public class FindTwoUniqueElementsInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {186, 256, 102, 377, 186, 377};
		arr = new int[] {2308, 1447, 1918, 1391, 2308, 216, 1391, 410, 1021, 537, 1825, 1021, 1729, 669, 216, 1825, 537, 1995, 805, 410, 805, 602, 1918, 1447, 90, 1995, 90, 1540, 1161, 1540, 2160, 1235, 1161, 602, 880, 2160, 1235, 669 };
		arr = new int[] {408, 478, 74, 624, 74, 204, 705, 624, 337, 408, 478, 204};
		Sol s = new Sol();
		int [] result=s.solve(arr);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
}
class Sol {
    public int[] solve(int[] A) {
        int xor_position=0,xor_1=0,xor_0=0,xor_all=A[0];
		for(int i=1;i<A.length;i++) {
			xor_all=xor_all^A[i];
		}
// 		System.out.println(xor_all);
		while(xor_all>0) {
			if((xor_all&1)==1) {
				break;
			}
			xor_all=xor_all>>1;
			xor_position++;
		}
// 		System.out.println(xor_position);
		for(int i=0;i<A.length;i++) {
			if( ((A[i]>>xor_position)&1) == 1) {
				xor_1=xor_1^A[i];
			}else {
				xor_0=xor_0^A[i];
			}
		}
// 		System.out.println(xor_0);
// 		System.out.println(xor_1);
        xor_1=xor_1^0;
        xor_0=xor_0^0;
        if(xor_0<xor_1){
            return new int[]{xor_0,xor_1};
        }else {
        	return new int[]{xor_1,xor_0};
        }

	}
}

