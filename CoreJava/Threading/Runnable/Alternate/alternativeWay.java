package CoreJava.Threading.Runnable.Alternate;

public class alternativeWay {
    public static void main(String[] args) {
        Runnable runnable = new ImplemetRunnable();
        Thread thread = new Thread(runnable);
        thread.setName("SecondThread");
        thread.start();

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Third thread");
            }
        });
        thread2.start();
    }
}
