package concurrency.leetcode;

//worst design of runner class , only for leetcode - not for practical real time

class Foo {

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}

public class FooRunner_initial {
    static void main() {
        Foo foo = new Foo();
        try {
            Runnable r1 = () -> {
                try {
                    foo.first(() -> {
                        System.out.print("first");
                    });
                } catch (InterruptedException ie) {
                    ie.getMessage();
                }
            };
            Runnable r2 = () -> {
                try {
                    foo.second(() -> {
                        System.out.print("second");
                    });
                } catch (InterruptedException ie) {
                    ie.getMessage();
                }
            };
            Runnable r3 = () -> {
                try {
                    foo.third(() -> {
                        System.out.print("third");
                    });
                } catch (InterruptedException ie) {
                    ie.getMessage();
                }
            };
//without synchronization, gives random output - secondfirstthird or firstsecondthird or thirdfirstsecond
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