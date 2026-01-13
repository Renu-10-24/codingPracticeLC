package capitalOnePrep;

class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int startProduct = 1;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                prefix[i] = startProduct;
            }else{
                prefix[i] = prefix[i-1]*nums[i-1];
            }
        }
        //replace nums with suffix products
        int[] suffix = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            if(i==(nums.length-1)){
                suffix[i] = startProduct ;
            }else{
                suffix[i] = suffix[i+1]*nums[i+1];
            }
        }
        int[] output = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            output[i] = prefix[i]*suffix[i];
        }
        return output;
    }

    static void main() {
        ProductExceptSelf p = new ProductExceptSelf();
        int[] nums = new int[]{1,2,3,4};
        int[] output = p.productExceptSelf(nums);
        for(int i : output){
            System.out.println(i);
        }
        nums = new int[]{-1,1,0,-3,3};
        output = p.productExceptSelf(nums);
        for(int i : output){
            System.out.println(i);
        }
    }
}