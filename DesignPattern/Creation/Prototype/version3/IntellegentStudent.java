package DesignPattern.Creation.Prototype.version3;

public class IntellegentStudent extends Student implements CloneInterface {

    private int iq;
    IntellegentStudent(){
super();
    }
    IntellegentStudent(int age, String name, String gender, String course, int phoneNumber,int iq){
        this.iq = iq;
        new Student(age, name, gender, course, phoneNumber);
    }
    IntellegentStudent(IntellegentStudent intellegentStudent){
        super(intellegentStudent);
        this.iq = intellegentStudent.iq;
    }

    public IntellegentStudent clone(){
        return new IntellegentStudent(this);
    }


}