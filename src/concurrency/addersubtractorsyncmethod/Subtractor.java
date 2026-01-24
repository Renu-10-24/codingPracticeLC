package concurrency.addersubtractorsyncmethod;

public class Subtractor implements Runnable{
    private final Count count;
    Subtractor(Count count){
        this.count = count;
    }
    @Override
    public void run() {
        for(int i=0;i<1000000;i++) {
            count.addValue(-i);
        }
    }
}
