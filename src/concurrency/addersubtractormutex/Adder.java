package concurrency.addersubtractormutex;

public class Adder implements Runnable{
    private final Count count;
    Adder(Count count){
        this.count = count;
    }
    @Override
    public void run() {
        for(int i=1;i<=1000000;i++){
            count.value += i;
            System.out.println("In adder : "+count.value);
        }
    }
}
