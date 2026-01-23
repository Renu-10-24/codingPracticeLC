package capitalOnePrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        for(int[] a : intervals){
            System.out.println("["+a[0]+ "," +a[1]+"]");
        }
        System.out.println("Sorted .......... ");
        //sort intervals
        Arrays.sort(intervals, (a,b)->{
            if(Integer.compare(a[0],b[0])==0){
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[0],b[0]);
        });

        for(int[] a : intervals){
            System.out.println("["+a[0]+ "," +a[1]+"]");
        }
        List<int[]> mergedIntervals = new ArrayList<>();
        for (int[] interval : intervals) {
            if (mergedIntervals.isEmpty() || mergedIntervals.getLast()[1] < interval[0]) {//if merged is empty or last one is non overlapping
                // with interval, add interval to list
                mergedIntervals.add(interval);
            } else if (mergedIntervals.getLast()[1] >= interval[0]) {
                mergedIntervals.getLast()[1] = Math.max(mergedIntervals.getLast()[1], interval[1]);
            }
        }
        return mergedIntervals.toArray(new int[][]{});
    }

    public int[][] merge_leetcode_solution(int[][] intervals) {
        for(int[] a : intervals){
            System.out.println("["+a[0]+ "," +a[1]+"]");
        }
        System.out.println("Sorted .......... ");
        //sort intervals
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0])); // sort based on only the start of intervals

        for(int[] a : intervals){
            System.out.println("["+a[0]+ "," +a[1]+"]");
        }
        List<int[]> mergedIntervals = new ArrayList<>();
        for (int[] interval : intervals) {
            if (mergedIntervals.isEmpty() || mergedIntervals.getLast()[1] < interval[0]) {//if merged is empty or last one is non overlapping
                // with interval, add interval to list
                mergedIntervals.add(interval);
            } else if (mergedIntervals.getLast()[1] >= interval[0]) {
                mergedIntervals.getLast()[1] = Math.max(mergedIntervals.getLast()[1], interval[1]);
            }
        }
        return mergedIntervals.toArray(new int[][]{});
    }

    static void main() {
        MergeIntervals m = new MergeIntervals();
        int[][] intervals = new int[][]{{1,5},{1,3},{2,6},{15,18},{8,10},};
        int[][] output = m.merge(intervals);
        for(int[] interval : output){
            System.out.println("{"+interval[0] +","+interval[1]+"}");
        }
        System.out.println("LEETCODE SOLUTION");
        intervals = new int[][]{{1,4},{4,8},{4,7}};
        output=m.merge_leetcode_solution(intervals);
        for(int[] interval : output){
            System.out.println("{"+interval[0] +","+interval[1]+"}");
        }
        intervals = new int[][]{{1,5},{1,3},{2,6},{15,18},{8,10},};
        output = m.merge_leetcode_solution(intervals);
        for(int[] interval : output){
            System.out.println("{"+interval[0] +","+interval[1]+"}");
        }

    }
}
