package DesignPattern.Creation.BuilderPatern.version2;


public class Student {
    private int age;
    private String name;
    private String gender;
    private String course;
    private int phoneNumber;

    public static StudentBuilder getBuilder(){
        return new StudentBuilder();
    }

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


    public static class StudentBuilder {
        private int age;
        private String name;
        private String gender;
        private String course;
        private int phoneNumber;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        public int getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(int phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }
}


