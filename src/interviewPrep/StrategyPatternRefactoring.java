package interviewPrep;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
public class StrategyPatternRefactoring {




}
//old code with messy switch or long if-else chain
// Problem: Refactor this into a clean, extensible functional approach

//    public double calculateDiscount(String type, double price) {
//        if (type.equals("VIP")) return price * 0.8;
//        if (type.equals("RETAIL")) return price * 0.95;
//        return price;
//    }

//1. The Strategy Pattern (Discount Calculator)
//This approach removes the "O(n) complexity" of checking if-else and replaces it with a Constant Time O(1) map lookup.
//Map<String, UnaryOperator<Double>> DISCOUNTS create a static final map like this and lookup

class DiscountService{
    // Map acts as a "Strategy Registry"
    private static final Map<String, UnaryOperator<Double>> DISCOUNTS = Map.of(
            "VIP",    price -> price * 0.80,
            "RETAIL", price -> price * 0.95,
            "BULK",   price -> price * 0.85
    );

    UnaryOperator<Double> getDiscount (double price){
        Double discount = 0.8;
        return pr->discount* price;
    }

    BiFunction<String, Double, Double> priceToDiscoutFunction = (String type, Double price)->{
        return DISCOUNTS.getOrDefault(type,p -> p).apply(price);
    };

    public double calculate(String type, double price){
        return DISCOUNTS.getOrDefault(type,p->p).apply(price);
    }

}
class User{
    String name;
    int age;
    String email;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

}
class ApplyingValidations{


    public class UserValidation {

        // A Validator is a Function that takes a User and returns an Optional error message
        private static final List<Function<User, Optional<String>>> VALIDATORS = List.of(
                user -> user.getEmail().contains("@") ? Optional.empty() : Optional.of("Invalid Email"),
                user -> user.getAge() >= 18 ? Optional.empty() : Optional.of("Must be an adult"),
                user -> user.getName() != null ? Optional.empty() : Optional.of("Name is required")
        );

        public void validateUser(User user) {
            VALIDATORS.stream()
                    .map(v -> v.apply(user))          // Run the validation
                    .filter(Optional::isPresent)      // Find the first error
                    .map(Optional::get)
                    .findFirst()                      // Fail-fast logic
                    .ifPresent(error -> {
                        throw new IllegalArgumentException(error);
                    });
        }

    }
}
