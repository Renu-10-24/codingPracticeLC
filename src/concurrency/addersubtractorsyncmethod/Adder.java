package concurrency.addersubtractorsyncmethod;

public class Adder implements Runnable {
    private final Count count;

    Adder(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i=0;i<1000000;i++) {
            count.addValue(i);
        }
    }
}


