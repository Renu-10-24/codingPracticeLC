package concurrency.sqrtofnumbersupton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class SquareRootCalculator implements Callable<List<Double>> {
    private int n;
    private ExecutorService executorService;
    SquareRootCalculator(int n, ExecutorService executorService){
        this.n = n;
        this.executorService = executorService;
    }

    public List<Double> call(){
        List<Double> answer = new ArrayList<>();
        for(int i=1;i<=n;i++){
            double sqrt = sqrt(i);
            answer.add(sqrt);
        }
        return answer;
    }
    public  double sqrt(int n){
        double sqrt = Math.sqrt(n);
        return sqrt;
    }
}
