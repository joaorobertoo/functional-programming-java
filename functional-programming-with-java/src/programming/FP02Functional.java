package programming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        //List<Integer> doubleList = doubleList(numbers);

        List<Integer> doubleListEven =  numbers.stream()
                .map(x->x*x)
                .filter(x->x%2==1)
                .collect(Collectors.toList());

        List<String> courses = List.of("Java", "Python", "AWS", "Azure", "Spring", "C#");

        List<Integer> coursesLenghtList = courses.stream().map(String::length).collect(Collectors.toList());

       //int sum = addListUsingFunctionalApproach(numbers);
        //System.out.println(doubleList);
        System.out.println(coursesLenghtList);
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