package CoreJava.Threading.JoinThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Long> inputNumbers = Arrays.asList( 100L,21111134L,567L,23L, 55L);
        List<Thread> threads = new ArrayList<>();

        for(Long num:inputNumbers){
            Thread thread = new FactorialThread(num);
            threads.add(thread);
        }

        for(Thread thread:threads){
          //  thread.setDaemon(true);
            thread.start();
        }

        for(Thread thread:threads){
            try {

                thread.join(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        //Printing result of FactorialThread in main class from thread object
        for(int i=0;i<inputNumbers.size();i++){
            FactorialThread factorial = (FactorialThread) threads.get(i);
            if(factorial.isFinished)
                System.out.println("Factorial of "+factorial.num +" is "+factorial.result);
            else
                System.out.println("Calculation is in progress for  "+factorial.num);
        }

    }
}

