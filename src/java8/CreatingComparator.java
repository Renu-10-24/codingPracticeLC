package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class CreatingComparator {
    public static void main(String args[]){
        List<String> strings = Arrays.asList("Oneytrtfhs","One","Two","Three","Four","Five","Six","Seven","Eight","Nine");
        List<Integer> numbers= Arrays.asList(1,35,51,76,9);
        //writing a custom comparator that sorts by length of the string
        Comparator<String> cmp11 = (String s1, String s2) -> {
            int l1 = s1.length();
            int l2 = s2.length();
            if(l1<l2){
                return -1;
            }else if(l1==l2){
                return 0;
            }else{
                return 1;
            }
        };

        //calling sort method of list
        strings.sort(cmp11);
        System.out.println("Using custom comparator - Sort by length.. ");
        for(String s : strings){
            System.out.println(s);
        }

        numbers.sort(Comparator.naturalOrder());
        System.out.println("Using natural ordering comparator .. ");
        for(String s : strings){
            System.out.println(s);
        }
        System.out.println("Using natural ordering comparator .. ");
        //giving a custom comparator..
        Comparator<String> cmp = (String s1, String s2) -> {
            for(int i=0;i<Math.min(s1.length(),s2.length());i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if(c1 < c2) {
                    return -1;
                }else if(c1>c2){
                    return 1;
                }
            }
            if(s1.length()<s2.length()){
                return -1;
            }else if(s1.length() > s2.length()){
                return 1;
            }else{
                return 0;
            }
        };
        Collections.sort(strings,cmp);
        for(String s : strings){
            System.out.println(s);
        }
        //calling natural ordering comparator in custom comparator.. this syntax is not the best practice, it suggests to use the
        //naturalOrder() method, just like as below
        Comparator<String> cmp2 = (String s1, String s2) -> {
            return s1.compareTo(s2);
        };
        System.out.println("Using natural ordering comparator cmp2 .. ");
        strings.sort(cmp2);
        for(String s : strings){
            System.out.println(s);
        }
        //for natural order sorting..
        //giving a custom comparator..
        Comparator<String> cmp3 = String::compareTo;
        System.out.println("Using natural ordering comparator cpm3 .. ");
        strings.sort(cmp3);
        for(String s : strings){
            System.out.println(s);
        }
        //for natural order sorting..
        //giving a custom comparator..
        Comparator<String> cmp4 = Comparator.naturalOrder();
        strings.sort(cmp4);
        System.out.println("Using natural ordering comparator cmp4 .. ");
        for(String s : strings){
            System.out.println(s);
        }


        Function<String,Integer> function = s -> s.length(); //this one does boxing and unboxing under the hood

        Comparator<String> comparator = Comparator.comparing(function);
        System.out.println("sorting by length using the comparing method with a function that returns length.. ");
        strings.sort(comparator);
        for(String s : strings){
            System.out.println(s);
        }

        ToIntFunction<String> toIntFunction = s-> s.length();
        Comparator<String> comp4 = Comparator.comparingInt(toIntFunction);
        System.out.println("sorting by length using the comparing method with a function that returns length.. ");
        strings.sort(comp4);
        for(String s : strings){
            System.out.println(s);
        }

    }
}
