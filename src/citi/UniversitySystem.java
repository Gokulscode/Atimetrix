package citi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class UniversitySystem {
    public static  void main(String[] args){
        Department csc = new Department("computer Science");

        Department mech = new Department("Mechanical");

        Student alice = new Student("alice",001,csc,66);
        Student bob = new Student("bob",002,csc,75);
        Student chandra = new Student("chandra",003,csc,89);

        Student aravind = new Student("aravind",101,mech,77);
        Student babu = new Student("babu",102,mech,84);
        Student charles = new Student("charles",103,mech,47);



        // one to many bi-directional implementation
        csc.printStats();
        mech.printStats();

        List<Student> Students = Arrays.asList(alice,bob,chandra,aravind,babu,charles);

        // 1. Print marks greater than 75 in streams

        System.out.println("************** Print marks greater than 75 in streams *******************");
        Students.stream().filter(s->s.getMark()>90).forEach(s->System.out.println(s.getName()));

        // 2. using java8 group the List of Students based on their departments
         System.out.println("************** using java8 group the List of Students based on their departments *******************");
         Students.stream().collect(Collectors.groupingBy(Student::getDeptName)).entrySet().forEach(s->System.out.println(s.getKey()+" : "+s.getValue()));


         // using predicate to fetch the csc topper
        System.out.println("************** using predicate to fetch the csc topper  *******************");
        System.out.println();
        Predicate<Student> topper = s -> s.getMark() >= 85;
        Predicate<Student> isCsc = s->"computer Science".equals(s.getDeptName());
        Students.stream().filter(topper.or(isCsc)).forEach(s->System.out.println(s.getName()));


    }
}
