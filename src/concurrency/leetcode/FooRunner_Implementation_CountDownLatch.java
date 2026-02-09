package concurrency.leetcode;

//worst design of runner class , only for leetcode - not for practical real time

import java.util.concurrent.CountDownLatch;

class Foo1 {
    CountDownLatch latch1 = new CountDownLatch(1);
    CountDownLatch latch2 = new CountDownLatch(2);
    public Foo1() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        latch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        latch1.await();
        printSecond.run();
        latch2.countDown();
//      latch2.countDown(); Call as many times to make it zero so the waiting threads (those threads that call latch2.await()) are notified n they would start running
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        latch2.await();
        printThird.run();
    }

}

public class FooRunner_Implementation_CountDownLatch{
    static void main() {
        Foo1 foo1 = new Foo1();
        try {
            Runnable r1 = () -> {
                try {
                    foo1.first(() -> {

                        System.out.println("first");

                    });
                } catch (InterruptedException ie) {
                    ie.getMessage();
                }
            };
            Runnable r2 = () -> {
                try {
                    foo1.second(() -> {

                        System.out.println("second");

                    });
                } catch (InterruptedException ie) {
                    ie.getMessage();
                }
            };
            Runnable r3 = () -> {
                try {
                    foo1.third(() -> {

                        System.out.println("third");

                    });
                } catch (InterruptedException ie) {
                    ie.getMessage();
                }
            };

            Thread t1 = new Thread(r1);
            t1.start();
            Thread t2 = new Thread(r2);
            t2.start();
            Thread t3 = new Thread(r3);
            t3.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}