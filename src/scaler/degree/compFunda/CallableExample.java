package scaler.degree.compFunda;

import java.util.concurrent.*;

public class CallableExample implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {

        Thread.sleep(4000);
        return 10;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException{
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Integer> future = es.submit(new CallableExample());

        System.out.println(future.get());

        es.shutdown();

    }

}
