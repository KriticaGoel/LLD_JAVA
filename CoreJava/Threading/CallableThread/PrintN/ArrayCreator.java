package CoreJava.Threading.CallableThread.PrintN;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ArrayCreator implements Callable<ArrayList<Integer>> {
    ArrayList<Integer> list = new ArrayList<Integer>();
    int n;

    ArrayCreator(int n) {
        this.n = n;
    }

    @Override
    public ArrayList<Integer> call() throws Exception {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }
        return arr;

    }


}