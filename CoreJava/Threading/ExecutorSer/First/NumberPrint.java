package CoreJava.Threading.ExecutorSer.First;

public class NumberPrint extends Thread {
    private int number;

    public NumberPrint(int number) {
        this.number = number;
    }

    public void run() {
        System.out.println(number);
    }
}
