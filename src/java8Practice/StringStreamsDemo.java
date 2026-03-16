public class StringStreamsDemo {
    public int specialCharsCount(String s){
        int count =0;
        char[] cArr = s.toCharArray();
        for(char c : cArr){
            if(!Character.isAlphabetic(c)){
                count++;
            }
        }
        return count;
    }
    public long getSpclCharsCount(String s){
        long count =s.chars().map(i->(char)i).filter(c->!Character.isAlphabetic(c)).count();
        return count;
    }

    static void main() {
        StringStreamsDemo strDemo = new StringStreamsDemo();
        String s = "Ja@#V&a!";
        long ans=strDemo.getSpclCharsCount(s);
        System.out.println(ans);
        int ansint = strDemo.specialCharsCount(s);
        System.out.println(ansint);

    }
}
