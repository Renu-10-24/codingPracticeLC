package concurrency.producerconsumer.sync;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private Queue<Object> store;
    private int maxSize=6;
    private Semaphore prodSemaphore;
    private Semaphore conSemaphore;
    private String name;
    Producer(Queue<Object> store, int maxSize, Semaphore prodSemaphore, Semaphore conSemaphore, String name){
        this.store = store;
        this.maxSize = maxSize;
        this.prodSemaphore = prodSemaphore;
        this.conSemaphore = conSemaphore;
        this.name = name;
    }
    @Override
    public void run() {
        while(true){
//                prodSemaphore.acquire();
            //although using synchronized makes the shared object access consistent and atomic, the code has become sequential and lost the benefits
            // or essence of multithreading
            //so, synchronized block /lock is not solving the problem of producer consumer, as only one producer is producing at once and only one consume is able to consume at once
            synchronized (store) {
                if(store.size()<maxSize){
                store.add(new Object());
                System.out.println(name + " is produced a new shirt. Store size is : " + store.size());
                }
            }
            //            conSemaphore.release();
        }
    }
}
