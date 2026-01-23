package concurrency.synchronizedKeyword;

public class SynchronizedKeyword implements Runnable{
    Count count = new Count(10);
    public SynchronizedKeyword(Count count){
        this.count = count;
    }
    @Override
    public void run() {
        count.addValue(15);
//        count.subtractValue(159);
        System.out.println(count.getValue());
    }

}
