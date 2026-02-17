package contest.NO487;

/// binary search always single element arrays is the edge case, dont even forget, take it for granted, that needs handling, it could be any function
public class MinimizeKForGivenFunction_BS {
    static void main() {
        MinimizeKForGivenFunction_BS m = new MinimizeKForGivenFunction_BS();
        int[] nums = new int[]{3,7,5};
        int output = m.minimumK(nums);
        //to find ceil : ==== computationally faster
       // ceil(a/k) = (a+k-1)/k;
        System.out.println("sout : "+output);
        nums = new int[]{1};
        output = m.minimumK(nums);
        System.out.println("sout : "+output);
        nums = new int[]{9};
        output = m.minimumK(nums);
        System.out.println("sout : "+output);
        nums = new int[]{1,1};
        output = m.minimumK(nums);
        System.out.println("sout : "+output);
        nums = new int[]{100000};
        output = m.minimumK(nums);
        int ans=(100000+45)/46;
        System.out.println("sout : "+output);
        int exp = 46*46;
        System.out.println("sout : "+ans+" "+exp);
    }
    public int minimumK(int[] nums) {
        //search space is 1 to max(max(nums),len(nums))//lo and hi are bounds of k - 1 to max k

        int klo=1;
        int khi = 0;
        int sum=0;
        int ans=0; // min possible answer is 1
        for(int i=0;i<=nums.length-1;i++){
            sum +=  nums[i];
        }
        khi = Math.max(nums.length,sum);

        while(klo<khi){
            int kmid = klo + (khi-klo)/2;
            long func =compute(nums,kmid);
            if(func <= (long)kmid*kmid*1L){ // move left
//                ans = kmid; ----this assumption is so wrong, once mid is evaluated, we could move to right or left
//                and we cant know fr sure, if mid was the answer, close to answer but NOT the answer
                khi = kmid;
            }else{ //move right
                klo = kmid+1;
            }
        }
        return klo;
    }
    public long compute(int[] nums, int kmid){
        long sum =0;
        for(int i=0;i<nums.length;i++){
            int ceil = ((nums[i]%kmid)==0)?0:1;
            sum += nums[i]/kmid + ceil;
        }
        return sum;
    }
}
