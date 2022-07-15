package leetcode.strings;

import java.util.HashSet;
import java.util.Set;

public class MaxSubstringLengthWithNoRepChars {

	public static void main(String[] args) {
		Solution s = new Solution();
		int x =0;
//		x = s.lengthOfLongestSubstring("abcbbcadea");
//		System.out.println("abcbbcadea : expected : 5");
//		System.out.println("abcbbcadea :  "+x);
//		
//		x = s.lengthOfLongestSubstring(" ");
//		System.out.println("\\\" \" : expected : 1");
//		System.out.println(" : "+x);
//		
//		x = s.lengthOfLongestSubstring("  ");
//		System.out.println("\\\"  \" : expected : 1");
//		System.out.println("   : "+x);
//		
//		x = s.lengthOfLongestSubstring("au");
//		System.out.println("au : expected : 2");
//		System.out.println("au : " + x);
//		
//		x = s.lengthOfLongestSubstring("dvdf");
//		System.out.println("dvdf : expected : 3");
//		System.out.println("dvdf : " + x);
//		
//		x = s.lengthOfLongestSubstring("davcbudfs");
//		System.out.println("davcbudfs : expected : 8");
//		System.out.println("davcbudfs : " + x);
//		
//		x = s.lengthOfLongestSubstring("davcbudfssxyzghtixjklmno");
//		System.out.println("davcbudfssxyzghtixjklmno : expected : 13");
//		System.out.println("davcbudfs : " + x);
//		
//		x = s.lengthOfLongestSubstring("abcabcbb");
//		System.out.println("abcabcbb : expected : 3");
//		System.out.println("abcabcbb : " + x);
		
		x= s.maxSubstringWithUniqueChars_SW("");
		System.out.println("\\\"\" : expected : 0");
		System.out.println(" : "+x);
		
		x= s.maxSubstringWithUniqueChars_SW(" ");
		System.out.println("\\\" \" : expected : 1");
		System.out.println(" : "+x);
		
		x= s.maxSubstringWithUniqueChars_SW("a");
		System.out.println("a : expected : 1");
		System.out.println("a : "+x);
		
		x= s.maxSubstringWithUniqueChars_SW("aaaaa");
		System.out.println("aaaaa : expected : 1");
		System.out.println("aaaaa : "+x);
		
		x = s.maxSubstringWithUniqueChars_SW("davcbudfssxyzghtixjklmno");
		System.out.println("davcbudfssxyzghtixjklmno : expected : 15");
		System.out.println("davcbudfssxyzghtixjklmno : " + x);
		
		//lmndavcbudfsxya
		x = s.maxSubstringWithUniqueChars_SW("lmndavcbudfsxyaghij");
		System.out.println("lmndavcbudfsxyaghij : expected : 14");
		System.out.println("lmndavcbudfsxyaghij : " + x);
		
//		//abcbbcadea
//		x = s.maxSubstringWithUniqueChars_SW("abcbbcadea");
//		System.out.println("abcbbcadea : expected : 5");
//		System.out.println("abcbbcadea : " + x);
//		
//		x = s.maxSubstringWithUniqueChars_SW("au");
//		System.out.println("au : expected : 2");
//		System.out.println("au : " + x);
//		
//		x = s.maxSubstringWithUniqueChars_SW("dvdf");
//		System.out.println("dvdf : expected : 3");
//		System.out.println("dvdf : " + x);
//		
//		x = s.maxSubstringWithUniqueChars_SW("abcabcbb");
//		System.out.println("abcabcbb : expected : 3");
//		System.out.println("abcabcbb : " + x);
	}

}

class Solution {
	public int lengthOfLongestSubstring(String s) {
		int maxSubstringLength = 0;
		int count = 0;

		if (s.length() == 1) {
			return s.length();
		}

		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (!set.add(s.charAt(i))) {
				if (count > maxSubstringLength) {
					maxSubstringLength = count;
				}

				String subString = s.substring(0, i);
				int lastIndexOfRepeatingChar = subString.lastIndexOf(s.charAt(i));
				set.clear();
				for(int t = lastIndexOfRepeatingChar+1;t<=i;t++) {
					set.add(s.charAt(t));
				}
				count = i - lastIndexOfRepeatingChar;
			} else {
				count++;
			}
		}
		
		if (count > maxSubstringLength) {
			maxSubstringLength = count;
		}
		
		return maxSubstringLength;
	}
	
	//sliding window technique
	public int maxSubstringWithUniqueChars_SW(String s) {
		Set<Character> set = new HashSet<Character>();
		
		//the sliding window points to the substring with unique characters
		
		//maxLength is initialized to min possible length 0 from the constraints mentioned 
		//0 <= s.length <= 5 * 10^4
		int startIndex =0, endIndex = 0, currLength, maxLength =0;
		for (int i = startIndex; i < s.length(); i++) {
			if (!set.add(s.charAt(i))) {
				String subString = s.substring(0, i);
				int lastIndexOfRepeatingChar = subString.lastIndexOf(s.charAt(i));
				//lmndavcbudfsxya
				if(lastIndexOfRepeatingChar == startIndex) {
					startIndex =i;
					endIndex=i;
					continue;
				}
				for(int t = startIndex;t<lastIndexOfRepeatingChar;t++) {
					set.remove(s.charAt(t));
				}
				
				startIndex=lastIndexOfRepeatingChar+1;
				endIndex=i;
			} else {
				set.add(s.charAt(i));
				endIndex=i;
				currLength = endIndex - startIndex +1;
				if(currLength>maxLength) {
					maxLength = currLength;
				}
			}
			
		}
		
		return maxLength;
	}
}