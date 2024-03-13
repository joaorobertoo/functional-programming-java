package programming;

import java.util.List;
import java.util.stream.Collectors;

public class FP02StreamOperations {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

/*
We have many Stream operations,
some returns Streams and are considered intermediate operators, like:
    distinct() // remove duplications
    sorted //organize
    map //modify numbers in stream
    filter// filter some numbers

Some are terminal operations, that are the final operation:
    forEach //return a void, consumes element
    collect //return a specific value, move streams to a Collection
    reduce //return a specific value, move stream into one element

 */

        numbers.stream()
                .distinct()//return Stream is an intermediate operator
                .sorted()//return Stream is an intermediate operator
                .forEach(System.out::println);//

        //List<Integer> doubleList = doubleList(numbers);

        List<Integer> doubleListEven =  numbers.stream()
                .map(x->x*x)//return Stream is an intermediate operator
                .filter(x->x%2==1)//return Stream is an intermediate operator
                .collect(Collectors.toList());

        List<String> courses = List.of("Java", "Python", "AWS", "Azure", "Spring", "C#");

        List<Integer> coursesLenghtList = courses.stream().map(String::length).collect(Collectors.toList());

        //int sum = addListUsingFunctionalApproach(numbers);
        //System.out.println(doubleList);
       // System.out.println(coursesLenghtList);
    }

    private static List<Integer> doubleList(List<Integer> numbers) {
        return numbers.stream()
                .map(x->x*x)
                .collect(Collectors.toList());
    }

    private static int sum(int aggregate, int nextNumber){
        System.out.println(aggregate+ " " +nextNumber);
        return aggregate+nextNumber;
    }

    private static int addListUsingFunctionalApproach(List<Integer> numbers) {
        return numbers.stream()
                //.reduce(0, FP02Functional::sum);
                //.reduce(0, (x,y)->x+y);
                .reduce(0,Integer::sum);
    }


}
