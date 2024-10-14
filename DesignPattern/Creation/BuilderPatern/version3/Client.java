package DesignPattern.Creation.BuilderPatern.version3;


public class Client {
    public static void main(String[] args) {
        Student.StudentBuilder studentBuilder = Student.getBuilder();

        studentBuilder.setAge(18);
        studentBuilder.setCourse("JAVA");
        studentBuilder.setGender("F");
        studentBuilder.setName("Test");
        studentBuilder.setPhoneNumber(96507359);
//client will not call constructor it will called inside build method
        // Student s=new Student(studentBuilder);
        Student s=studentBuilder.build();
        s.getEnroll();
    }
}
