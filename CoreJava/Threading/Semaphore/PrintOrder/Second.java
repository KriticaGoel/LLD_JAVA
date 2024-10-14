package CoreJava.Threading.Semaphore.PrintOrder;

import java.util.concurrent.Semaphore;

public class Second implements Runnable {

    Semaphore afterFirst;
    Semaphore afterSecond;
    Semaphore afterThird;

    Second(Semaphore afterFirst, Semaphore afterSecond, Semaphore afterThird) {
        this.afterFirst = afterFirst;
        this.afterSecond = afterSecond;
        this.afterThird = afterThird;
    }

    @Override
    public void run() {
        try {
            afterFirst.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("Second");
        afterSecond.release();

    }
}
