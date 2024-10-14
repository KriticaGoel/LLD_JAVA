package CoreJava.Threading.Semaphore.BuildingH20;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore h = new Semaphore(2);
        Semaphore o = new Semaphore(0);

        for (int i = 0; i < 10; i++) {
            H hWater = new H(h, o);
            O oWater = new O(h, o);

            Thread t1 = new Thread(hWater);
            t1.start();
            Thread t2 = new Thread(oWater);
            t2.start();
        }
    }
}
