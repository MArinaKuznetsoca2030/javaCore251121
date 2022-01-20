package homework9;

import java.util.Arrays;

public class Student {
    String name;
    Course courses;

    public Student(String name, Course courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }
}
