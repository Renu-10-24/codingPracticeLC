package generics;

import java.util.ArrayList;
import java.util.List;

public class ContravarianceWithSuper {
    Animal a = new Animal();
    List<? super Dog> listOfDogs = new ArrayList<>();
    void addDogs(List<? super Dog> dogs) {
        dogs.add(new Dog());
    }

    static void main() {
        ContravarianceWithSuper contraV = new ContravarianceWithSuper();
        Dog shepherd1 = new GermanShepherd();
        Dog dog = new Dog();
        List<Dog> dogs = new ArrayList<>();
        dogs.add(shepherd1);
        dogs.add(dog);
        System.out.println("Current size : "+dogs.size());
        contraV.addDogs(dogs);
        contraV.addDogs(dogs);
        System.out.println("After adding more dogs, size : "+dogs.size());
        contraV.listOfDogs.add(new Poodle());
        System.out.println("ListofDogs size : "+contraV.listOfDogs.size());
        contraV.addDogs(contraV.listOfDogs);
        System.out.println("ListOfDogs size : "+contraV.listOfDogs.size());
    }
}

class GermanShepherd extends Dog{
    GermanShepherd(){
        System.out.println("I'm a Shepherd Dog :=)");
    }
    @Override
    public String toString() {
        return "Shepherd Dog obj";
    }
}
class Poodle extends Dog{
    Poodle(){
        System.out.println("I'm a Poodle Dog :=)");
    }
    @Override
    public String toString() {
        return "Poodle Dog obj";
    }
}