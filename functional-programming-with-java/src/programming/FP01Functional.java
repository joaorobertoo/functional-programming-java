package programming;

import java.util.List;

public class FP01Functional {

    public static void main(String[] args){
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

       // printAllNumberInListFunctional(numbers);
            printEvenNumbersInListFunctional(numbers);
    }

    private static void printAllNumberInListFunctional(List<Integer> numbers) {
        //convert list of numbers into stream
        //Method reference
        numbers.forEach(System.out::println);
    }

    private static boolean isEven(int number){
        return number%2==0;
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        //convert list of numbers into stream
        //Method reference
        numbers.stream().filter(FP01Functional::isEven).
                forEach(System.out::println);

    }

}
