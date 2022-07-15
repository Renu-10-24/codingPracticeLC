package java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class StreamsDemo {
	Stream<String> streamOfArray = Stream.of("a", "b", "c");
	String[] arr = new String[]{"a", "b", "c"};
	Stream<String> streamOfArrayFull = Arrays.stream(arr);
	Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
	Stream<String> streamEmpty = Stream.empty();
	public Stream<String> streamOf(List<String> list) {
	    return list == null || list.isEmpty() ? Stream.empty() : list.stream();
	}
	Collection<String> collection = Arrays.asList("a", "b", "c");
	Stream<String> streamOfCollection = collection.stream();
	
}
