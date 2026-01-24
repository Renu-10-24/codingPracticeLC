package concurrency.addersubtractorsyncmethod;

public class Main {
    static void main() throws InterruptedException {
        Count count = new Count(10);
        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);
        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);
        System.out.println("before calling threads : "+count.getValue());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("after calling threads : "+count.getValue());
    }
}
