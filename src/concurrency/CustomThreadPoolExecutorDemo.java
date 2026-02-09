package concurrency;

import java.util.concurrent.*;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
public class CustomThreadPoolExecutorDemo {
    public static ThreadPoolExecutor createExecutor() {

        //with custom ThreadPoolExecutor that implements the interface ExecutorService and we can customize all parameters in the
        //constructor here
        int cores = Runtime.getRuntime().availableProcessors();

        return new ThreadPoolExecutor(
                cores,                      // Core threads: Always kept alive
                cores * 2,                  // Max threads: Limit to avoid CPU thrashing
                60L, TimeUnit.SECONDS,      // Keep-alive: Kill idle threads after 1 min
                new ArrayBlockingQueue<>(500), // Bounded Queue: Prevent memory bloat
                new ThreadPoolExecutor.CallerRunsPolicy() // BACKPRESSURE
        );
    }

    static void main() {

        //executor execute example code --- no return value with execute - faster as it has no overhead of queue and all other parameter tracking,
        //perfect for fire and forget tasks

        try (ThreadPoolExecutor threadPoolExecutor = createExecutor()) {
            threadPoolExecutor.execute(() -> {
                System.out.println("in the run method");
                try {
                    Thread.sleep(1344);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            System.out.println("NO Return From the executor.execute with Runnable task");
        }

        //executor submit example code ---perfect for

        try (ThreadPoolExecutor threadPoolExecutor = createExecutor()) {
            Future<String> stringFuture = threadPoolExecutor.submit(() -> {
                System.out.println("in the run method");
                Thread.sleep(1344);
                return "successfully returning from task";
            });
            String result = stringFuture.get();
            System.out.println(result +"Future object Return From the executor.submit with Runnable task");
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        ThreadPoolExecutor threadPoolExecutor = createExecutor();
            Future<String> stringFuture = threadPoolExecutor.submit(() -> {
                System.out.println("in the run method");
                Thread.sleep(1344);
                return "successfully returning from task";
            });
        String result = null;
        try {
            result = stringFuture.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result +"Future object Return From the executor.submit with Runnable task");
        }
    }



 class NamedThreadFactory implements ThreadFactory {
    private final String baseName;
    private final AtomicInteger threadNum = new AtomicInteger(1);

    public NamedThreadFactory(String baseName) {
        this.baseName = baseName;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, baseName + "-" + threadNum.getAndIncrement());
        t.setDaemon(false); // Set to true if you want background threads
        return t;
    }
}
class AnalyticsThreadPool {
    public static ThreadPoolExecutor createExecutor() {
        return new ThreadPoolExecutor(
                2, 4, 10L, TimeUnit.MINUTES,
                new LinkedBlockingQueue<>(1000),
                (runnable, executor) -> {
                    // Custom RejectedExecutionHandler
                    System.err.println("Task rejected! Analytics queue full. Dropping log...");
                }
        );
    }
}