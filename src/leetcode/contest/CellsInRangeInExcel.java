package leetcode.contest;

import java.util.ArrayList;
import java.util.List;

public class CellsInRangeInExcel {

	public static void main(String[] args) {
		So5 s = new So5();
		String str = "K1:L2";
		str = "A1:F2";
		List<String> list = s.cellsInRange(str);
		for(String s1 : list) {
			System.out.println(s1);
		}
	}

}
class So5 {
    public List<String> cellsInRange(String s) {
        char c1 = s.charAt(0);
        char r1 = s.charAt(1);
        char c2 = s.charAt(3);
        char r2 = s.charAt(4);
        int x = c1-'A';
        int y = c2-'A';
        List<String> output = new ArrayList<String>();
        int x1=0;
        for(int i=x;i<=y;i++){
            for(int j=r1;j<=r2;j++){
                output.add(x1++,(char)(i+'A')+""+(char)j);
            }
        }
        return output;
    }
}