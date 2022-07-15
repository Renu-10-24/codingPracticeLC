package leetcode.contest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class DigArtifacts {
	public static void main(String[] args) {
		Sol34 s = new Sol34();
		int n = 2;
		int[][] artifacts = new int[][] { { 0, 0, 0, 0 }, { 0, 1, 1, 1 } };
		int[][] dig = new int[][] { { 0, 0 }, { 0, 1 }, { 1, 1 } };
		int t = s.digArtifacts(n, artifacts, dig);
		System.out.println("total : " + t);
	}
}

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		return x == other.x && y == other.y;
	}
	
}

class Sol34 {
	    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
	        Set<Pair> allPairs = new HashSet<Pair>();
	        int ans = 0;
	        boolean isDug = true;
	        Set<Pair> pairs = null;
	        for(int t=0;t<dig.length;t++){
	            allPairs.add(new Pair(dig[t][0],dig[t][1]));
	        }
	        
	        for(int i=0;i<artifacts.length;i++){
	            isDug = false;
	            pairs = new HashSet<Pair>();
	                for(int t=artifacts[i][0];t<=artifacts[i][2];t++){
	                    for(int s=artifacts[i][1];s<=artifacts[i][3];s++){
	                        Pair p = new Pair(t,s);
	                        pairs.add(p);
	                    }
	                }
	            	if(allPairs.containsAll(pairs)) {
	            		isDug= true;
	            	}
	            if(isDug){
	                ans++;
	            }
	        }
	            return ans;
	        }
	    }
