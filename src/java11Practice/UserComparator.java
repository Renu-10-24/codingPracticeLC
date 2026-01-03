package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserComparator {
    public static void main(String args[]){
        User u1 =new User("Ren", 23);
        User u2 =new User("Richi", 27);
        User u3 =new User("Suchi", 28);
        User u4 =new User("Renuka", 26);
        User u5 =new User("Renuka", 21);
        List<User> users = new ArrayList<User>();
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        users.add(u5);
        Comparator<User> cmpName = Comparator.comparing(user -> user.name);
        Comparator<User> cmpAge = Comparator.comparing(user -> user.age);
        users.sort(cmpName);
        System.out.println("sort by name");
        for(User usr  : users){
            System.out.println(usr.toString());
        }
        users.sort(cmpAge);
        System.out.println("sort by age");
        for(User usr  : users){
            System.out.println(usr.toString());
        }
        System.out.println("sort by name and age");
        users.sort(cmpName.thenComparing(cmpAge));
        for(User usr  : users){
            System.out.println(usr.toString());
        }
    }
}
class User{
    int age;
    String name;
    User(String name, int age){
        this.name = name;
        this.age = age;
    }
    public  String toString(){
//        System.out.println("User : ["+name+","+age+"]");
        return "User : ["+name+","+age+"]";
    }
}