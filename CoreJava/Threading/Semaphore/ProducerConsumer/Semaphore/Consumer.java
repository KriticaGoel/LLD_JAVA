package CoreJava.Threading.Semaphore.ProducerConsumer.Semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {

    private Queue<Object> sharedDrive;
    private Semaphore producer;
    private Semaphore consumer;

    Consumer(Queue<Object> sharedDrive, Semaphore producer, Semaphore consumer) {
        this.sharedDrive = sharedDrive;
        this.producer = producer;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + ": Consumer going to start " + consumer.availablePermits());
            consumer.acquire();
            System.out.println(Thread.currentThread().getName() + ": Consumer started " + consumer.availablePermits());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sharedDrive.remove();
        //notify producer to continue the task
        System.out.println(Thread.currentThread().getName() + ": Consumer going to released producer " + producer.availablePermits());
        producer.release();
        System.out.println(Thread.currentThread().getName() + ": producer count " + producer.availablePermits());
    }
}
