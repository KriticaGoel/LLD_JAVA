package DesignPattern.Creation.Prototype.version3;

public class Client {
    public static void main(String[] args) {
        IntellegentStudent s1= new IntellegentStudent(18,"Kritica","Femal","Java",989898,100);
        Student s2 = new Student(s1);
        System.out.println(s2.getName());
    }
}