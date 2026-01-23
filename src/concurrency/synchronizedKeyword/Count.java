package concurrency.synchronizedKeyword;


public class Count {
    int value;
    public Count(int value){
        this.value = value;
    }
    public synchronized void addValue(int x){
        this.value += x;
    }
    public synchronized void subtractValue(int x){
        this.value -= x;
    }
    public int getValue(){
        return this.value;
    }
}
