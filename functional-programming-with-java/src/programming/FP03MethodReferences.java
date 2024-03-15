package programming;

import java.util.List;
import java.util.function.Supplier;

public class FP03MethodReferences {

    private static void print(String str){
        System.out.println(str);
    }

    public static void main(String[] args){
        List<String> courses = List.of("Java", "Python", "AWS", "Azure", "Spring", "C#");

        courses.stream()
                //.map(str -> str.toUpperCase())
                //method reference with public methods, in this case we are using a method that are on the object instance
                .map(String::toUpperCase)
                .forEach(FP03MethodReferences::print);

        //constructor reference
        Supplier<String> supplier = () -> new String();
        Supplier<String> supplierMethodReference = String::new;
    }
}
