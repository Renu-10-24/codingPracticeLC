package walmart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class ArrayComparator implements Comparator<Integer[]>{
    @Override
    public int compare(Integer[] o1, Integer[] o2) {
        return (o1[0].compareTo(o2[0]));
    }
}
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt( (int[] o) -> o[0]).thenComparingInt((int[] o)->o[1])); // give type of parameter in lambda when compiler is not able to infer type
        List<int[]> output = new ArrayList<>();
        for (int[] interval : intervals) {
            if (output.isEmpty() || output.getLast()[1] < interval[0]) {
                output.add(interval);
            } else if (output.getLast()[1] >= interval[0]) {
                output.getLast()[1] = Math.max(interval[1], output.getLast()[1]);
            }
        }
        int[][] out = output.toArray(new int[output.size()][2]);
        return out;
    }

    static void main() {
        MergeIntervals m = new MergeIntervals();
        int[][] intervals = new int[][]{{1, 5}, {1, 3}, {2, 6}, {15, 18}, {8, 10},};
        int[][] output = m.merge(intervals);
        for (int[] interval : output) {
            System.out.println("{" + interval[0] + "," + interval[1] + "}");
        }
        System.out.println("LEETCODE SOLUTION");
        intervals = new int[][]{{1, 4}, {4, 8}, {4, 7}};
        output = m.merge(intervals);
        for (int[] interval : output) {
            System.out.println("{" + interval[0] + "," + interval[1] + "}");
        }
        intervals = new int[][]{{1, 5}, {1, 3}, {2, 6}, {15, 18}, {8, 10},};
        output = m.merge(intervals);
        for (int[] interval : output) {
            System.out.println("{" + interval[0] + "," + interval[1] + "}");
        }
   }
}