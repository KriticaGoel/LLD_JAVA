package CoreJava.Threading.JoinThread;

import java.math.BigInteger;

public class Factorial {
//
//    long num ;
//    Factorial(long num) {
//        this.num = num;
//    }

    public static BigInteger factorial(long n) {
        BigInteger tempResult = BigInteger.ONE;

        for (long i = n; i > 0; i--) {
            tempResult = tempResult.multiply(new BigInteger((Long.toString(i))));
        }
        return tempResult;
    }

}
