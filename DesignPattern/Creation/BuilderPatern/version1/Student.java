package DesignPattern.Creation.BuilderPatern.version1;

public class Student {
    private int age;
    private String name;
    private String gender;
    private String course;
    private int phoneNumber;


    Student(StudentBuilder builder) {
        //validtion checks
        if(builder.getAge()<18){
            throw new IllegalArgumentException("Age must be at least 18");
        }
        this.age = builder.getAge();
        this.name = builder.getName();
        this.gender = builder.getGender();
        this.course = builder.getCourse();
        this.phoneNumber = builder.getPhoneNumber();

    }
public void getEnroll(){
    System.out.println("Student Enrollment");
}

}
