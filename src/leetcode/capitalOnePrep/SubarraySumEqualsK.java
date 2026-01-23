package capitalOnePrep;

public class SubarraySumEqualsK {
    public int[] solve(int[] A, int B) {
        int[] output;
        int left=0,right=0;
        int sum =0;

        for(;left<A.length && right<A.length && left <=right;){
            //array has no neg integers, no need to reset the sum to 0
            sum += A[right];
            if(sum==B){
                break;
            }else if(sum <B){

                right++;
            }else if(sum>B){
                sum = sum -A[left];
                left++;
            }
        }

        if(sum==B){
            //add subarray elements to output
            System.out.println("right and left : "+right + " "+left);
            output = new int[right-left];

            for(int i=left;i<right;i++){
                output[i-left] = A[i];
                // System.out.println("i-left : "+(i-left));
            }
            return output;
        }
        output= new int[]{-1};
        return output;
    }

    static void main() {
        SubarraySumEqualsK s = new SubarraySumEqualsK();
        int[] nums = new int[]{44,28,42,7,32,16,40,8,7,5};//len-21
        int B = 76;

        int[] out = s.solve(nums,B);
        for(int i: out){
            System.out.println(i);
        }
        nums = new int[]{1,2,3,4,5};
        B=5;
        out = s.solve(nums,B);
        for(int i: out){
            System.out.println(i);
        }
        nums=new int[]{1,1000000000};
        B=1000000000;
        out = s.solve(nums,B);
        for(int i: out){
            System.out.println(i);
        }

        nums = new int[]{23,50,44,6,39,15,44,27,47,29,30,44,28,42,7,32,16,40,8,7,5,48,48,16,9,5,50,16,18,9,21,26,48,37,27,7,5,29,24,28,10,44,21,1,48,15,31,41,42,23,4,32,40,40,27,20,29,42,25,18,37,43,13,30,42,24,17,42,14,42,43,36,31,29,24,24,8,3,12,34,14,6};
        //expected 24 28 10, target 62
        B=62;
        out = s.solve(nums,B);
        for(int i: out){
            System.out.println(i);
        }
    }
}

