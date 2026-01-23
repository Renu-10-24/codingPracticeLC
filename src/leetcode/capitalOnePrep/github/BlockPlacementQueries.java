package capitalOnePrep.github;

import java.util.*;
import java.util.stream.Collectors;

class BlockPlacementQueries {
    public List<Boolean> getResults(int[][] queries) {
        Set<Integer> obstacles = new HashSet<>();
        List<Boolean> results = new ArrayList<>();

        for(int i=0;i<queries.length;i++){
            if(queries[i][0]==1){
                obstacles.add(queries[i][1]);
            }else if(queries[i][0]==2){
                boolean itCanFit =checkIfBlockCanFit(Set.copyOf(obstacles.stream().toList()),queries[i]);
                results.add(itCanFit);
            }
        }

        return results;
    }

    public boolean checkIfBlockCanFit(Set<Integer> obstacles, int[] blockQuery){
        int blockSize = blockQuery[2];
        int blockLimit = blockQuery[1];
        Set<Integer> newset= new HashSet<>();
        newset.addAll(obstacles);
        newset.add(blockLimit);
        List<Integer> list = newset.stream().filter(i->(i<=blockLimit)).collect(Collectors.toList());
        System.out.println(list);
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
        List<Integer> out = new ArrayList<>();
        if(!list.isEmpty())
            out.add(list.get(list.size()-1));
        for(int i=0;i<list.size()-1;i++){
            out.add(Math.abs(list.get(i+1)-list.get(i)));
        }
        newset.remove(blockLimit);
        for(int i : out){
            if(i>=blockSize){

                return true;
            }
        }
        return false;
    }

    static void main() {
        BlockPlacementQueries b = new BlockPlacementQueries();
//        int[][] queries = new int[][]{{1,2},{2,3,3},{2,3,1},{2,2,2}};
//        List<Boolean> output=b.getResults(queries);
//        System.out.println("output 1: ");
//        for(boolean bo : output){
//            System.out.print(bo+" , ");
//        }
//        queries = new int[][]{{1,7},{2,7,6},{1,2},{2,7,5},{2,7,6}};
//        output=b.getResults(queries);
//        System.out.println("output 2: ");
//        for(boolean bo : output){
//            System.out.print(bo+" , ");
//        }
        //[2,4,3],[2,6,5]
//        int[][] queries =  new int[][]{{2,4,3},{2,6,5}};
        int[][] queries =  new int[][]{{2,3,6},{2,5,4}};
        List<Boolean> output=b.getResults(queries);
        System.out.println("output 3: ");
        for(boolean bo : output){
            System.out.print(bo+" , ");
        }
    }
}