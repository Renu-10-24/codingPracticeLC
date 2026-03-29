package scaler.degree.compFunda;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class TaskFix implements Runnable{

    @Override
    public void run() {
        CounterFix.increment();
    }

}

public class RaceConditionFixWithAtomicInteger {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i = 0; i < 1000; i++) {
            executorService.submit(new TaskFix());
        }

        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);

        System.out.println("Final count is : " + CounterFix.getCount());
    }
}

class CounterFix {
    static private AtomicInteger count = new AtomicInteger(0);

    public static void increment() {
        count.incrementAndGet();
    }

    public static int getCount() {
        return count.get();
    }
}