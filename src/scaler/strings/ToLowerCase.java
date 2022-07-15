package scaler.strings;

import org.w3c.dom.ls.LSOutput;

public class ToLowerCase {
    public static void main(String args[]) {
        Sol s = new Sol();
//        char[] A = {'S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y'};
//        char[] charArray = s.to_lower(A);
//        for(char c : charArray){
//            System.out.print(c);
//        }
        char[] A = {'S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0'};
        char[] charArray = s.to_lower(A);
        for(char c : charArray){
            System.out.print(c);
        }
    }
}
class Sol {
    public char[] to_lower(char[] A) {
        for(int i=0;i<A.length;i++){
//            if(Character.isUpperCase(A[i])){
            if(A[i]>='A' && A[i]<='Z'){
                A[i]=Character.toLowerCase(A[i]);
            }
        }
        return A;
    }

    //if all chars are alphabet or numbers, return 1 else return 0
    public int solve1(char[] A) {
        for(int i=0;i<A.length;i++){
//            if(Character.isUpperCase(A[i])){
            if(!Character.isUpperCase(A[i]) && !Character.isLowerCase(A[i]) && !Character.isDigit(A[i]) ){
                return 0;
            }
        }
        return 1;
    }

    public int solve2(char[] A) {
        for(int i=0;i<A.length;i++){
            if(!Character.isUpperCase(A[i]) && !Character.isLowerCase(A[i]) ){
                return 0;
            }
        }
        return 1;
    }
}
