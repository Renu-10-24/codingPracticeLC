package concurrency.concurrency1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Callable;

public class NumberPrinter implements  Callable<Integer> {
    private int number;
    public NumberPrinter(int number){
        this.number = number;
    }
//    @Override
//    public  void run() {
//        try {
//            System.out.println(number + " " + Thread.currentThread().getName());
//            Thread.sleep(100000);
//        }catch(InterruptedException ie){
//            throw new RuntimeException(ie);
////            ie.printStackTrace();
////            ie.getMessage();
//        }
//    }

//sample showing we can have a return type and throw exception from call
    @Override
    public  Integer call() throws IOException {
        try {
            System.out.println(number + " " + Thread.currentThread().getName());
            File file = new File("C:/text.txt");
            file.setWritable(true);
            PrintWriter p = new PrintWriter(file);
            p.write("Helo world);");
            Thread.sleep(100000);
        }catch(InterruptedException ie){
            throw new RuntimeException(ie);
//            ie.printStackTrace();
//            ie.getMessage();
        }catch(IOException ioe){
            ioe.getMessage();
        }
        return 0;
    }

}
