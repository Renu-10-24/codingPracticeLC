package capitalOnePrep;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class ReverseWordsInString {
    public String reverseWords(String s) {
        s=s.trim();
        StringTokenizer st = new StringTokenizer(s, " ");
        StringBuffer sb = new StringBuffer();
        List<String> list = new ArrayList<>();
        while(st.hasMoreTokens()){
            list.add(st.nextToken());
        }
        for(int i=list.size()-1;i>=0;i--){
            sb.append(list.get(i)+" ");
        }
        sb=sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    static void main() {
        ReverseWordsInString r = new ReverseWordsInString();
        String ans=r.reverseWords("  the sky is blue  ");
        System.out.println(ans);
    }
}