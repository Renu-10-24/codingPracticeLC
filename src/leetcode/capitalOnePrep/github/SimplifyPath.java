package capitalOnePrep.github;

import java.util.Stack;
import java.util.StringTokenizer;

    public class SimplifyPath {
        public String simplifyPath(String path) {
            Stack<String> stack = new Stack<>();

            path = path.replaceAll("/+", "/");

            StringTokenizer stringTokenizer = new StringTokenizer(path, "/");

            while (stringTokenizer.hasMoreTokens()) {
                String token = stringTokenizer.nextToken();
                // System.out.println("token  : "+token);
                if (token.equals("..")) {
                    if (!stack.isEmpty()) {
                        String val = stack.pop();
                    }
                } else if (token.equals(".")) {
                    //continue;
                } else{
                    stack.push(token);
                }
            }
            // System.out.println(stack);
            // System.out.println(String.join("/", stack));
            return "/" + String.join("/", stack);
        }



    public boolean isValidDirectory(String token) {
        char[] chars = token.toCharArray();
        if(token.matches("^\\.{3,}$")){
            return true;
        }
        for (char ch : chars) {
            if (!Character.isAlphabetic(ch)) {
                return false;
            }
        }
        return true;
    }

    static void test(){
        String test = "a///b//c";
        String regex = "^\\.{3,}$";
        boolean b = test.matches(regex);
        System.out.println("test : " + test+" matches : "+b);

        test = "..";
        b = test.matches(regex);
        System.out.println("test : " + test+" matches : "+b);

        test = "..a.";
        b =test.matches(regex);
        System.out.println("test : " + test+" matches : "+b);

        test = "....";
        b = test.matches(regex);
        System.out.println("test : " + test+" matches : "+b);

        test = "...";
        b= test.matches(regex);

        System.out.println("test : " + test+" matches : "+b);
//          test = test.replaceAll("/+", "/");
//        System.out.println("test " + test);
    }

    static void main() {
        SimplifyPath s = new SimplifyPath();
//        test();
        String path = "/////..../home/.../user//Documents///..////Pictures";

        String answr = s.simplifyPath(path);
        System.out.println(answr);
    }
}