package programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterfaces {

    /*
    *
    */
@SuppressWarnings("unused")
    public static void main(String[] args){
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        //predicate interface implements a function that returns a boolean value
    Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;
    //function interface implements a function that receives a value and returns a value
    Function<Integer, Integer> squareFunction = x -> x * x;
    //consumer interface implements a function that accepts one argument and returns no result back
    Consumer<Integer> sysoutConsumer = System.out::println;
    numbers.stream()
                .filter(isEvenPredicate)
                .map(squareFunction)
                .forEach(sysoutConsumer);

    BinaryOperator<Integer> sumBinaryOperator = Integer::sum;

    BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
        @Override
        public Integer apply(Integer integer, Integer integer2) {
            return integer +integer2;
        }
    };
    Integer sum = numbers.stream()
            .reduce(0, sumBinaryOperator2);

    System.out.println(sum);
    }
}
