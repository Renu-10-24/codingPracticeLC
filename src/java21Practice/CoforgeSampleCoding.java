import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.mapping;

public class CoforgeSampleCoding {
    public static void main(String[] args) {
        CoforgeSampleCoding c = new CoforgeSampleCoding();
        String s1= "Java";
        String s2= "Software";
        //swap without third variable and loops
        c.swapWithoutThirdVariableOrLoops(s1,s2);
        //freq of chars using java8
        String s = "Javaa";
        c.getFreqChars(s);
        int[] A={10,15,20,25};
        int n=2;
        c.printAsGiven(A,n);
    }

    private void getFreqChars(String s) {
        Map<Character,Long> characterCountMap = s.chars().mapToObj(i->(char)(i)).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(characterCountMap);
    }

    private void printAsGiven(int [] A,int n){
       // Map<Integer,List<Integer>> map = IntStream.range((n-2)*2,n*2).map(i->A[i]).collect(Collectors.partitioningBy((Integer)i->(i/2>=0 &&(i/2<n))));
              //  forEach(System.out::println);
    }
    private void swapWithoutThirdVariableOrLoops(String s1, String s2){

        s1 = s2 +" "+s1;
//        StringTokenizer stknzr = new StringTokenizer();
//        stknzr.nextToken(" ")
        String[] strings = s1.split(" ");
        s1 = strings[0];
        s2 = strings[1];
        System.out.println("s1 : "+s1+ " s2 : "+s2);
    }//or use substring to swap the strings
}
