package scaler.stack;

import java.util.Stack;
import java.util.stream.Collectors;

public class SimplifyDirectoryPath {
    public String simplifyPath(String A) {
        A=A.replaceAll("/+","/");
        A=A.replace("/$","");
        String[] folders = A.substring(1,A.length()).split("/");
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<folders.length;i++) {
            if (folders[i].equals("..")) {
                if(!stack.isEmpty()){
                    sb.append(stack.pop());
                }else{
                    break;
                }
            } else if (folders[i].equals(".")) {
                continue;
            } else {
                stack.push(folders[i]);
            }
        }
        if(stack.isEmpty()){
            return "/";
        }
        String result = stack.stream().map(s->"/"+s).collect(Collectors.joining(""));
        return result;
    }


    static void main() {
        SimplifyDirectoryPath s= new SimplifyDirectoryPath();
        String path = "/home/";
        String out = s.simplifyPath(path);
        System.out.println(out);
        path = "/a/./b/../../c/";
        out = s.simplifyPath(path);
        System.out.println(out);
        path = "/c";
        out=s.simplifyPath(path);
        System.out.println(out);
    }
}

