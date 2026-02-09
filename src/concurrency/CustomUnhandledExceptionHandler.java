package concurrency;

import java.util.concurrent.*;

public class CustomUnhandledExceptionHandler {

    public static void main(String[] args) {
        //set thread name and UncaughtExceptionHandler in the ThreadFactory
        ThreadFactory tf = r -> {
            Thread t = new Thread(r);
            t.setName("exec-worker");
            t.setUncaughtExceptionHandler((thread, ex) -> {
                System.out.println(
                        "Uncaught exception in " + thread.getName() +
                                ": " + ex.getMessage()
                );
            });
            return t;
        };
// pass that ThreadFactory in the executor
        ExecutorService executor = new ThreadPoolExecutor(
                1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                tf
        );

        executor.execute(() -> {
            System.out.println("Running in " + Thread.currentThread().getName());
            throw new RuntimeException("boom from execute()");
        });
        //alternatively we can also do executor.submit() that returns the future object

        executor.shutdown();
    }
}
