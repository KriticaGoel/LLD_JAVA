package CoreJava.Generics.GenericInhertance;

import java.util.ArrayList;
import java.util.List;

public class App {

    public void initialize() {
        List<TemporaryInstructor> temporaryInstructors = new ArrayList<TemporaryInstructor>();
        temporaryInstructors.add(new TemporaryInstructor("Kritica", "Goel", 27, 5, true));
        temporaryInstructors.add(new TemporaryInstructor("Sachin", "Goel", 30, 4.7, false));

        List<Users> users = new ArrayList<Users>();
        users.add(new Users("Kritica", "Goel", 27));
        users.add(new Users("Sachin", "Goel", 30));


        List<Instructor> instructors = new ArrayList<Instructor>();
        instructors.add(new Instructor("Kritica", "Goel", 27, 5));
        instructors.add(new Instructor("Sachin", "Goel", 30, 4.7));

        //Users is a paerent class of Instructor
        //printUser(users);-- not allow

        // Instructor is a clas defined in printUser argument
        printUser(instructors);
        //TemporaryInstructor is a child class of Instructor
        printUser(temporaryInstructors);// child class can be pass as argument temporaryInstructors is a child class of Instructor
    }

    public <E extends Instructor> void printUser(List<E> users) {
        for (E user : users) {
            System.out.println(user.getFirstName());
            user.login(); // Define in parent class of Instructor
            user.scheduleSession(); // Define in Instructor class
            //user.isTemp(); Define in child class of Instructor. Child class method can't be called
        }
    }
}
