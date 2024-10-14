package CoreJava.Threading.DaemonThread;

import java.math.BigInteger;

public class LongComputation {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Computation(new BigInteger("343423424234445"),999999999));
        t1.setDaemon(true);//Main thread gets terminated onces it get finished no matter Computation thread finished or not
        t1.start();
        t1.interrupt();

    }

    public static class Computation implements Runnable {

        BigInteger abc = new BigInteger("1");
        BigInteger base;
        int pow;

        Computation(BigInteger base,int pow) {
            this.base = base;
            this.pow = pow;
        }
        @Override
        public void run() {
            System.out.println(base+"^"+pow+" = "+power(base,pow));

        }

        public BigInteger power(BigInteger base, int exponent) {
            for(int i=1;i<= exponent;i++){
//                if(Thread.currentThread().isInterrupted()){
//                    return BigInteger.ZERO;
//                }
                abc=abc.multiply(base);
            }
            return abc;
        }
    }
}
