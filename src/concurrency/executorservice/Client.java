package concurrency.executorservice;

import concurrency.concurrency1.NumberPrinter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
            for (int i = 0; i < 100; i++) {
                if (i == 5 || i == 15 || i == 50 || i == 99) {
                    System.out.println("DEBUG");
                }
                    NumberPrinter numberPrinter = new NumberPrinter(i);
                //submit the task to ExecutorService
                    service.submit(numberPrinter);

            }


        }

    }

