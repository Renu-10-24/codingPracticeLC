package capitalOnePrep;

class BinarySearchPeakElement {
    public int findPeakElement(int[] nums) {
        int n= nums.length;
        int lo= 0;
        int hi = n-1;
        //array size 1
        if(n==1){
            return 0;
        }
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            //boundary conditions
            if(mid==0 && nums[mid]>nums[mid+1]){
                return 0;
            }
            if(mid==(n-1) && nums[mid]>nums[mid-1]){
                return n-1;
            }
            if((mid-1 >=0) && (mid -1) <n)
                if(nums[mid]> nums[mid-1]){
                    if((mid+1) >=0 && (mid+1)<n){
                        if(nums[mid]>nums[mid+1]){
                            return mid;
                        }else{
                            lo = mid+1;
                        }
                    }
                }else{
                    hi = mid-1;
                }
        }
        return -1;
    }

    static void main() {
        BinarySearchPeakElement b = new BinarySearchPeakElement();
        int nums[] = new int[]{2,1};
        //gets peak element index in the array
        int answer = b.findPeakElement(nums);
        System.out.println(answer);
    }
}