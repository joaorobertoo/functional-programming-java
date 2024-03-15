package programming;

import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class FP03BehaviorParameterization {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);


        //filterAndPrint(numbers, x -> x % 2 == 0);

        //filterAndPrint(numbers, x -> x % 2 != 0);

        //filterAndPrint(numbers, x-> x%3==0);

        //exercise, writing a behaviorParameterization to do square of a numbers
        //possible to pass functions as parameters
        //variables with logic of a function
        //List<Integer> squaredNumbers = getCollect(numbers, x -> x * x);

        //squaredNumbers.stream().forEach(System.out::println);

        //Types of Functional interfaces
        //Predicate has input and boolean output
        Predicate<Integer> isEvenPredicate = x->x%2==0;
        //Function has input and output
        Function<Integer,Integer> squareFunction = x-> x*x;
        //Consumer has input but no output
        Consumer<Integer> sysoutConsumer = x->System.out.println(x);
        //Binary operator add numbers in
        BinaryOperator<Integer> sumBinaryOperator = (x,y)->x+y;
        //Supplier no input -> return something(factory pattern)
        Supplier<Integer> randomIntegerSupplier = ()-> {
            Random random = new Random();
            return random.nextInt(1000);
        };
        //System.out.println(randomIntegerSupplier.get());

        //UnaryOperator -> takes one parameter and returns result of same type
        UnaryOperator<Integer> unaryOperator = (x) -> 3*x;

        //System.out.println(unaryOperator.apply(10));

        //BiPredicate -> accepts two values and return boolean
        BiPredicate<Integer,Integer> biPredicate = (x,y)-> x==y;
        //System.out.println(biPredicate.test(2,2));
        //BiFunction -> accepts two values and return one value
        BiFunction<Integer,Integer, String> biFunction = (x,y)-> String.valueOf(x+y);
        //System.out.println(biFunction.apply(10,20));
        //BiConsumer accepts two values and consumes then
        BiConsumer<String,String> biConsumer = (x,y)-> System.out.println(x+y);
        biConsumer.accept("Eu", "Sei");

    }

    private static List<Integer> getCollect(List<Integer> numbers, Function<Integer, Integer> functionparameter) {
        return numbers.stream()
                .map(functionparameter)
                .collect(Collectors.toList());
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}
