package contest.NO175;

class ReverseString {
    public String reverseByType(String s) {
        int len = s.length();
        char[] c = s.toCharArray();
        for(int i=0,j=len-1;i<j;){
            while(isSplChar(c[i])){
                ++i;
            }
            while(isSplChar(c[j])){
                --j;
            }
            if(i<j) {
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
                i++;
                j--;
            }
        }
        for(int i=0,j=len-1;i<j;){
            while(!isSplChar(c[i])){
                ++i;
            }
            while(!isSplChar(c[j])){
                --j;
            }
            if(i<j) {
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
                i++;
                j--;
            }
        }
        System.out.println(c);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len;i++){
            sb.append(c[i]);
        }
        return sb.toString();
    }
    public boolean isSplChar(char c){
        if(!Character.isAlphabetic(c)){
            return true;
        }
        return false;
    }

    static void main() {
        ReverseString reverseString = new ReverseString();
        String s = ")ebc#da@f(";
        String out = reverseString.reverseByType(s);
        String out1 = "(fad@cb#e)";
        System.out.println("reversed : "+out);
        System.out.println("reversed : "+out.equals(out1));
    }
}