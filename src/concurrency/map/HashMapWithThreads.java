package concurrency.map;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class HashMapWithThreads {
    static void main() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Key1", 1);
        hashMap.put("Key2", 2);
        hashMap.put("Key3", 3);
        AtomicBoolean exceptionCaught = new AtomicBoolean(false);

        Thread iteratorThread = new Thread(() -> {
            Iterator<String> it = hashMap.keySet().iterator();
            try {
                while (it.hasNext()) {
                    it.remove();
                    it.next();
                    hashMap.put("NewKey",56);
                    Thread.sleep(100);
                }
            } catch (ConcurrentModificationException e) { // even though handling RuntimeExceptions like ConcurrentModificationException is allowed,
                // it makes no sense at all, the logic failed at line 21 and crashed with this :
                /*
                java.util.ConcurrentModificationException
	            at java.base/java.util.HashMap$HashIterator.nextNode(HashMap.java:1605)
	            at java.base/java.util.HashMap$KeyIterator.next(HashMap.java:1628)
	            at concurrency.map.HashMapWithThreads.lambda$main$0(HashMapWithThreads.java:21)
	            at java.base/java.lang.Thread.run(Thread.java:1583)
                * */
                e.printStackTrace();
                exceptionCaught.set(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch(Exception e){
                e.printStackTrace();
            }
        });

        Thread modifierThread = new Thread(() -> {
            try {
//                Thread.sleep(50);
                hashMap.put("Key4", 4);
                hashMap.remove("Key3");
            } catch (ConcurrentModificationException e) {
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
