package CoreJava.Generics.GenericInhertance;

import java.util.List;

public class Main {

//    public void printUser(List<Users> users){
//        for(Users u :  users){
//            System.out.println(u.getFirstName());
//            u.login();
//        }
//
//    }

    public static <E extends Users> void printUser(List<E> users) {
        for (E u : users) {
            System.out.println(u.getFirstName());
            u.login();
        }

    }

    public static void main(String[] args) {
//        List<Instructor> instructors = new ArrayList<Instructor>();
//        instructors.add(new Instructor("Kritica","Goel",27,5));
//        instructors.add(new Instructor("Sachin","Goel",30,4.7));
//
//        //instroctor is a child class of Users
//        printUser(instructors);
        new App().initialize();
    }
}
