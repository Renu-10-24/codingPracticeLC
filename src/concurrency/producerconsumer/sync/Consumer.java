package concurrency.producerconsumer.sync;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Queue<Object> store;
    private int maxSize=6;
    private Semaphore prodSemaphore;
    private Semaphore conSemaphore;
    private String name;
    Consumer(Queue<Object> store, int maxSize, Semaphore prodSemaphore, Semaphore conSemaphore, String name){
        this.store = store;
        this.maxSize = maxSize;
        this.prodSemaphore = prodSemaphore;
        this.conSemaphore = conSemaphore;
        this.name =name;
    }
    @Override
    public void run() {
        while(true){
                //conSemaphore.acquire();
            synchronized (store) {
                if (store.size() > 0) {
                    store.remove();
                    System.out.println(name + " is consuming a new shirt. Updated Store size is : " + store.size());
                }
                //prodSemaphore.release();
            }

        }
    }
}
