package com.rohit.enum_as_templete_pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

enum StudentDashboard{
    YEAR(StudentService::filterByYear),
    SUBJECT(StudentService::filterBySubject);
   public final BiFunction<StudentService,List<Student>,
           Map<String, List<Student>>> filterAlgo;

    StudentDashboard(BiFunction<StudentService,List<Student>,
            Map<String, List<Student>>> filterAlgo) {
        this.filterAlgo = filterAlgo;
    }
}

class StudentService {

    public Map<String, List<Student>> filter(List<Student> studentList
            , StudentDashboard type) {
        return type.filterAlgo.apply(this,studentList);
    }


    public Map<String, List<Student>> filterByYear(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getYear));
    }

    public Map<String, List<Student>> filterBySubject(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getSubject));
    }
}

class Student{
    String name;
    String subject;
    String address;
    String year;

    public Student(String name, String subject, String address, String year) {
        this.name = name;
        this.address = address;
        this.subject = subject;
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", address='" + address + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
public class Sample {

    public static void main(String[] args) {

        StudentService service = new StudentService();
        List<Student> students=new ArrayList<>();
        students.add(new Student("Urmila", "Math", "123 Main Street", "2020"));
        students.add(new Student("Rohit", "Java", "123 MH Street", "2020"));
        students.add(new Student("abc", "Math", "123 HYD Street", "2021"));
        System.out.println(service.filter(students, StudentDashboard.YEAR));
        System.out.println(service.filter(students, StudentDashboard.SUBJECT));

    }
}
