package leetcode.medium.arrays;

public class ZigzagPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String str = "PAYPALISHIRING";
		System.out.println(s.convert(str, 5));
//    	str = "PAYPALISHIRING";
//		System.out.println(s.convert(str, 3));
		
	}
}

class Solution {
	public String convert(String s, int numRows) {
		int strLen = s.length();
		StringBuilder returnString = new StringBuilder();
		// no.of cols calculation
		int f = 0, numCols = 0;
		if (numRows == 1) {
			return s;
		}
		if (strLen < (2 * numRows - 2)) {
			numCols = strLen / numRows + strLen % numRows;
		} else {
			f = strLen / (2 * numRows - 2);
			numCols = f * numRows - f;
			int g = strLen % (2 * numRows - 2) ;
			if (g > (numRows-1)) {
				numCols+=g-numRows+1;
			}else if(g<=numRows-1) {
				numCols++;
			}
		}

		char[][] outputArray = new char[numRows][numCols];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				outputArray[i][j] = ' ';
			}
		}

		int i1 = 0, j1 = 0;
		for (int x = 0; x < s.length();x++) {
			s.charAt(x);
			if (x % (2 * numRows - 2) < numRows) {
				int var = 2 * numRows - 2;
				if (x % var == 0) {
					i1 = 0;
					j1 = x / 2;
				}
				outputArray[i1][j1] = s.charAt(x);
				if(i1<numRows-1) {
					i1++;
				}
			} else {
				if (j1 < (numCols - 1))
					j1++;
				int y = x % (numRows - 1);
				i1 = numRows - 1 - y;
				
				outputArray[i1][j1] = s.charAt(x);
				if(i1<numRows-1) {
					i1++;
				}
			}
		}

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				if (outputArray[i][j] != ' ') {
					returnString.append(outputArray[i][j]);
				}
			}
		}
		return returnString.toString();
	}
}