package CoreJava.Threading.Semaphore.PrintOrder;

import java.util.concurrent.Semaphore;

public class Third implements Runnable {

    Semaphore afterFirst;
    Semaphore afterSecond;
    Semaphore afterThird;

    Third(Semaphore afterFirst, Semaphore afterSecond, Semaphore afterThird) {
        this.afterFirst = afterFirst;
        this.afterSecond = afterSecond;
        this.afterThird = afterThird;
    }

    @Override
    public void run() {
        try {
            afterSecond.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("Third");
        System.out.println();
        afterThird.release();

    }
}
