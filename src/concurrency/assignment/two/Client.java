package concurrency.assignment.two;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    //create a binary treee and pass to TreeSizeCalculator with ExecutorService


    Node node8 = new Node(8);
    Node node10 = new Node(10);
    Node node9 = new Node(9,node8,node10);
    Node node15 = new Node(15);
    Node node13 = new Node(13, null,node15);
    Node node20 = new Node(20);
    Node node16 = new Node(16,node13,node20);
    Node node12_root = new Node(12,node9,node16);   //12 is the root node

    ExecutorService service = Executors.newFixedThreadPool(2);
    TreeSizeCalculator tsc = new TreeSizeCalculator(node12_root, service);

}
