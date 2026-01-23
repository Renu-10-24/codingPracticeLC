package concurrency;

public class Main {
    static void main() {
        System.out.println("this is printed by the main thread : "+Thread.currentThread().getName());
        HelloWorldPrinter printer = new HelloWorldPrinter();
        Thread t1 = new Thread(printer);
        t1.start();

    }
    }
