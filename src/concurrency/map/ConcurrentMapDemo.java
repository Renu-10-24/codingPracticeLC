package concurrency.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConcurrentMapDemo {
    static void main() {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("Key1", 1);
        concurrentHashMap.put("Key2", 2);
        concurrentHashMap.put("Key3", 3);
        AtomicBoolean exceptionCaught = new AtomicBoolean(false);

        Thread iteratorThread = new Thread(() -> {
            Iterator<String> it = concurrentHashMap.keySet().iterator();
            try {
                while (it.hasNext()) {
                    it.next();
                    Thread.sleep(100);
                }
            } catch (ConcurrentModificationException e) {
                exceptionCaught.set(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch(Exception e){
                e.printStackTrace();
            }
        });

        Thread modifierThread = new Thread(() -> {
            try {
                Thread.sleep(50);
                concurrentHashMap.put("Key4", 4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch(Exception e){
                e.printStackTrace();
            }
        });

        iteratorThread.start();
        modifierThread.start();
        try {
            iteratorThread.join();
            modifierThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch(RuntimeException e){
            e.printStackTrace();
        }
        System.out.println(exceptionCaught.get());
    }
}
