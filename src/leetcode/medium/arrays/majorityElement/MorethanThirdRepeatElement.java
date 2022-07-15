package leetcode.medium.arrays.majorityElement;

import java.util.ArrayList;
import java.util.List;

public class MorethanThirdRepeatElement {
    public static void main(String args[]) {
//        String s = "aba";
//        s.replace('a','c');
//        System.out.println(s);
        List<Integer> a = null;
        a = new ArrayList<>();
        int x=0;
//        1 2 3 1 1
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(1);
        a.add(1);
        Solution s = new Solution();
//        int x = s.repeatedNumber(a);
//        System.out.println(x);
//        a = new ArrayList<>();
////        1 2 3 1 1
//        a.add(4);
//        a.add(5);
//        a.add(3);
//        a.add(2);
//        a.add(5);
//        a.add(2);
//        a.add(4);
//        a.add(2);
//        x= s.repeatedNumber(a);
//        System.out.println(x);
        a = new ArrayList<>();
//        1 2 3 1 1
//        a.add(4);
//        a.add(5);
//        a.add(3);
//        a.add(2);
//        a.add(5);
//        a.add(5);
//        a.add(2);
//        a.add(2);
//        x= s.repeatedNumber(a);
//        System.out.println(x);

//      1000441, 1000441, 1000994
//        a = new ArrayList<>();
//        a.add(1000441);
//        a.add(1000441);
//        a.add(1000994);
//
//        x= s.repeatedNumber(a);
//        System.out.println("3 eles "+x);

        a = new ArrayList<>();
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(5);
        a.add(7);

        x= s.repeatedNumber(a);
        System.out.println("7 eles "+x);
    }
}
class Solution {
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {
        //using Moore's algo
        int countMajEl0 = 0, countMajEl1 = 0;

        Integer[] majEls = new Integer[2];
        int[] majElFreqs = new int[2];
        for (int i = 0; i < a.size(); i++) {
//            System.out.println("a[i]     : " +a.get(i));
//            System.out.println("majEle1  : "+majEls[1]);
            if (majEls[0] !=null && a.get(i).intValue() != majEls[0] && majEls[1] !=null && a.get(i).intValue() != majEls[1]) {
                  majElFreqs[0]--;
                  majElFreqs[1]--;

                  if (majElFreqs[0] == 0) {
                      majEls[0] = null;
                  }
                  if (majElFreqs[1] == 0) {
                      majEls[1] = null;
                  }
                }else if (majEls[0] == null && majEls[1] != null && a.get(i).intValue() != majEls[1].intValue()) {
                majEls[0] = a.get(i);
                majElFreqs[0]++;
            } else if (majEls[1] == null && majEls[0] != null && a.get(i).intValue() != majEls[0].intValue()) {
                majEls[1] = a.get(i);
                majElFreqs[1]++;
            } else if (majEls[0] != null && a.get(i).intValue() == majEls[0].intValue()) {
                majElFreqs[0]++;
            } else if (majEls[1] != null && a.get(i).intValue() == majEls[1].intValue()) {
                majElFreqs[1]++;
            } else {
                majEls[0] = a.get(i);
                majElFreqs[0]++;
            }
        }

        for (int i = 0; i < a.size(); i++) {
            if (majEls[0]!=null && majEls[0].intValue()== a.get(i).intValue()) {
                countMajEl0++;
            }

            if (majEls[1]!=null && majEls[1].intValue()== a.get(i).intValue()) {
                countMajEl1++;
            }
        }
        if (countMajEl0 > a.size() / 3) {
            return majEls[0];
        } else if (countMajEl1 > a.size() / 3) {
            return majEls[1];
        }
        return -1;
    }
}
