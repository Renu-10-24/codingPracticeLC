//package java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class StreamsDemo {
	public Stream<String> streamOf(List<String> list) {
	    return list == null || list.isEmpty() ? Stream.empty() : list.stream();
	}
	public static void main(String args[]) {
	Stream<String> streamOfArray = Stream.of("a", "b", "c");
	String[] arr = new String[]{"a", "b", "c"};
	Stream<String> streamOfArrayFull = Arrays.stream(arr);
	Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
	Stream<String> streamEmpty = Stream.empty();
	
	Collection<String> collection = Arrays.asList("a", "b", "c");
	Stream<String> streamOfCollection = collection.stream();
	
	IntegerStreamDemo intstrDemo= new IntegerStreamDemo();
	intstrDemo.streamFiltering();
	}
	
}

class IntegerStreamDemo{


	public void streamFiltering() {
		Stream<Integer> streamInt = Stream.of(1,2,3,4);

		List<Integer> listInt = List.of(1,23,34,5);
		Stream<Integer> streamFromArrayList = listInt.stream();


		Integer[] integerArr = new Integer[] {(Integer) 1, (Integer) 3, (Integer) 34, (Integer) 35};
		Stream<Integer> streamFromArray = Arrays.stream(integerArr);

		Optional<Integer> maxNumber = streamFromArrayList.max(Integer::compareTo);
		//maxNumber.ifPresent(System.out::println);
		    Stream.of("A", "B", "C", "D")
	              .filter(s -> {
	                  System.out.println("Filtering: " + s);
	                  return s.equals("C");
	              })
	              .findFirst()
	              .ifPresent(System.out::println);
	        
	        Stream.of("A","B","C", "D").filter(s->s.equals("B")).findFirst().ifPresent(System.out::println);
	    }
		public void intStreamDemo(){
			IntStream.range(1, 10).peek(System.out::println).limit(5).forEach(System.out::println);
		}
	}
	
