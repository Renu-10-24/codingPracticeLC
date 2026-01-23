package concurrency.assignment.two;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class TreeSizeCalculator implements Callable<Integer> {
    private Node root;
    private ExecutorService executorService;
    TreeSizeCalculator(Node root, ExecutorService executorService){
        this.root = root;
        this.executorService = executorService;
    }
    @Override
    public Integer call() throws Exception {

        return 0;
    }
}
