package CoreJava.Threading.CallableThread.PrintN;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class printN {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService es = Executors.newCachedThreadPool();
        Future<ArrayList<Integer>> result = es.submit(new ArrayCreator(5));
        System.out.println(result.get());
        es.shutdown();

    }
}
