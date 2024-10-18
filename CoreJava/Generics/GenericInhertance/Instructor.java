package CoreJava.Generics.GenericInhertance;

public class Instructor extends Users {

    double avgRating;

    public Instructor(String FirstName, String LastName, int Age, double avgRating) {
        super(FirstName, LastName, Age);
        this.avgRating = avgRating;
    }

    public void scheduleSession() {
        System.out.println("Session scheduled");
    }
}
