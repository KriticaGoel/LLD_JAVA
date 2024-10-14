package CoreJava.Threading.Semaphore.PrintOrder;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore afterfirst = new Semaphore(0);
        Semaphore aftersecond = new Semaphore(0);
        Semaphore afterthird = new Semaphore(1);

        for (int i = 0; i < 10; i++) {
            First f = new First(afterfirst, aftersecond, afterthird);
            new Thread(f).start();
            Second s = new Second(afterfirst, aftersecond, afterthird);
            new Thread(s).start();
            Third t = new Third(afterfirst, aftersecond, afterthird);
            new Thread(t).start();

        }

    }
}
