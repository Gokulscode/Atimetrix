package citi;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Student> studentList = new ArrayList<>();

    public Department(String name){
        this.name=name;
    }

    public void addStudent(Student student){
        studentList.add(student);
    }

    public String getName(){
        return this.name;
    }

    public void printStats(){
        System.out.println("citi.Department : "+this.name);
        System.out.println("Students List ");
        for(Student s : studentList){
            System.out.println("ID : "+s.getId()+ " name : "+s.getName()+ " dept : "+s.getDeptName());
        }
    }
}
