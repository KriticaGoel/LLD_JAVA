package DesignPattern.Creation.Prototype.version2;

public class Student {

    private int age;
    private String name;
    private String gender;
    private String course;
    private int phoneNumber;


    Student(){

    }
    Student(int age, String name, String gender, String course, int phoneNumber){
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.course = course;
        this.phoneNumber = phoneNumber;
    }
    Student(Student otherStudent){
        this.age = otherStudent.age;
        this.name = otherStudent.name;
        this.gender = otherStudent.gender;
        this.course = otherStudent.course;
        this.phoneNumber = otherStudent.phoneNumber;
    }

//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
    public String getName() {
        return name;
    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getCourse() {
//        return course;
//    }
//
//    public void setCourse(String course) {
//        this.course = course;
//    }
//
//    public int getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(int phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
}
