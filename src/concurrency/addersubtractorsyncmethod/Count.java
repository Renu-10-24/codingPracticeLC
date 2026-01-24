package concurrency.addersubtractorsyncmethod;

public class Count {
    private int value;
    public Count (int value){
        this.value =value;
    }
    public int getValue(){
        return this.value;
    }
    //try removing synchronized keyword and execute the main method in Main class and you would notice the Count is inconsistent before after the threads are run
    public synchronized void addValue(int i){
        this.value +=i;
    }

    public synchronized void subtractValue(int i){
        this.value -=i;
    }

}
