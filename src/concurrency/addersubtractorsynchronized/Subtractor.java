package concurrency.addersubtractorsynchronized;

public class Subtractor implements Runnable{
    private final Count count;
    Subtractor(Count count){
        this.count = count;
    }
    @Override
    public void run() {
        for(int i=1;i<=1000000;i++){
            synchronized (this) { //synchronized on a different object than that is being shared in the critical section - will NOT guarantee count value to be
                //as expected in synchronized manner
                count.value -= i;
            }
        }
    }
}
