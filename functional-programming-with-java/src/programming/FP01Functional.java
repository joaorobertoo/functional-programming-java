package programming;

import java.util.List;

public class FP01Functional {

    public static void main(String[] args){
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Java", "Python", "AWS", "Azure", "Spring", "C#");
        //printAllNumberInListFunctional(numbers);
        //printEvenNumbersInListFunctional(numbers);
        //printOddNumbersInListFunctional(numbers);
        //printCourses(courses);
        //printSpringCourse(courses);
        printCoursesSizeEqualsOrGreaterThanFour(courses);
    }

    private static void printCoursesSizeEqualsOrGreaterThanFour(List<String> courses) {
        courses.stream()
                .filter(course->course.length()>=4)
                .forEach(System.out::println);
    }

    private static void printSpringCourse(List<String> courses) {
        courses.stream().filter(course->course.equals("Spring")).forEach(System.out::println);
    }

    private static void printCourses(List<String> courses) {
        courses.stream().forEach(System.out::println);
    }

    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream().filter(number -> number%2==1).forEach(System.out::println);
    }

//    private static void printAllNumberInListFunctional(List<Integer> numbers) {
//        //convert list of numbers into stream
//        //Method reference
//        numbers.forEach(System.out::println);
//    }

//    private static boolean isEven(int number){
//        return number%2==0;
//    }

    //number -> number%2==0
    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        //convert list of numbers into stream
        //Method reference
        numbers.stream()
                .filter(number -> number%2==0) //Lambda expression
                .forEach(System.out::println);

        //.filter(FP01Functional::isEven).

    }

}
