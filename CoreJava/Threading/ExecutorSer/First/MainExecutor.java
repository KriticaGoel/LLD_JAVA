package CoreJava.Threading.ExecutorSer.First;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainExecutor {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 1; i < 100; i++) {
            es.submit(new NumberPrint(i));
        }
        es.shutdown();

        ExecutorService escache = Executors.newCachedThreadPool();
        for (int i = 1; i < 100; i++) {
            escache.submit(new NumberPrint(i));
        }
        escache.shutdown();
    }
}
