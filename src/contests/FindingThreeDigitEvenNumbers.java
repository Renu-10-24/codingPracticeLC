package contests;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
public class FindingThreeDigitEvenNumbers {
    public static void main(String args[]) {
        Solution s = new Solution();
        int[] digits = new int[]{2, 1, 3, 0};
        int[] output = s.findEvenNumbers(digits);
        digits = new int[]{2,2,8,8,2};
        digits  = new int[]{3,7,5};
        digits = new int[]{0,2,0,0};
        digits = new int[]{0,0,0};
        output = s.findEvenNumbers(digits);
        for (int i : output) {
            System.out.println(i);
        }
    }
}
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Map<Integer,Integer> numMap = null;
        List<Integer> list  = new ArrayList<Integer>();
        for(int i=0;i<digits.length;i++){
            int val = map.getOrDefault(digits[i],0);
            map.put(digits[i],++val);
        }
        boolean isMatch = true;
        for(int num=100;num<=998;num++){
            int currNum = num;
            if(currNum%2==0){
                numMap = new HashMap<Integer,Integer>(map);
                while(currNum>0){
                    int digit = currNum%10;
                    int val= numMap.getOrDefault(digit,0);
                    if(val>0){
                        val--;
                        numMap.put(digit,val);
                    }else{
                        isMatch=false;
                        break;
                    }
                    currNum /=10;
                }
                if(isMatch){
                    list.add(num);
                }
            }
            isMatch=true;
        }
        int[] output = new int[list.size()];
        for (int i=0;i<output.length;i++) {
            output[i]=list.get(i);
        }
        return output;
    }
}