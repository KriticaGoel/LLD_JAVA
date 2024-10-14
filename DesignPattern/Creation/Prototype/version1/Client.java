package DesignPattern.Creation.Prototype.version1;

public class Client {
    public static void main(String[] args) {
        Student s1= new Student();
        s1.setAge(18);
        s1.setName("John");
        s1.setCourse("Java");
        s1.setGender("Female");
        s1.setPhoneNumber(9898);

        IntellegentStudent s2 = new IntellegentStudent();
        s2.setAge(s1.getAge());
        //s2.setIq(s1.getI);
        System.out.println(s2.getAge());
    }
}
