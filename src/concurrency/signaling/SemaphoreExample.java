package concurrency.signaling;

import java.util.concurrent.Semaphore;

//leetcode - not runnable - just for practice , makes no sense to have a main. will try to simulate with Semaphore
public class SemaphoreExample {
    private static final int n=10;
    private static final Semaphore foo = new Semaphore(1);
    private static final Semaphore bar = new Semaphore(0);

    static void main() {
        new Thread(()->{
            for (int i = 0; i < n; i++) {
                try {
                    foo.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                doWork1();
                bar.release();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < n; i++) {
                try {
                    bar.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                doWork2();
                foo.release();
            }
        }).start();
    }
    private static void doWork1(){
        System.out.println("Foo");
    }
    private static void doWork2(){
        System.out.println("Bar");
    }
}

/*
// Print FooBar Alternately -- Doing some work alternately
class FooBar {
    private int n;
    private Semaphore foo = new Semaphore(1);
    private Semaphore bar = new Semaphore(0);
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release();
        }
    }

}


 */