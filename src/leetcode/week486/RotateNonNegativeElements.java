package week486;


import java.util.ArrayList;
import java.util.List;

public class RotateNonNegativeElements {
    public int[] rotateElements(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        List<Integer> list = new ArrayList<>();
        if(n==1){
            return nums;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                list.add(nums[i]);
            }
        }

        for(int i=0,j=list.size()-1;i<list.size() && i<j;i++,j--){
            int temp = list.get(i);
            list.set(i,list.get(j));
            list.set(j,temp);
        }

        if(list.size()==0){
            return nums;
        }
        k=k%list.size();
        int t=list.size()-k-1;
        for(int i=0,j=t;i<j;i++,j--){
            int temp = list.get(i);
            list.set(i,list.get(j));
            list.set(j,temp);
        }
        for(int i=t+1,j=list.size()-1;i<j;i++,j--){
            int temp = list.get(i);
            list.set(i,list.get(j));
            list.set(j,temp);
        }
        // for(int i : list){
        //     System.out.println(i);
        // }
        int x=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                nums[i]=list.get(x++);
            }
            // System.out.println(nums[i]);
        }
        return nums;
    }

    static void main() {
        RotateNonNegativeElements r = new RotateNonNegativeElements();
        int[] nums = new int[]{-20,-13,0,24};
        int k = 76135;
        int[] output =r.rotateElements(nums,k);
        for(int i:output){
            System.out.println(i);
        }
    }
}