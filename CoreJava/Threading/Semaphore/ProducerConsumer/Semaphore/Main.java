package CoreJava.Threading.Semaphore.ProducerConsumer.Semaphore;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        //Shared Object
        Queue<Object> queue = new ConcurrentLinkedQueue<>();

        //Create two Semaphore
        Semaphore producer = new Semaphore(2);// give access to producer first with capacity 5
        Semaphore consumer = new Semaphore(0); // Block consumer to execute unless producer notifies

        for (int i = 0; i < 5; i++) {
            Producer p = new Producer(queue, producer, consumer);
            Consumer c = new Consumer(queue, producer, consumer);
            Thread t1 = new Thread(p);
            t1.start();
            System.out.println(t1.getName() + " t1 started");
            Thread t2 = new Thread(c);
            t2.start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Final result " + queue.size());


    }
}
