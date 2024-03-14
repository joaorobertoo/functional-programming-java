package programming;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
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
        List<Integer> squaredNumbers = getCollect(numbers, x -> x * x);

        squaredNumbers.stream().forEach(System.out::println);

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
