package concurrency.synchronizedKeyword;

public class SynchronizedKeywordClient implements  Runnable{
    Count count = new Count(10);
    SynchronizedKeywordClient(Count count){
        this.count = count;
    }
    static void main() throws InterruptedException {
        Count count = new Count(10);
        SynchronizedKeywordClient client1 = new SynchronizedKeywordClient(count);
        SynchronizedKeyword synchronizedKeyword = new SynchronizedKeyword(count);
        Thread t1 = new Thread(synchronizedKeyword);
        Thread t2 = new Thread(client1);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("main : "+synchronizedKeyword.count.value);
    }

    @Override
    public void run() {
        count.subtractValue(150);
//        System.out.println(count.getValue());
//        count.addValue(15);
    }
}
