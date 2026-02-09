package concurrency;

public class Main {
    static void main() {
        System.out.println("this is printed by the main thread : "+Thread.currentThread().getName());
        HelloWorldPrinter printer = new HelloWorldPrinter();
//        Thread t1 = new Thread(printer);
        Thread t1 = new Thread(() -> {
            System.out.println("Hello world !"+Thread.currentThread().getName());
        });
        t1.start();

    }
    }
