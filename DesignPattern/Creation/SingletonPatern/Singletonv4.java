package DesignPattern.Creation.SingletonPatern;

public class Singletonv4 {

    //Static we are using to bind variable with class
    public static final Singletonv4 instance= new Singletonv4();


    public int number;


    private Singletonv4() {}


    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}
