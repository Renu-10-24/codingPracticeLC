package leetcode.contest;

import java.util.ArrayList;
import java.util.List;

public class MaxSplitPositiveEvenIntegers {

	public static void main(String[] args) {
		S3 s = new S3();
		long finalSum = 12L;
		List<Long> outList = s.maximumEvenSplit(finalSum);
		for(long i : outList) {
			System.out.println(i);
		}
	}

}
class S3 {
    public List<Long> maximumEvenSplit(long finalSum) {
        long x =2L;
        long sum = 0L;
        
        List<Long> output = new ArrayList<Long>();
        while(sum<finalSum){
            output.add(x);
            sum +=x;
            x= x+2;
        }
        if(sum!=finalSum){
            output = new ArrayList<Long>();
        }
        return output;
    }
}