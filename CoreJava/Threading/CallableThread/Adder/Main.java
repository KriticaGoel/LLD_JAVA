package CoreJava.Threading.CallableThread.Adder;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        Future<Integer> result = es.submit(new Adder(10, 20));//Non-Blocking
        System.out.println(result.get());//Blocking, wait till you don't get an output
        es.shutdown();
    }
}
