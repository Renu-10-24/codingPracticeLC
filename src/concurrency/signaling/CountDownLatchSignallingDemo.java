package concurrency.signaling;

import java.util.concurrent.CountDownLatch;

// Signaling is like wait for something to start or end, for a usecase where we start on a signal and send a signal to start their process, start one task only
// after another is done -
// Classic producer consumer situation of LinkedBlockingQueue with a bounded capacity- consumer waits till atleast one product is produced and producer waits till
// atleast one product is consumed when the queue is full
public class CountDownLatchSignallingDemo {
    static void main() throws InterruptedException {
        int N = 10;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch endSignal = new CountDownLatch(N);
        for (int i = 0; i < N; i++) {

            System.out.println("Sent the startSignal for Task to start");
            new Thread(new Wrker(startSignal, endSignal)).start();
            System.out.println("Task "+i+" completed and got the endSignal");
        }
        doSomethingElse();
        startSignal.countDown();
        endSignal.await();

        System.out.println("All tasks done !");
    }
    private static void doSomethingElse() {
    }
}
class Wrker implements Runnable{
    private final CountDownLatch startSignal;
    private final CountDownLatch endSignal;
    Wrker(CountDownLatch startSignal, CountDownLatch endSignal){
        this.startSignal = startSignal;
        this.endSignal = endSignal;
    }
    @Override
    public void run() {
        try {
            System.out.println("Waiting to start.. ");
            startSignal.await();
            System.out.println("Sent startSignal.. ");
            doWork();
            System.out.println("Sent endSignal.. ");
            endSignal.countDown();
        }catch(InterruptedException ie){
//            Thread.currentThread().interrupt();
        }
    }
    public void doWork(){
        try {
            System.out.println("In doWork.. ");
            Thread.sleep(10);
            System.out.println("Work done ...");
        }catch(InterruptedException e){
            e.getCause();
        }
    }
}
