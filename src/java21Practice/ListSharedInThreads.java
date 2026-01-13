import java.util.ArrayList;
import java.util.List;

public class ListSharedInThreads{
    static void main() {
        List<Integer> list = new ArrayList<>();
        Thread t1 = new Thread(() -> {
            try{
            Thread.sleep(1000);
                System.out.println("done slpeeing");
            for (int i = 0; i < 20; i++) {
                list.add(i);
            }
            }catch(InterruptedException ie){
                System.out.println(ie);
            }catch(Exception e){
                System.out.println(e);
            }
    });
        Thread t2 = new Thread(() -> {
            for(int i : list) {
                System.out.println(i);
            }
        });
        t2.start();
        t1.start();
        System.out.println("fdaffsfsdfds "+list);
    }
}
