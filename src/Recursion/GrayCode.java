package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public static void main(String args[]){
        Sol31 s = new Sol31();
        int a =5;
        List<Integer> list = s.grayCode(a);
        for(int i : list){
            System.out.println(i);
        }
    }
}
class Sol31 {
    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> list = new ArrayList<>();
        List<String> strArr = grayCodeStringArr(a);
//        System.out.println("here.. printing as strings iterating over..str arr size.."+strArr.size());
        for(int i=0;i<strArr.size();i++) {
            String str = strArr.get(i);
            long b = Long.parseLong(str);
//            System.out.println(str);
        }
//        System.out.println("here. printing integers...iterating over str arr size ........."+strArr.size());
        for(int i=0;i<strArr.size();i++) {
            String str = strArr.get(i);
            long b = Long.parseLong(str);
//            System.out.println(b);
        }
        for(int i=0;i<strArr.size();i++){
            String str = strArr.get(i);
            long b = Long.parseLong(str);
            b = intToBinary(b);
            list.add((int)b);
        }
        return list;
    }

    public int intToBinary(long num){
        int binNum=0;
        for(int i=0;num > 0 && i<31;i++){
            if( (num &1)==1){
                binNum  += (1<<i);
            }
            num /= 10;
        }
        return binNum;
    }
    public List<String> grayCodeStringArr(int a){
        ArrayList<String> list = new ArrayList<>();
        List<String> currList = null;
        int prevLen = (int)Math.pow(2,(a-1));
        String str= "";
        if(a==1){
            currList= new ArrayList<>();
            currList.add("0");
            currList.add("1");
            return currList;
        }
        if(a>1){
            List<String> prevList =grayCodeStringArr(a-1);
            currList = new ArrayList<>(a);
            int i=0;
            for(;i<prevLen;i++){
                str = "0" + prevList.get(i);
                currList.add(str);
            }
            for(int j=prevLen-1;j>=0;j--){
                str = "1"+ prevList.get(j);
                currList.add(str);
            }
            return currList;
        }
       return null;
    }
}