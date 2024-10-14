package CoreJava.Threading.Semaphore.PrintOrder;

import java.util.concurrent.Semaphore;

public class First implements Runnable {
    Semaphore afterFirst;
    Semaphore afterSecond;
    Semaphore afterThird;

    First(Semaphore afterFirst, Semaphore afterSecond, Semaphore afterThird) {
        this.afterFirst = afterFirst;
        this.afterSecond = afterSecond;
        this.afterThird = afterThird;
    }

    @Override
    public void run() {
        try {
            afterThird.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("First");
        afterFirst.release();

    }
}
