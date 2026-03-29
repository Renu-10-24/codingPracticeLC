package scaler.degree.compFunda;

import java.util.concurrent.*;

public class RunnableExample implements Runnable {

    @Override
    public void run(){

        try {
            Thread.sleep(4000);
            System.out.println("In thread : "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        try (ExecutorService es = Executors.newFixedThreadPool(2000000)) {
            for (int i = 0; i < 10000000; i++) {
                es.submit(new RunnableExample());
            }

            es.shutdown();
        }

    }

}
