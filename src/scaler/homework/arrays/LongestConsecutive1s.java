package scaler.homework.arrays;

public class LongestConsecutive1s {
    public static void main(String args[]) {
        Sol1s s = new Sol1s();
        int x = s.solve("010100110101");
        System.out.println(x);
        x = s.solve("01");
        System.out.println(x);
        x = s.solve("11100");
        System.out.println(x);
        x = s.solve("110100");
        System.out.println("110100 : "+x);
    }
}

class Sol1s {
    public int solve(String A) {
        int noOfSetBits=0;
        int n = A.length();
        //get count of all 1's in the binary string
        for(int i=0;i<n;i++){
            if('1'==A.charAt(i)){
                noOfSetBits++;
            }
        }
        if(noOfSetBits == n || noOfSetBits == 1){
            return noOfSetBits;
        }
        int[] prefixArr = new int[n];
        int[] suffixArr = new int[n];
        prefixArr[0]=0;
        //counting prefix 1's
        for(int i=1;i<n;i++){
            if('1'==A.charAt(i-1)){
                prefixArr[i]=prefixArr[i-1]+1;
            }else if('0'==A.charAt(i-1)){
                prefixArr[i]=0;
            }
        }
        //counting suffix 1's
        suffixArr[n-1]=0;
        for(int i=n-2;i>=0;i--){
            if('1'==A.charAt(i+1)){
                suffixArr[i]=suffixArr[i+1]+1;
            }else if('0'==A.charAt(i+1)){
                suffixArr[i]=0;
            }
        }
        int ans=0,curr_count_1s=0;
        for(int i=0;i<n;i++){
            if('0'==A.charAt(i)){
                if(prefixArr[i]+suffixArr[i] == noOfSetBits){
                    return prefixArr[i]+suffixArr[i];
                }else {
                    curr_count_1s = prefixArr[i] + suffixArr[i] + 1;
                }
                if(curr_count_1s > ans){
                    ans=curr_count_1s;
                }
            }
        }
        return ans;
    }
}
