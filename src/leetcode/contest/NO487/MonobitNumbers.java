package contest.NO487;


public class MonobitNumbers {
    public int countMonobit(int n) {
        int  countMonobit = 0; //1 for 0
        int num = n;
        for (int t = 0; t <= num; t++) {
            if (checkMonobit(t)) {
                countMonobit++;
                 System.out.println("monobitcount till  " + t + "is : "+countMonobit);
            }
        }
        return countMonobit;
    }


    public boolean checkMonobit(int n) {
        int count=0;
        int highestSetBitIndex=-1;
//        total bits in a number is highestSetBitIndex+1
        System.out.println("For : "+n);
        for(int i=0;i<12;i++){ //1024 is 2^10 -->11 bits to represent highest number
             System.out.println("in---------"+i);
            if ((n & (1 << i)) == (1<<i)) {
                 System.out.println("condition true ");
                count++;
                 System.out.println(count);
                highestSetBitIndex=i;
            }
        }
         System.out.println("Returning : "+(count==0 || count==highestSetBitIndex));
        return count==0 || count==(highestSetBitIndex+1);
    }

    static void main() {
        MonobitNumbers m = new MonobitNumbers();
        int n=16;
        int result = m.countMonobit(16);
        System.out.println(result);
    }
}