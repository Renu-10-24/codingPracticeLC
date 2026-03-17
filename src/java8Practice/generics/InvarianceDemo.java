package generics;

import java.util.ArrayList;
import java.util.List;

public class InvarianceDemo {
    static void main() {
        List<Animal> animals = new ArrayList<>();
        Animal a1= new Animal();
        Animal a2 = new Animal();
        Dog dog = new Dog();
        animals.add(a1);
        animals.add(a2);
        animals.add(dog);
        for(Animal a : animals){
            System.out.println(a.toString());
        }
        List<Dog> dogs = new ArrayList<>();
//        List<Animal> animalList = dogs;   //compile time error, even though Dog is an Animal, List<Dog> is NOT List<Animal>
    }
}
class Animal{
    int noOfLegs;
    Animal(){
        System.out.println("I'm an Animal :=)");
    }

    @Override
    public String toString() {
        return "Animal obj";
    }
}
class Dog extends Animal{
    Dog(){
        System.out.println("I'm a Dog :=)");
    }
    @Override
    public String toString() {
        return "Dog obj";
    }
}
