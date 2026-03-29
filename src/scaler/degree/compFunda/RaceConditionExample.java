package scaler.degree.compFunda;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable{

    @Override
    public void run() {
        Counter.increment();
    }

}

public class RaceConditionExample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i = 0; i < 1000; i++) {
            executorService.submit(new Task());
        }

        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);
// final count is might be significantly lessthan 1000 as we did NOT synchronize the increment() call, so, there might be LOST Updates between threads resulting in a
        // final count less than 1000.
        System.out.println("Final count is : " + Counter.getCount());
    }
}

class Counter {
    static private int count = 0;

    public static void increment() {
        count = count + 1;
    }

    public static int getCount() {
        return count;
    }
}