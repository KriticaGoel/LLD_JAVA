package DesignPattern.Creation.SingletonPatern;

public class Singletonv6 {


    //Static we are using to bind variable with class
    private static Singletonv6 instance;


    public int number;


    private Singletonv6() {}

//
    public static   Singletonv6 getInstance() {
        if (instance == null) {
            synchronized (Singletonv6.class) {//// This will allow only one thread to enter the synchronized block of code for
                if (instance == null)
                    instance = new Singletonv6();
            }
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
