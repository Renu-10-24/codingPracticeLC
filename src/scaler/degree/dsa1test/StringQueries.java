package scaler.degree.dsa1test;

public class StringQueries {
    static void main() {
        StringQueries sq = new StringQueries();
        String A = "developer";
        int[][] B = {{0,3},{1,6}};
        String[] result = sq.solve(A, B);
        for(String s : result){
            System.out.println(s);
        }
    }
    public String[] solve(String A, int[][] B){
        int t=0;
        String[] result = new String[B.length];
        String v = "Vowel";
        String c = "Consonant";
        int [] out = calc(A);
        for(int x=0;x<B.length;x++){
            if(B[x][0] !=0){
                t = out[B[x][1]] - out[B[x][0] - 1];
            }else{
                t = out[B[x][1]];
            }
            if(t >=0){
                result[x] = v;
            }else{
                result[x] = c;
            }
        }
        return result;
    }
    public int[] calc(String A){
        int n = A.length();
        int[] out = new int[n];
        int count = 0;
        for(int i=0;i<n;i++){
            char c = A.charAt(i);
            if(isVowel(c)){
                count ++;
            }else{
                count --;
            }
            out[i]= count;
        }
        return out;
    }

    public boolean isVowel(char c){
        switch(c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
}
