package concurrency.map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.Map;

//concurrent version of TreeMap

public class ConcurrentSkipListMapDemo {
    public static void main(String[] args) {
        // Automatically sorts keys in ascending order
        ConcurrentSkipListMap<Integer, String> sensorData = new ConcurrentSkipListMap<>();

        sensorData.put(105, "Temperature Sensor");
        sensorData.put(101, "Pressure Sensor");
        sensorData.put(110, "Humidity Sensor");

        // 1. Keys will be printed in order: 101, 105, 110
        sensorData.forEach((id, name) -> System.out.println(id + ": " + name));

        // 2. Perform a range search (All sensors between 100 and 106)
        Map<Integer, String> range = sensorData.subMap(100, 106);
        System.out.println("Range Search Results: " + range);
    }
}
