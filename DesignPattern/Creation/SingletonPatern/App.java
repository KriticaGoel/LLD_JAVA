package DesignPattern.Creation.SingletonPatern;

public class App {

    public static void main(String[] args) {
        SingletonV1 singleton = new SingletonV1();
        singleton.setNumber(1);
        SingletonV1 singleton2 = new SingletonV1();//it will create another object
        singleton2.setNumber(2);
        System.out.println(singleton.getNumber());
        System.out.println(singleton2.getNumber());
       // SingletonV2 singleton3 = new SingletonV2(); //it will not work since SingletonV2 have private constructor that why we cannt call it in another class
        Singletonv2 singleton3 =Singletonv2.getInstance();
        singleton3.setNumber(3);
        Singletonv2 singleton4 =Singletonv2.getInstance();
        singleton4.setNumber(4);
        System.out.println(singleton3.getNumber());
        System.out.println(singleton4.getNumber());
        Singletonv3 singleton5 =Singletonv3.getInstance();
        singleton3.setNumber(5);
        Singletonv3 singleton6 =Singletonv3.getInstance();
        singleton6.setNumber(6);
        System.out.println(singleton5.getNumber());
        System.out.println(singleton6.getNumber());

        Singletonv4 singleton7 =Singletonv4.instance;
        singleton7.setNumber(7);
        Singletonv4 singleton8 =Singletonv4.instance;
        singleton8.setNumber(8);
        System.out.println(singleton7.getNumber());
        System.out.println(singleton8.getNumber());
    }
}
