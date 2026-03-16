package interviewPrep.american;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJumps {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        int last = stones[n - 1];
        if (stones[1] != 1) {
            return false;
        }
        Set<Integer> stonesSet = new HashSet<>();
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for (int i : stones) {
            stonesSet.add(i);
            dp.put(i, new HashSet<>());
        }
        dp.get(0).add(0); // seeding of the 0th position to get the dp going
        for (int pos : stones) {
            for (int k : dp.get(pos)) {
                int[] nextStones = new int[]{k - 1, k, k + 1};
                for (int nextK : nextStones) {
                    if (nextK <= 0) {
                        continue;
                    }
                    int nextPos = pos + nextK;
                    if (nextPos == last) {
                        return true;
                    }
                    if (stonesSet.contains(nextPos)) {
                        dp.get(nextPos).add(nextK);
                    }
                }
            }
        }
        return false;
    }

    static void main() {
        FrogJumps frogJumps = new FrogJumps();
        int[] stones = new int[]{0, 1, 3, 5, 6, 8, 12, 17};
        boolean canCross = frogJumps.canCross(stones);
        System.out.println("The frog can cross : ? " + canCross);
    }
}
