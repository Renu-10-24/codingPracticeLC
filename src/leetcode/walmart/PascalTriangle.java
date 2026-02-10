package walmart;

import java.util.ArrayList;
import java.util.List;

class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>());
        list.get(0).add(1);
        for (int row = 1; row < numRows; row++) {
            List<Integer> prevRow = list.get(row - 1);
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            for (int col = 1; col < prevRow.size(); col++) {
                int a = prevRow.get(col - 1) + prevRow.get(col);
                currRow.add(a);
            }
            currRow.add(1);
            list.add(currRow);
        }
        return list;
    }

    static void main() {
        PascalTriangle p = new PascalTriangle();
        List<List<Integer>> list = p.generate(5);
        for(List<Integer> l : list){
            for(int i : l){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}