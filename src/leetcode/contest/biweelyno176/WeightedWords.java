package contest.biweelyno176;

public class WeightedWords {
    public String mapWordWeights(String[] words, int[] weights) {
        int count=0;
        StringBuilder output = new StringBuilder();
        for(int i=0;i<words.length;i++){
            String word = words[i];
            char[] carr = word.toCharArray();
            count =0;
            for(int t=0;t<word.length();t++){
                 count += weights[carr[t]-'a'];
                 count = count%26;
            }
            char c = (char)(122-count);
            output.append(c);
        }
        return output.toString();
    }

    static void main() {
        WeightedWords w = new WeightedWords();
        String[] words = new String[]{"abcd","def","xyz"};
        int[] weights = new int[]{5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2};
        System.out.println(w.mapWordWeights(words,weights));
        words = new String[]{"a","b","c"};
        weights = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(w.mapWordWeights(words,weights));
        words = new String[]{"abcd"};
        weights = new int[]{7,5,3,4,3,5,4,9,4,2,2,7,10,2,5,10,6,1,2,2,4,1,3,4,4,5};
        System.out.println(w.mapWordWeights(words,weights));
    }
}