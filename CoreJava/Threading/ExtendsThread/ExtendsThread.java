package CoreJava.Threading.ExtendsThread;

public class ExtendsThread extends Thread {
    public static void main(String[] args) {
        Thread t = new ExtendsThread();
        t.start();
    }

    @Override
    public void run() {
        System.out.println(this.getName());
    }
}
