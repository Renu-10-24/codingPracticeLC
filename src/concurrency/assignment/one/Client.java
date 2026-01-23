package concurrency.assignment.one;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ArrayCreator a = new ArrayCreator(n);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<List<Integer>> futureList = executorService.submit(a);
        List<Integer> list = null;
        try {
            list = futureList.get();
            executorService.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(list.toString());
    }
}