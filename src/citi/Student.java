package citi;

import java.util.function.Predicate;

public class Student {
    private String name;
    private int id ;
    private Department dept ;  // Associated 1 : N
    private int mark;

    public Student(String name, int id, Department dept, int mark){
        this.name=name;
        this.id=id;
        this.dept=dept;
        this.mark=mark;
        dept.addStudent(this); // bidirectional consistency

    }
    public int  getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getDeptName(){
        return this.dept.getName();
    }
    public int getMark(){
        return this.mark;
    }

    @Override
    public String toString() {
        return this.name+":"+this.id;
    }


}
