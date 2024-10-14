package CoreJava.Threading.Semaphore.ProducerConsumer.Semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private Queue<Object> sharedDrive;
    private Semaphore producer;
    private Semaphore consumer;

    Producer(Queue<Object> sharedDrive, Semaphore producer, Semaphore consumer) {
        this.sharedDrive = sharedDrive;
        this.producer = producer;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + ": Producer going to start " + producer.availablePermits());
            producer.acquire();
            System.out.println(Thread.currentThread().getName() + ": Producer started " + producer.availablePermits());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sharedDrive.add(new Object());
        //notify consumer to continue the task
        System.out.println(Thread.currentThread().getName() + ": Producer going to released consumer " + consumer.availablePermits());
        consumer.release();
        System.out.println(Thread.currentThread().getName() + ": Consumer count " + consumer.availablePermits());
    }
}
