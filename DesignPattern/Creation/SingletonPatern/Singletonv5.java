package DesignPattern.Creation.SingletonPatern;

public class Singletonv5 {

    //Static we are using to bind variable with class
    private static Singletonv5 instance;


    public int number;


    private Singletonv5() {}


    public static synchronized  Singletonv5 getInstance() {
        if (instance == null) { // it will allow to creat only one object Failed in thread
            instance=new Singletonv5();
        }
        return instance;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}
