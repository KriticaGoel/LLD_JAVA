package CoreJava.Generics.GenericInhertance;

import java.util.function.Function;

public class TemporaryInstructor extends Instructor {

    boolean isTemp;
    Function<Integer, String> function = new Function<Integer, String>() {
        @Override
        public String apply(Integer integer) {
            return integer.toString();
        }
    };

    public TemporaryInstructor(String FirstName, String LastName, int Age, double avgRating, boolean isTemp) {
        super(FirstName, LastName, Age, avgRating);
        this.isTemp = isTemp;
    }

    public void isTemporaryUser() {
        System.out.println("User is " + isTemp);
    }
}