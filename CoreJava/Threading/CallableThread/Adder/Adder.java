package CoreJava.Threading.CallableThread.Adder;

import java.util.concurrent.Callable;

public class Adder implements Callable<Integer> {
    int i;
    int j;

    public Adder(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public Integer call() throws Exception {
        return i + j;
    }
}
