import java.util.List;
import java.util.Optional;

public class OptionalPractice {
    static void main() {
        User u1 = new User("r",new Address("street","f"),24);
        User u2 = new User("r1",new Address("street","f"),21);
        User u3 = new User("r2",new Address("street","f"),22);
        User u4 = new User("r4",new Address("street","f"),23);
        User u5 = new User("r7",new Address("street","f"),20);
        User u6 = new User("r5",new Address("street","f"),27);
        User u7 = new User("r8",new Address("street","f"),29);
        List<User> userList = List.of(u1,u2,u3,u4,u5,u6,u7);


        Optional<String> opts =  Optional.ofNullable(u2)
                .map(User::address)
                .map(Address::city);

    }
}
record Address(String street, String city){}
record User(String name, Address address, int age){}