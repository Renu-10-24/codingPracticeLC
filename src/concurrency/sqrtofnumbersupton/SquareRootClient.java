package concurrency.sqrtofnumbersupton;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareRootClient {
    private static final int n=1000;
    private static final ExecutorService executorService = Executors.newCachedThreadPool();;

    static void main() {
        SquareRootCalculator sqrtCalc = new SquareRootCalculator(n,executorService);
        Future<List<Double>> futureAnswer = executorService.submit(sqrtCalc);
        try {
            List<Double> answer = futureAnswer.get();
            for(int i=1;i<=n;i++) {
                System.out.println(i+" sqrt : "+answer.get(i-1));
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }

}
