package concurrency.adderSubtractorPractice;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{
    Count count;
    Lock lock;
    Adder(Count count, Lock lock){
        this.count = count;
        this.lock = lock;
    }

    public void addValue(int i){
        this.count.value += i;
    }

    @Override
    public void run() {
        lock.lock();
        addValue(5);
        lock.unlock();
    }
}
