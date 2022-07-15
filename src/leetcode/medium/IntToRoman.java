package leetcode.medium;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class IntToRoman {

	public static void main(String[] args) {
		IntToRoman i = new IntToRoman();
		int num = 897; //expected :
		System.out.println(num + " " +i.intToRoman1(num));
		num=40;
		System.out.println(num + " " +i.intToRoman1(num));
		num=49;
		System.out.println(num + " " +i.intToRoman1(num));
		num=44;
		System.out.println(num + " " +i.intToRoman1(num));
		num=45;
		System.out.println(num + " " +i.intToRoman1(num));
		num=54;
		System.out.println(num + " " +i.intToRoman1(num));
		num=59;
		System.out.println(num + " " +i.intToRoman1(num));
		num=95;
		System.out.println(num + " " +i.intToRoman1(num));
		num=3999;
		System.out.println(num + " " +i.intToRoman1(num));
		num=4999;
		System.out.println(num + " " +i.intToRoman1(num));
		num = 950;
		System.out.println(num + " " +i.intToRoman1(num));
		num=900;
		System.out.println(num + " " +i.intToRoman1(num));
		num=3;
		Solution2 sol = new Solution2();
		System.out.println(num + "second method   " +sol.intToRoman(num));

	}

	public String intToRoman1(int num) {
		int key[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String val[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		String str = new String("");

		for(int i=0; num != 0; i++)
        {
            while(num >= key[i])
            {
                num -= key[i];
                str += val[i];
            }
        }
        
        return str;
	}
}
	
	class Solution2{
		 TreeMap<Integer, String> map = new TreeMap<>(Comparator.comparingInt(Integer::intValue)) {{
		        put(1, "I");
		        put(4, "IV");
		        put(5, "V");
		        put(9, "IX");
		        put(10, "X");
		        put(40, "XL");
		        put(50, "L");
		        put(90, "XC");
		        put(100, "C");
		        put(400, "CD");
		        put(500, "D");
		        put(900, "CM");
		        put(1000, "M");
		    }};

		    public String intToRoman(int num) {
		        return intToRoman(num, new StringBuilder());
		    }

		    String intToRoman(int num, StringBuilder sb) {
		        if (num <= 0) return sb.toString();
		        Map.Entry<Integer, String> entry = map.floorEntry(num);
		        sb.append(entry.getValue());
		        return intToRoman(num - entry.getKey(), sb); // using recursion
		    }
		
}

