package multithreadedmergesort;

import java.util.ArrayList;
import java.util.List;

public class MergeSorter {
    private List<Integer> listToBeSorted;
    public MergeSorter(List<Integer> listToBeSorted){
        this.listToBeSorted = listToBeSorted;
    }

    public List<Integer> mergeSort(List<Integer> list){
        int n = list.size();
        if(n==1){
            return list;
        }
        List<Integer> leftHalfSortedList = mergeSort(list.subList(0,n/2));
        List<Integer> rightHalfSortedList = mergeSort(list.subList(n/2,n));

        List<Integer> finalSortedList = new ArrayList<>();
        //merging sorted halves step
        int i=0, j=0;
        while(i<leftHalfSortedList.size() && j<rightHalfSortedList.size()){
            if(leftHalfSortedList.get(i)<rightHalfSortedList.get(i)) {
                finalSortedList.add(leftHalfSortedList.get(i));
                i++;
            }else{
                finalSortedList.add(rightHalfSortedList.get(j));
                j++;
            }
        }

        while(i<leftHalfSortedList.size()){
            finalSortedList.add(leftHalfSortedList.get(i));
            i++;
        }

        while(j<rightHalfSortedList.size()){
            finalSortedList.add(rightHalfSortedList.get(j));
            j++;
        }
        return finalSortedList;
    }
}
