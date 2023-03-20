package threadSignal.java8;

import java.util.*;

public class ListTest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>() {
            {
                add(new Student("xiaowang", "wuhan", 5));
                add(new Student("xiaoliu", "shanghai", 6));
                add(new Student("xiaoliu", "shanghai", null));
                add(new Student("xiaoliu", "shanghai", 1));
            }
        };


        Integer maxAge = Optional.ofNullable(students).orElse(Collections.emptyList()).stream().filter(item -> item.getAge() != null).max(Comparator.comparing(Student::getAge)).map(Student::getAge).orElse(null);

        System.out.println(maxAge);

    }
}
