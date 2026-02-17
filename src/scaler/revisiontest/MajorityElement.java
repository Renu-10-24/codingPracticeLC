package scaler.revisiontest;

import java.util.*;

public class MajorityElement {
    //Boyer moore voting algorithm for majority element
    public static int majorityElement(int[] nums) {
        // Your solution logic will go here
        int count =0;
        int majorityEl = nums[0];
        for(int i : nums){
            if(count == 0){
                majorityEl = i;
            } else{
                count += i==majorityEl ? 1 : -1;
            }
        }
        // Return the majority element
        return majorityEl;
    }
    public static void main(String args[]){
        MajorityElement m = new MajorityElement();
        int [] nums = new int[]{1,2,2,3,2,2,2,2,2};
        System.out.println(m.majorityElement(nums));
    }
}