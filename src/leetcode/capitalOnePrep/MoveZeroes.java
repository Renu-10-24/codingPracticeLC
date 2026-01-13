package capitalOnePrep;

class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int read =0,write=0;
        for(;read<nums.length;read++){
            if(nums[read]!=0){
                nums[write]=nums[read];
                write++;
            }
        }
        for(int i=write;i<nums.length;i++){
            nums[i]=0;
        }
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }

    static void main() {
        MoveZeroes m = new MoveZeroes();
        int [] nums = new int[]{0,1,0,3,12};
        m.moveZeroes(nums);
    }
}