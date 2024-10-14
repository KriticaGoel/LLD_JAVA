package CoreJava.Threading.Runnable;

public class RunnableThread implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Before Calling thread");
        Thread thread = new Thread(new RunnableThread());
        System.out.println("Before calling start method");
        thread.start();
        thread.sleep(1000);
        System.out.println("After calling start method");
    }

    @Override
    public void run() {
        System.out.println("Run method");
    }
}
