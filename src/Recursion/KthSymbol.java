package Recursion;

public class KthSymbol {
    public static void main(String args[]){
        Sol3 s = new Sol3();
        int A = 5;
        int B = 4;
        int x = s.solve(A,B);
        System.out.println("5 4 : "+x);
        A = 2;
        B = 1;
        x = s.solve(A,B);
        System.out.println("2 1 : "+x);
        A = 2;
        B = 2;
        x = s.solve(A,B);
        System.out.println("2 2 : "+x);
    }
}
class Sol3 {
    public int solve(int A, int B) {
        String str=AthString("",A);
        return Integer.parseInt(str.charAt(B-1)+"");
    }
    public String AthString(String str, int A){
        while(A>=1){
            if(str=="") {
                str = "01";
            }
            if(A==1) {
               return str;
            }
            String str1 = str.replace("1","$");
            String str2 = str1.replace("0","01");
            String str3= str2.replace("$","10");
            return AthString(str3,--A);
        }
        return  "";
    }
}
