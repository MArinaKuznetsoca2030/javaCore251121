package homework9;

import lesson9.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class homework9Start {

    private static final ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        Course course1 = new Course("java-core");
        Course course2 = new Course("java1");
        Course course3 = new Course("css");

        Student student1 = new Student("Маша", course1);
        Student student4 = new Student("Маша", course3);
        Student student5 = new Student("Маша", course3);
        Student student2 = new Student("Elena",course1);
        Student student3 = new Student("Gleb", course3);


        addStudensArraylist(student1);
        addStudensArraylist(student2);
        addStudensArraylist(student3);
        addStudensArraylist(student4);
        addStudensArraylist(student5);

        uniqueCourses(students);
        listStudentsWhoAttendCourse(students, course1.name);

    }

    private static void uniqueCourses(ArrayList<Student> students) {
        List<String> resultCourse;
        resultCourse = students.stream()
                .map(student -> student.courses.name)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(resultCourse);



    }

    private static void listStudentsWhoAttendCourse(ArrayList<Student> students, String courseName) {
        List<String> resultStudent = students.stream()
                .filter(student -> student.courses.name.equals(courseName))
               .map(student -> student.name)
               .collect(Collectors.toList());

        System.out.println(resultStudent);
    }


    private static void addStudensArraylist(Student student) {

        students.add(student);
    }


}
