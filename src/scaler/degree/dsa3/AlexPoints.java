package scaler.degree.dsa3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AlexPoints {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[][] solve(final int[][] A, final int B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int dist = A[i][0] * A[i][0] + A[i][1] * A[i][1];
            map.put(i, dist);
        }

        Comparator<Map.Entry<Integer, Integer>> cmp = Comparator.comparing(e -> e.getValue());

        int[][] out = new int[B][2];
        int x=B;
        Set<Map.Entry<Integer,Integer>> sortedEntrySet = map.entrySet().stream().sorted(cmp.reversed()).limit(B).collect(Collectors.toSet());
        for (Map.Entry e : sortedEntrySet) {
            int key = (int) e.getKey();
            out[--x] = A[key];
        }
        return out;
    }

    static void main() {
        AlexPoints a = new AlexPoints();
        int[][] A = new int[][]{{1, 2}, {1, 4}, {-1, 0}};
        int B = 2;
        int[][] out = a.solve(A, B);
        for (int i = 0; i < out.length; i++) {
            System.out.println(out[i][0] + " " + out[i][1]);
        }
    }
}