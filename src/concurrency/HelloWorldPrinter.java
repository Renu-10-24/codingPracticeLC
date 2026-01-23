package concurrency;

public class HelloWorldPrinter implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello world !"+Thread.currentThread().getName());
        HelloWorldPrinter printer = new HelloWorldPrinter();
        Thread thread1 = new Thread(printer);
//        thread1.start();
    }
}
