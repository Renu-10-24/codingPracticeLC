package concurrency.producerconsumersemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private final Queue<Object> store;
    private int maxSize;
    private final Semaphore prodSemaphore;
    private final Semaphore conSemaphore;
    private final String name;

    Consumer(Queue<Object> store, int maxSize, Semaphore prodSemaphore, Semaphore conSemaphore, String name) {
        this.store = store;
        this.maxSize = maxSize;
        this.prodSemaphore = prodSemaphore;
        this.conSemaphore = conSemaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                conSemaphore.acquire();
                if (store.size() > 0) {
                    store.remove();
                }
                System.out.println(name + " is consuming a new shirt. Updated Store size is : " + store.size());
                prodSemaphore.release();
            }
        } catch (InterruptedException ie) {
            ie.getMessage();
        }
    }
}
