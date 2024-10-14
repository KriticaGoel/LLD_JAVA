package CoreJava.Threading.Runnable.Alternate;

public class ImplemetRunnable implements Runnable {
    public void run() {
        System.out.println("Implemenent Runnable "+Thread.currentThread().getName());
    }
}
