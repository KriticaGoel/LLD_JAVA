package DesignPattern.Creation.Prototype.version2;

public class IntellegentStudent extends Student {

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


}