package multithreadedmergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSorterMultithreaded implements Callable<List<Integer>> {
    private List<Integer> listToBeSorted;
    private ExecutorService executorService;
    public MergeSorterMultithreaded(List<Integer> listToBeSorted, ExecutorService executorService) {
        this.listToBeSorted = listToBeSorted;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        //Implement merge sort
        int n = listToBeSorted.size();
        if (n <= 1) {
            return listToBeSorted;
        }
        List<Integer> leftHalf = listToBeSorted.subList(0, n / 2);
        List<Integer> rightHalf = listToBeSorted.subList(n / 2, n);

        //sort the firstHalf recursively in separate thread
        MergeSorterMultithreaded leftHalfMergeSorter = new MergeSorterMultithreaded(leftHalf,executorService);
        MergeSorterMultithreaded rightHalfMergeSorter = new MergeSorterMultithreaded(rightHalf,executorService);

        //creating threads manually is not efficient, use ExecutorService for the same
//        Thread leftThread = new Thread(firstHalfMergeSorter);
//        Thread rightThread = new Thread(secondHalfMergeSorter);

        Future<List<Integer>> futureLeftSortedList;
        Future<List<Integer>> futureRightSortedList;

        //reuse the one the class provides in the constructor, DO NOT create a new ExecutorService inside the call method
//        try (ExecutorService executorService = Executors.newCachedThreadPool()) {

            //executorservice returns a future object

            //non blocking call
            futureLeftSortedList = executorService.submit(leftHalfMergeSorter);
            futureRightSortedList = executorService.submit(rightHalfMergeSorter);
//        }

        //Merge sorted left n right half arrays
        List<Integer> leftsortedList = futureLeftSortedList.get(); // this is a blocking call - the main thread has to wait for the result to be available
        List<Integer> rightsortedList = futureRightSortedList.get();

        int i = 0, j = 0;
        List<Integer> finalSortedList = new ArrayList<>();
        while (i < leftsortedList.size() && j < rightsortedList.size()) {
            if (leftsortedList.get(i) < rightsortedList.get(j)) {
                finalSortedList.add(leftsortedList.get(i));
                i++;
            } else {
                finalSortedList.add(rightsortedList.get(j));
                j++;
            }
        }
        while (i < leftsortedList.size()) {
            finalSortedList.add(leftsortedList.get(i));
            i++;
        }
        while (j < leftsortedList.size()) {
            finalSortedList.add(rightsortedList.get(j));
            j++;
        }
        return finalSortedList;

    }
}
