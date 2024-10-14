package CoreJava.Threading.Semaphore.BuildingH20;

import java.util.concurrent.Semaphore;

public class O implements Runnable {
    Semaphore h;
    Semaphore o;

    O(Semaphore h, Semaphore o) {
        this.h = h;
        this.o = o;
    }

    public void run() {
        try {

            o.acquire(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("O");
        System.out.println();
        h.release(2);
    }
}
