package CoreJava.Threading.ResourceSharing;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mutex {

    public static void main(String[] args) throws InterruptedException {
        //constructor
        InventoryCounter inventoryCounter = new InventoryCounter();
        Lock lock = new ReentrantLock();
        IncrementNumber inc = new IncrementNumber(inventoryCounter,lock);
        DecrementNumber dec = new DecrementNumber(inventoryCounter,lock);

        inc.start(); //start the thread
        dec.start();//start the thread
        inc.join();//finished the thread
        dec.join();//finished the thread
        System.out.println("Result of Mutex threading "+inventoryCounter.getItems());



    }

    public static class InventoryCounter {
        private int items = 0;

        public void increment() {
            items++;
        }

        public void decrement() {
            items--;
        }

        public int getItems() {
            return items;
        }
    }

    public static class IncrementNumber extends Thread{

        InventoryCounter increment;
        Lock lock;
        public IncrementNumber(InventoryCounter increment,Lock lock){
            this.increment = increment;
            this.lock = lock;
        }

        @Override
        public void run() {
            for(int i=0;i<1000;i++){
                lock.lock();
            increment.increment();
            lock.unlock();}
        }
    }

    public static class DecrementNumber extends Thread{

        InventoryCounter increment;
        Lock lock;
        public DecrementNumber(InventoryCounter increment,Lock lock){
            this.increment = increment;
            this.lock = lock;
        }

        @Override
        public void run() {
            for(int i=0;i<1000;i++){
                lock.lock();
            increment.decrement();
            lock.unlock();}
        }
    }


}
