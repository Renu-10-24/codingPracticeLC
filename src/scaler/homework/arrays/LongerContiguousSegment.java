package scaler.homework.arrays;

public class LongerContiguousSegment {
    public static void main(String args[]){
        S s = new S();
        boolean x =false;
//        x =s.checkZeroOnes("111000");
        System.out.println("111000 : "+x);
//        x =s.checkZeroOnes("011000111");
        System.out.println("011000111 : "+x);
        x =s.checkZeroOnes("0111010011");
        System.out.println("0111010011 : "+x);
    }
}
class S {
    public boolean checkZeroOnes(String s) {
        int count1s=0,maxCount1s=0,count0s=0,maxCount0s=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='0'){
                count0s++;
                if(count1s > maxCount1s){
                    maxCount1s = count1s;
                }
                count1s=0;
            }else{
                count1s++;
                if(count0s > maxCount0s){
                    maxCount0s = count0s;
                }
                count0s=0;
            }
        }
        if(count0s > maxCount0s){
            maxCount0s = count0s;
        }
        if(count1s > maxCount1s){
            maxCount1s = count1s;
        }
        if(maxCount1s>maxCount0s){
            return true;
        }else{
            return false;
        }
    }
}