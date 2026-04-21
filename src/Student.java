import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int id ;
    private Department dept ;  // Associated 1 : N
    //private List<SemesterResult> results = new ArrayList<>();

    public Student(String name, int id, Department dept){
        this.name=name;
        this.id=id;
        this.dept=dept;
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

}
