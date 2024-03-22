package programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class  Course{
    private String name;
    private String category;
    private int reviewScore;
    private int nOfStudents;

    public Course(String name, String category, int reviewScore, int nOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.nOfStudents = nOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getnOfStudents() {
        return nOfStudents;
    }

    public void setnOfStudents(int nOfStudents) {
        this.nOfStudents = nOfStudents;
    }

    public String toString(){
        return name + ":" + nOfStudents + ":" + reviewScore;
    }
}

public class FP04CustomClass {
    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Spring", "Framework", 98,2000),
                new Course("Spring Boot", "Framework", 95,1800),
                new Course("API", "Microservices", 97,2200),
                new Course("Microservices", "Microservices", 96,2500),
                new Course("FullStack", "FullStack", 91,1400),
                new Course("AWS", "Cloud", 92,2100),
                new Course("Azure", "Cloud", 99,2100),
                new Course("Docker", "Cloud", 92,2000),
                new Course("Kubernets", "Cloud", 91,2000)
                );
//allMatch, noneMatch, anyMatch
        Predicate<Course> reviewScoreGreaterThan95 = course -> course.getReviewScore() > 95;
        Predicate<Course> reviewScoreGreaterThan90 = course -> course.getReviewScore() > 90;
        //System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95));

        //System.out.println(courses.stream().allMatch(reviewScoreGreaterThan90));

        //System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan90));
        //limit
        Comparator<Course> comparingByNoOfStudentsIncreasing
                = Comparator.comparingInt(Course::getnOfStudents);

        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsIncreasing)
                        .collect(Collectors.toList()));
        //[FullStack:14000:91, Spring Boot:18000:95, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, AWS:21000:92, Azure:21000:99, API:22000:97, Microservices:25000:96]

        Comparator<Course> comparingByNoOfStudentsDecreasing
                = Comparator.comparingInt(Course::getnOfStudents).reversed();

        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsDecreasing)
                        .collect(Collectors.toList()));
        //[Microservices:25000:96, API:22000:97, AWS:21000:92, Azure:21000:99, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]


        Comparator<Course> comparingByNoOfStudentsAndNoOfReviews
                = Comparator.comparingInt(Course::getnOfStudents)
                .thenComparingInt(Course::getReviewScore)
                .reversed();

        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndNoOfReviews)
                        .collect(Collectors.toList()));
        //[Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]
        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndNoOfReviews)
                        .limit(5)
                        .collect(Collectors.toList()));
        //[Microservices:2500:96, API:2200:97, Azure:2100:99, AWS:2100:92, Spring:2000:98]
        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndNoOfReviews)
                        .skip(3)
                        .collect(Collectors.toList()));
        //[AWS:2100:92, Spring:2000:98, Docker:2000:92, Kubernets:2000:91, Spring Boot:1800:95, FullStack:1400:91]
        //takeWhile and dropWhile
        System.out.println(courses);
        System.out.println(courses.stream()
                .takeWhile(course-> course.getReviewScore() >=95).collect(Collectors.toList()));

        System.out.println(courses.stream()
                .dropWhile(course-> course.getReviewScore() >=95).collect(Collectors.toList()));

    }

}
