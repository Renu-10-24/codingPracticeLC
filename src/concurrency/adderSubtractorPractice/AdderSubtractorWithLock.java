package concurrency.adderSubtractorPractice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AdderSubtractorWithLock {
    static void main() {
        Count count = new Count(10);
        Lock lock = new ReentrantLock();
        Adder adder = new Adder(count, lock);
        Subtractor subtractor = new Subtractor(count, lock);
        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            System.out.println(count.value);
            System.out.println(adder.count.value);
            System.out.println(subtractor.count.value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
