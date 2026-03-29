package scaler.degree.compFunda;

public class ConcurrencyDemo implements Runnable{

    public static void main(String[] args){

//        Thread t = new Thread(this);
        new newthread();
//        t.start();

    }


    public void run(){

        System.out.println("test");

    }

}
class newthread extends Thread {

    newthread() {

        super("My Thread");

        start();

    }

    public void run() {

        System.out.println("I'm in the run method now "+this);

    }
}