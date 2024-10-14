package CoreJava.Threading.Semaphore.BuildingH20;

import java.util.concurrent.Semaphore;

public class H implements Runnable {

    Semaphore h;
    Semaphore o;

    H(Semaphore h, Semaphore o) {
        this.h = h;
        this.o = o;
    }

    @Override
    public void run() {
        try {
            h.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("H");

        o.release();
    }
}


