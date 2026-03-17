package generics;

import java.util.ArrayList;
import java.util.List;

public class CovarianceDemo {
    void printAnimals(List<? extends Animal> animals) {
        for (Animal a : animals) {
            System.out.println(a.toString());
        }
    }
    static void main() {
        List<? extends Animal> animals = new ArrayList<>();

        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Dog dog3 = new Dog();
        List<Dog> dogs = new ArrayList<>(List.of(dog1,dog2,dog3));

        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        CovarianceDemo c = new CovarianceDemo();
        List<Cat> cats = new ArrayList<>(List.of(cat1,cat2));

        animals = cats;
        System.out.println("Passing list of cats as animals");
        c.printAnimals(animals);
        System.out.println("Passing list of animals here ------- ");
        c.printAnimals(cats);
        animals = dogs;
        System.out.println("Passing list of dogs as dogs");
        c.printAnimals(dogs);
        System.out.println("Passing list of dogs as animals");
        c.printAnimals(animals);
        System.out.println("before size of animals : "+animals.size());

//        You cannot add elements.
//        animals.add(new Dog());   // ❌ compile error

        Dog dog4 = new Dog();
        dogs.add(dog4);
        animals =dogs;
        c.printAnimals(animals);
        System.out.println("new size of animals : "+animals.size());
//        Because Java doesn't know the exact subtype.
        //Reading is allowed.

    }

}
class Cat extends Animal{}
