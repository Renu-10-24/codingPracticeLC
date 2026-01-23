package multithreadedmergesort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSort {
    static void main() {
        List<Integer> listToBeSorted = Arrays.asList(1,23,43,5,15,63,1,-34,-4,6,-6,24,32,3,4,6,2,73);
        listToBeSorted = Arrays.asList(10,2);
        //calling the single threaded version of mergesort

        MergeSorter mergeSorter = new MergeSorter(listToBeSorted);
        List<Integer> output = mergeSorter.mergeSort(listToBeSorted);
        System.out.println();
        for(int i : output){
            System.out.print(i+" ");
        }
        System.out.println();
        try (ExecutorService executorService = Executors.newCachedThreadPool()) {
            MergeSorterMultithreaded mergeSorterMultithreaded = new MergeSorterMultithreaded(listToBeSorted, executorService);
            Future<List<Integer>> futureSortedList;

            futureSortedList = executorService.submit(mergeSorterMultithreaded);

            List<Integer> sortedList = null;
            try {
                sortedList = futureSortedList.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }

            for (int i : sortedList) {
                System.out.println(i);
            }
        }
    }
}

