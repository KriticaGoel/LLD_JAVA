package DesignPattern.Creation.BuilderPatern.version4;

public class Client {

    public static void main(String[] args) {
        Student student = Student.getBuilder().setAge(20).setName("Sachin").build();

//        studentBuilder.setAge(18);
//        studentBuilder.setCourse("JAVA");
//        studentBuilder.setGender("F");
//        studentBuilder.setName("Test");
//        studentBuilder.setPhoneNumber(96507359);
////client will not call constructor it will called inside build method
//        // Student s=new Student(studentBuilder);
//        Student s=studentBuilder.build();
        student.getEnroll();
    }
}
