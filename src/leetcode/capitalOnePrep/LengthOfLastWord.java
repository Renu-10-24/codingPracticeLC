package capitalOnePrep;

class LengthOfLastWord {
    public int lengthOfLastWord1(String s) {
        //builtin
        s = s.trim();
        return s.length()-(s.lastIndexOf(" ")+1);
    }
    public int lengthOfLastWord(String s) {
        //builtin
        int length=0;
        for(int i=s.length()-1;i>=0;i--){
            if(!(s.charAt(i)==' ')){
                length++;
            }else {
                if(length>0){
                    break;
                }

            }

        }
        return length;
    }

    static void main() {
        LengthOfLastWord l = new LengthOfLastWord();
        String s = "Hello World!   ";
        l.lengthOfLastWord(s);
    }
}
