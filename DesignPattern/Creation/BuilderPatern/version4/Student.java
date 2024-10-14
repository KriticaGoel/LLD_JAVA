package DesignPattern.Creation.BuilderPatern.version4;

public class Student {
    private int age;
    private String name;
    private String gender;
    private String course;
    private int phoneNumber;

    public static Student.StudentBuilder getBuilder(){
        return new Student.StudentBuilder();
    }

    private Student(Student.StudentBuilder builder) {
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
        System.out.println("Student "+this.name+" Enrollment");
    }


    public static class StudentBuilder {
        private int age;
        private String name;
        private String gender;
        private String course;
        private int phoneNumber;

        public int getAge() {
            return age;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public String getName() {
            return name;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public String getGender() {
            return gender;
        }

        public StudentBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public String getCourse() {
            return course;
        }

        public StudentBuilder setCourse(String course) {
            this.course = course;
            return this;
        }

        public int getPhoneNumber() {
            return phoneNumber;
        }

        public StudentBuilder setPhoneNumber(int phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Student build(){
            return new Student(this);
        }
    }
}
