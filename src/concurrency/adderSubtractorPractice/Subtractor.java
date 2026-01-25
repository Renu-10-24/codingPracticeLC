package concurrency.adderSubtractorPractice;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable{
    Count count;
    Lock lock;
    Subtractor(Count count, Lock lock){
        this.count = count;
        this.lock = lock;
    }

    public void subtractValue(int i){
        this.count.value -= i;
    }

    @Override
    public void run() {
        lock.lock();
        subtractValue(5);
        lock.unlock();
    }
}
