package interviewPrep;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StringDemo {
    String s = "567835";

    static void main() {
        String s = "567835";
        ExecutorService service = Executors.newCachedThreadPool();
        StringThreadPool pool = new StringThreadPool(s,service);
        Future<String> stringFuture = service.submit(pool);
        try {
            String name = Thread.currentThread().getName();
            String stringoutput = stringFuture.get();
            System.out.println("thread name : "+name +" " +stringoutput);

            service.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
