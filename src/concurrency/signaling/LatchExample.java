package concurrency.signaling;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class LatchExample {
    private static final int N = 5; // Number of worker threads

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);

        for (int i = 0; i < N; ++i) { // Create and start threads
            new Thread(new Worker(startSignal, doneSignal, i)).start();
        }

        System.out.println("Driver is doing some setup...");
        Thread.sleep(1000);            // Simulating setup work

        System.out.println("Driver releasing startSignal!");
        startSignal.countDown();      // Let all threads proceed

        System.out.println("Driver doing other work...");
        doneSignal.await(1000, TimeUnit.MILLISECONDS);           // Wait for all workers to finish
        System.out.println("All workers finished. Driver proceeding.");
    }
}

class Worker implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    private final int workerId;

    Worker(CountDownLatch startSignal, CountDownLatch doneSignal, int workerId) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
        this.workerId = workerId;
    }

    public void run() {
        try {
            startSignal.await();      // Wait for the driver to signal start
            doWork();
            doneSignal.countDown();   // Signal completion
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    void doWork() {
        System.out.println("Worker " + workerId + " is performing work...");
    }
}