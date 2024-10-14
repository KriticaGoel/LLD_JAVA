package DesignPattern.Creation.SingletonPatern;

public class Singletonv2 {
    //Static we are using to bind variable with class
    private static Singletonv2 instance;


    public int number;


    private Singletonv2() {}

    //Static we are using so that method can be called awith class name without object
    public static Singletonv2 getInstance() {
        return new Singletonv2(); //its allow multiple objects to be created
    }


    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}
