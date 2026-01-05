//package java8;

import java.util.*;
import java.util.stream.Collectors;
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
	intstrDemo.intStreamDemo();
	// Function<T,R> --> has method R apply(T)
		EmployeeStreamDemo e = new EmployeeStreamDemo();
		e.empStreamOperations();
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
		maxNumber.ifPresent(System.out::println);
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
			//peek to see value at that point in stream for debugging
			int sum =IntStream.of(1, 2, 3, 4)
					.filter(e -> e > 2)
					.peek(e -> System.out.println("Filtered value: " + e))
					.map(e -> e * e)
					.peek(e -> System.out.println("Mapped value: " + e))
					.sum();
			System.out.println(sum);
		}
	}
	//to make this record public, it has to be declared in a .java file called Employee.java
	//Records can be used as DTO objects, but not as Entity classes.
	record Employee(
		int id,
		String name,
		String department,
		double salary
	){}
	class EmployeeStreamDemo {
		public void empStreamOperations() {
			Employee emp1 = new Employee(1, "Ren", "Crypto", 1200000);
			Employee emp2 = new Employee(2, "Chung", "Crypto", 2200000);
			Employee emp3 = new Employee(3, "Michelle", "Crypto", 1200000);
			Employee emp4 = new Employee(4, "Prajil", "Crypto", 5200000);
			Employee emp5 = new Employee(5, "Moupriya", "Crypto", 5200000);
			Employee emp6 = new Employee(6, "Brooke", "Crypto", 4200000);

			Employee emp7 = new Employee(7, "Mouli", "Technical", 1200000);
			Employee emp8 = new Employee(8, "Ramya", "NonTechnical", 2200000);
			Employee emp9 = new Employee(9, "Manju", "FullStack", 1200000);
			Employee emp10 = new Employee(10, "Neha", "QA", 5200000);
			Employee emp11 = new Employee(11, "Swathi", "Frontend", 5200000);
			Employee emp12 = new Employee(12, "Brooke", "FullStack", 4200000);
			List<Employee> empList = List.of(emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8, emp9, emp12, emp11, emp10);
			//average salary
			empList.stream().mapToDouble(Employee::salary).average().ifPresentOrElse(System.out::println, () -> System.out.println("Invalid Average salary"));
			//list of employees, department wise==> Department->(Id + Name)
			empList.stream().collect(Collectors.groupingBy(Employee::department)).entrySet().forEach(entry -> {
				String key = entry.getKey();
				List<Employee> list = entry.getValue();
				//department name
				System.out.print(entry.getKey() + "-->\n");
				//emp's in that department
				list.forEach(e->System.out.print("["+e.id()+" "+e.name()+"]   "));
				System.out.println();
			});
		}
	}
	
