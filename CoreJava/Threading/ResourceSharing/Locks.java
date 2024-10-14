package CoreJava.Threading.ResourceSharing;

public class Locks {

    public static void main(String[] args) throws InterruptedException {
        //constructor
        InventoryCounter inventoryCounter = new InventoryCounter();
        IncrementNumber inc = new IncrementNumber(inventoryCounter);
        DecrementNumber dec = new DecrementNumber(inventoryCounter);

        inc.start(); //start the thread
        dec.start();//start the thread
        inc.join();//finished the thread
        dec.join();//finished the thread
        System.out.println("Result of Mutiple threading in sychronized way "+inventoryCounter.getItems());


    }

    public static class InventoryCounter {
        private int items = 0;

        Object lock = new Object();
        public  void increment() {
            System.out.println("Incrementing");
            synchronized (lock) {items++;}

        }

        public  void decrement() {
            System.out.println("Decrementing");
            synchronized (lock) {items--;}
        }

        public  int getItems() {
            return items;
        }
    }

    public static class IncrementNumber extends Thread{

        InventoryCounter increment;
        public IncrementNumber(InventoryCounter increment){
            this.increment = increment;
        }

        @Override
        public void run() {
            for(int i=0;i<1000;i++){
            increment.increment();}
        }
    }

    public static class DecrementNumber extends Thread{

        InventoryCounter increment;
        public DecrementNumber(InventoryCounter increment){
            this.increment = increment;
        }

        @Override
        public void run() {
            for(int i=0;i<1000;i++){
            increment.decrement();}
        }
    }


}
