public class UniversitySystem {
    public static  void main(String[] args){
        Department csc = new Department("computer Science");

        Student alice = new Student("alice",001,csc);
        Student bob = new Student("bob",002,csc);
        Student chandra = new Student("chandra",003,csc);


        csc.printStats();

    }
}
