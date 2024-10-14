package CoreJava.Threading.Interrupt;

public class ThreadB2A {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("Thread "+ Thread.currentThread().getName()+" is running");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("Stopped forcefully");
                    //throw new RuntimeException(e);
                    return;
                }
                System.out.println("Thread "+Thread.currentThread().getName()+" is complete execution");
            }
        });
        thread.setName("Thread1");
        thread.start();

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Thread "+ Thread.currentThread().getName()+" is running");
            }
        });
        thread2.setName("Thread2");
        thread2.start();
        thread.interrupt();
    }
}
