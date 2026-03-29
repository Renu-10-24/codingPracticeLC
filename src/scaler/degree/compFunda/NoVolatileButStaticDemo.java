package scaler.degree.compFunda;

class Check{
    volatile static boolean check=false;
}

class Task1 implements Runnable{

    public void run(){

        while(!Check.check) { // run indefinitely while check is false
        }

        System.out.println("Hello World!");

        while(Check.check) { // while check is true, run indefinitely
        }

        System.out.println("Good Bye!");


    }
}

public class NoVolatileButStaticDemo {

    public static void main(String[] args){
        Runnable runnable = new Task1();
        Thread thread = new Thread(runnable);

        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Say Hello..");
        Check.check = true;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Say Bye..");
        Check.check = false;

    }

}