package scaler.stack;

import java.util.*;

public class RedundantBraces {
    public int braces(String A) {
            Stack<Character> stack = new Stack<>();
            boolean exprFlag = false;
            Map<Character, Character> map = new HashMap<>();
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');
            for (int i = 0; i < A.length(); i++) {
                char ch = A.charAt(i);
                if (map.containsKey(ch) || Arrays.asList('*', '-', '+', '/').contains(ch)) {
                    stack.push(ch);
                } else if (map.containsValue(ch)) {
                    if(!stack.isEmpty()) {
                        char a = stack.peek();
                        if(map.containsKey(a)){
                            return 1;
                        }else if(Arrays.asList('*', '-', '+', '/').contains(a)){
                            stack.pop();
                        }

                    }
                }
            }
            if(!stack.isEmpty()) {
                if(stack.contains(map.keySet())){
                    return 1;
                }

            }
        return 0; //stack has operator, its fine
        }
     static class SortColors {

        public void sortColors(int[] nums) {
            int p0=0, p1=0,p2=nums.length-1;
            while(p1 <=p2){
                if(nums[p1]==0){
                    int temp = nums[p0];
                    nums[p0++] = nums[p1];
                    nums[p1++] = temp;
                }else if(nums[p1]==2){
                    int temp = nums[p1];
                    nums[p1] = nums[p2];
                    nums[p2--] = temp;
                }else{
                    p1++;
                }
            }
            for(int i : nums){
                System.out.println("gds  "+i);
            }
        }
    }


    static void main() {
        RedundantBraces r = new RedundantBraces();
        String s = new String("((a+b))");
        System.out.println(r.braces(s));
        s = new String("(a+(a+b))");
        System.out.println(r.braces(s));
        s = "a/((a*((a+b)-c*(a/b))))";
        s= "(a)";
        s="(a+b)";
        System.out.println(r.braces(s));
        SortColors sc = new SortColors();
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sc.sortColors(nums);

    }
}