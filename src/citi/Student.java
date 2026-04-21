package citi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Student {
    private String name;
    private int mark;

    public Student(String name , int mark){
        this.name=name;
        this.mark=mark;
    }

    public static  void main(String[] args){
        Student s1 = new Student("lakshman", 99);
        Student s2 = new Student("gokul", 50);

        List<Student> Students = Arrays.asList(s1,s2);

        // printing student name who's mark is >75
        System.out.println("######### Student with mark >75 #############");
        Students.stream().filter(x->x.mark>75).toList().forEach(s->System.out.println(s.name));


    }
}
