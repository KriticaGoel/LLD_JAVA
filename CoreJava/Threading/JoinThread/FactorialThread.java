package CoreJava.Threading.JoinThread;

import java.math.BigInteger;

public class FactorialThread extends Thread {
    long num;
    BigInteger result;
    Boolean isFinished = false;
    FactorialThread(long num){
        this.num = num;
    }
    @Override
    public void run() {
        //System.out.println("Runnable called");
        result=Factorial.factorial(num);
        isFinished=true;
        //System.out.println("Factorial of "+num +" is "+result);

    }
}
