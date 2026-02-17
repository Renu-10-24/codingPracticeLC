package contest.NO488;

import java.util.ArrayList;
import java.util.List;

class MergeAdjacentEqualElements {
    public List<Long> mergeAdjacent(int[] nums) {

        List<Long> out = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            out.add((long)nums[i]);

            while(out.size()>=2){
                int last = out.size()-1;
                int secondLast = last-1;
                long lastEl = out.get(last);
                long seclastEl = out.get(secondLast);
                if(lastEl == seclastEl){
                    out.remove(last);
                    out.remove(secondLast);
                    out.add(lastEl+seclastEl);
                }else{
                    break;
                }
            }
        }
        return out;
    }

    static void main() {
        MergeAdjacentEqualElements m = new MergeAdjacentEqualElements();
        int[] nums = new int[]{3,1,1,2};
        List<Long> output = m.mergeAdjacent(nums);
        System.out.println();
        for(long l : output){
            System.out.print(l+" ");
        }
        nums = new int[]{2,2,4};
        output = m.mergeAdjacent(nums);
        System.out.println();
        for(long l : output){
            System.out.print(l+" ");
        }
        nums = new int[]{3,7,5};
        output = m.mergeAdjacent(nums);
        System.out.println();
        for(long l : output){
            System.out.print(l+" ");
        }
        nums = new int[]{2,1,1,2};
        output = m.mergeAdjacent(nums);
        System.out.println();
        for(long l : output){
            System.out.print(l+" ");
        }
    }
}