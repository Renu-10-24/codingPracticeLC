package walmart;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class ArrayDequeDemo {
    static void main() {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(10);
        dq.add(20);
        dq.addFirst(15);
        dq.addLast(30);
        System.out.println(dq.peekFirst());
        CompletableFuture future = (CompletableFuture) Executors.newSingleThreadExecutor().submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hiljljljf");
            }
        });

//        future.thenAccept()
    }
}



