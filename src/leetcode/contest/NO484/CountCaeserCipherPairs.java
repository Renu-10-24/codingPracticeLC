package contest.NO484;
/*3805. Count Caesar Cipher Pairs
Medium
premium lock icon
        Companies
Hint
You are given an array words of n strings. Each string has length m and contains only lowercase English letters.

Two strings s and t are similar if we can apply the following operation any number of times (possibly zero times) so that s and t become equal.

Choose either s or t.
Replace every letter in the chosen string with the next letter in the alphabet cyclically. The next letter after 'z' is 'a'.
Count the number of pairs of indices (i, j) such that:

i < j
words[i] and words[j] are similar.
Return an integer denoting the number of such pairs.*/

import java.util.HashMap;
import java.util.Map;

public class CountCaeserCipherPairs {
    public long countPairs_bruteforce(String[] words) {
        int count =0;
        //here string is the pattern of the word in array, see how its processed, and integer is the count of that pattern => we found a similar pattern
        //word in the array

        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                //normalize each word and compare if equal
            }
        } //O(n*n) complexity = doesnt work, we have to use a map to store pattern and get counts directly - which gives O(n+com(normalizing each word to get pattern)) complexity

        return 0;
    }
    public long countPairs_Optimized(String[] words){
        Map<String,Integer> map = new HashMap<>();
        long count = 0;
        for(String s : words){
            char[] c = s.toCharArray();
            int t = c[0]; //t is 0-25 for a-z
            for(int k=0;k<c.length;k++){
                int y= (c[k] - t +26);
                c[k]=(char)(y%26);
            }
            String pattern = new String(c);
            System.out.println("pattern : "+pattern);
            int x = map.getOrDefault(pattern,0);
            count += x;
            map.put(pattern,++x);//first time - pattern would have 0 as count
        }
        return count;
    }

    static void main() {
        CountCaeserCipherPairs c = new CountCaeserCipherPairs();
        String[] words = new String[]{"ab","aa","za","aa"};
        long x=c.countPairs_Optimized(words);
        System.out.println("no. of similar words : "+x);
        x= c.countPairs_lcsolution(words);
        System.out.println(x);
    }

    public long countPairs_lcsolution(String[] words) {
        String[] a = words;
        Map<String, Integer> b = new HashMap<>();
        long c = 0;
        for (String d : a) {
            char[] e = d.toCharArray();
            int f = e[0];
            for (int g = 0; g < e.length; g++) {
                e[g] = (char) ((e[g] - f + 26) % 26);
            }
            String h = new String(e);
            System.out.println("pattern : "+e);
            int i = b.getOrDefault(h, 0);
            c += i;
            b.put(h, i + 1);
        }
        return c;
    }
}
