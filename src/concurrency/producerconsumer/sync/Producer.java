package concurrency.producerconsumer.sync;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private final Queue<Object> store;
    private int maxSize = 6;
    private final Semaphore prodSemaphore;
    private final Semaphore conSemaphore;
    private final String name;

    Producer(Queue<Object> store, int maxSize, Semaphore prodSemaphore, Semaphore conSemaphore, String name) {
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
                prodSemaphore.acquire();
                if (store.size() < maxSize) {
                    store.add(new Object());
                    System.out.println(name + " produced a new shirt. Store size is : " + store.size());
                    conSemaphore.release();
                }
            }
        } catch (InterruptedException ie) {
            ie.getMessage();
        }
    }
}
