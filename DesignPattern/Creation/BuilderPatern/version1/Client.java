package DesignPattern.Creation.BuilderPatern.version1;

public class Client {

    public static void main(String[] args) {
        StudentBuilder studentBuilder = new StudentBuilder();
        studentBuilder.setAge(18);
        studentBuilder.setCourse("JAVA");
        studentBuilder.setGender("F");
        studentBuilder.setName("Test");
        studentBuilder.setPhoneNumber(96507359);

        Student s=new Student(studentBuilder);
        s.getEnroll();
    }
}
