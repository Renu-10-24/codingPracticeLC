package generics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CovarContravarExample {
    public void addNumberToList(List<? super Integer> list) {
        list.add(10);
    }

    public static void copyToNumbers(List<? extends Number> subtypeOfNumberList, List<Number> numbers) {
        for (Number number : subtypeOfNumberList) {
            numbers.add(number);
        }
    }

    public static <T> List<? super T> copyCorrect(List<? extends T> src, List<? super T> dest) {
        for (T item : src) {
            dest.add(item);
        }
        return dest;
//        return List.copyOf(dest); ideally use this, but for convenience and testing, we are using above for now
    }

    static void main() {
        CovarContravarExample c = new CovarContravarExample();
        List<Number> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(13.6f);
        numbers.add(34.5);
        c.addNumberToList(numbers);
        List<Integer> integers = new ArrayList<>();
        integers.add(40);
        integers.add(50);

                /*
        @Contract(mutates = "this")
        public abstract boolean addAll(
                @NotNull   java.util.Collection<? extends E> c)
         */
        //this kind of assignment is NOT supported due to Invariance without explicit typecast
//        numbers = (List)integers;

        //now try adding these integers into numbers -- technically all integers are numbers and should be allowed, but due to invariance, this is NOT allowed
        numbers.addAll(integers); // worked because the backing hierarchy has built in generics

        List<Float> floats = new ArrayList<>();
        floats.add(40.6f);
        floats.add(50.5f);

        numbers.addAll(floats);

        BigDecimal bigDecimal = new BigDecimal(45.6262272);
        numbers.add(bigDecimal);
        for(Number n : numbers) {
            System.out.println("Printing : "+n);
        }
        Number sum = 0;
        for(Number n : numbers) {
            sum = n.doubleValue()+sum.doubleValue();
            System.out.println(sum);
        }
        System.out.println(sum);
        /// complete generic method consumption copyCorrect

        List<Number> numberList = new ArrayList<>();
        copyToNumbers(floats,numberList);
        System.out.println(numberList.size());
        copyToNumbers(integers,numberList);
        System.out.println(numberList.size());
        copyToNumbers(List.of(bigDecimal),numberList);
        System.out.println(numberList.size());

        // copyCorrect with the use of generics supports all these
        //         Dog → Animal
        //        Integer → Number
        //        String → Object

        System.out.println("Copying with copyCorrect generic method ... ");

        List<Number> numberList1 = new ArrayList<>();
        copyCorrect(floats,numberList1);
        System.out.println(numberList1.size());
        copyCorrect(integers,numberList1);
        System.out.println(numberList1.size());
        copyCorrect(List.of(bigDecimal),numberList1);
        System.out.println(numberList1.size());

    }
}
