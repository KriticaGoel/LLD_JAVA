package CoreJava.Threading.ResourceSharing;

public class IncrementDecrement {

    public static void main(String[] args) throws InterruptedException {
        //constructor
        InventoryCounter inventoryCounter = new InventoryCounter();
        IncrementNumber inc = new IncrementNumber(inventoryCounter);
        DecrementNumber dec = new DecrementNumber(inventoryCounter);

        inc.start(); //start the thread
        inc.join();//finished the thread
        dec.start();//start the thread
        dec.join();//finished the thread
        System.out.println("Result of sequential threading "+inventoryCounter.getItems());

        InventoryCounter inventoryCounter1 = new InventoryCounter();
        IncrementNumber inc1 = new IncrementNumber(inventoryCounter1);
        DecrementNumber dec1 = new DecrementNumber(inventoryCounter1);

        inc1.start(); //start the thread
        dec1.start();//start the thread
        inc1.join();//finished the thread
        dec1.join();//finished the thread

        System.out.println("Result of multi threading "+inventoryCounter1.getItems());

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
