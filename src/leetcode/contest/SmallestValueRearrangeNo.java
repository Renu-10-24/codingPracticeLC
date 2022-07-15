package leetcode.contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallestValueRearrangeNo {
    public static void main(String args[]) {
        Sol8 s = new Sol8();
        long num = 310;
        num = 2170596702L;
        long out = s.smallestNumber(num);
        System.out.println("output : "+out);
    }
}
class Sol8 {
    public long smallestNumber(long num) {
        List<Integer> list = new ArrayList<Integer>();
        boolean isNeg =false;
        if(num==0){
            return num;
        }
        if(num<0){
            num = -num;
            isNeg=true;
        }
        while(num>0){
            int digit = (int)(num%10);
            num /= 10;
            list.add(digit);
        }
        if(isNeg){
            Collections.sort(list,Collections.reverseOrder());
        }else{
            Collections.sort(list);
            int x=0;
            while(list.get(x)==0){
                x++;
            }
            //swap the elements at 0 and x;
            if(x>0){
                int t = list.get(x);
                list.set(0,t);
                list.set(x,0);
            }
        }
        long output = 0L;
        for(int i=0;i<list.size();i++){
            output = 10*output +list.get(i);
        }
        if(isNeg){
            output *= -1;
        }
        return output;
    }
}
