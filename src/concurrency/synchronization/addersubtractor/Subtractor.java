package concurrency.synchronization.addersubtractor;

public class Subtractor implements Runnable{
    private final Count count;
    Subtractor(Count count){
        this.count = count;
    }
    @Override
    public void run() {
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        for(int i=1;i<=1000000;i++){
            count.value -=i;
            System.out.println("In subtractor : "+count.value);
        }

    }
}
