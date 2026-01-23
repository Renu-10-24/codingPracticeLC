package concurrency.addersubtractorsynchronized;

public class Adder implements Runnable{
    private final Count count;
    Adder(Count count){
        this.count = count;
    }
    @Override
    public void run() {
        for(int i=1;i<=1000000;i++){
            synchronized (count) {
                //synchronized(another object ){ can be used on multiple objects as needed.
                count.value += i;
//            }
            }
        }
    }
}
