package DesignPattern.Creation.SingletonPatern;

public class Singletonv3 {

    //Static we are using to bind variable with class
    private static Singletonv3 instance;


    public int number;


    private Singletonv3() {}


    public static Singletonv3 getInstance() {
        if (instance == null) { // it will allow to creat only one object Failed in thread
            instance=new Singletonv3();
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
