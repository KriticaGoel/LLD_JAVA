package CoreJava.Threading.Runnable;

public class NewWayImplementInterface {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                //Thread.setName("secondThread");
                System.out.println("We are in Thread "+Thread.currentThread().getName()+" thread Priority "+Thread.currentThread().getPriority());
                throw new RuntimeException("Not working properly");
            }
        });
        thread.setName("FirstThread");
        thread.setPriority(Thread.MAX_PRIORITY);

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Critical exception "+e.getMessage()+" on thread "+t.getName());
            }
        });
        System.out.println("Before start of Thread "+Thread.currentThread().getName());
        thread.start();
        Thread.sleep(10000);
        System.out.println("After start of Thread "+Thread.currentThread().getName());

    }
}
