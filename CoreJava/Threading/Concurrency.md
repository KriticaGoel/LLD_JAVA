

## DATA SHARING BETWEEN THREAD

### Stack Memory Region

What is stack?
Memory region where
*     Methods are called
*     Arguments are passed
*     Local Variables are stored
Stack+instruction pointer = State of each thread's execution
![img.png](../resources/img.png)

![img_1.png](../resources/img_1.png)

**Stack Properties**
1. Each stack region belongs to a particular thread
2. All variables belong to the thread executed on that stack. other threads cannt access them.
3. Stack is allocated Statically when a thread is created,
4. Stack size is fixed and cannt change at run time
5. If memory hierarchy is too deep. We may get an Stackoverflow Exception. (Risky with recursive call)

### Heap Memory Region
* Shared memory region

What is allocated over heap?
* Objects-Anything created by new operator like String, Object, collections...
* Members of class

  ```
  class MyClass {
     MyObject memberObject; // Class member object reference

     MyClass() {
         memberObject = new MyObject(); // Initializing the member object
     }
  
     void myMethod() {
         MyObject localObject = new MyObject(); // Non-class member object reference
         // localObject can only be used within this method
     }
  }
* Static variables - these are class variables.

Heap Memory Management
* Managed by Garbage Collector
* Objects stay as long as we have one reference of them.
* Members of class exist as long as parent of class exists.
* Static Variables—Stay Forever.

**Reference Variables and Objects**
1.   Reference variables are stored in **STACK**
2.   Reference variable of class member stored in **HEAP**
3.   Objects always stored in **HEAP**

## Resource Sharing between Threads
What are resources?
* Variables
* Any Objects
* File or connection handles
* Data Structure
* Message queue

Why do we need to share resources?

Example text editor — one thread is handing an ui task and another thread is handling saving data at particular time.
Both threads have common (shared) file to work and that file is stored in any DS which is shared between two threds

Another common example is database—One db is shared by multiple thread to do read and write operations

What is the problem in shared resources?

Increment value and decrement same value.

    public class IncrementDecrement {

        public static void main(String[] args) throws InterruptedException {
            //constructor
            InventoryCounter inventoryCounter = new InventoryCounter();
            IncrementNumber inc = new IncrementNumber(inventoryCounter);
            DecrementNumber dec = new DecrementNumber(inventoryCounter);
    
            inc.start(); //start the thread
            inc.join();//finished the thread
            dec.start();//start the thread
            dec.join();//finished the thread
            System.out.println("Result of sequential threading "+inventoryCounter.getItems());
    
            InventoryCounter inventoryCounter1 = new InventoryCounter();
            IncrementNumber inc1 = new IncrementNumber(inventoryCounter1);
            DecrementNumber dec1 = new DecrementNumber(inventoryCounter1);
    
            inc1.start(); //start the thread
            dec1.start();//start the thread
            inc1.join();//finished the thread
            dec1.join();//finished the thread
    
            System.out.println("Result of multi threading "+inventoryCounter1.getItems());
    
        }
    
        public static class InventoryCounter {
            private int items = 0;
    
            public void increment() {
                items++;
            }
    
            public void decrement() {
                items--;
            }
    
            public int getItems() {
                return items;
            }
        }
    
        public static class IncrementNumber extends Thread{
    
            InventoryCounter increment;
            public IncrementNumber(InventoryCounter increment){
                this.increment = increment;
            }
    
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                increment.increment();}
            }
        }
    
        public static class DecrementNumber extends Thread{
    
            InventoryCounter increment;
            public DecrementNumber(InventoryCounter increment){
                this.increment = increment;
            }
    
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                increment.decrement();}
            }
        }
    }
Output:

Result of sequential threading 0
Result of multi threading 36

Problems:
1. Two thread sharing items counter
2. Both threads are reading and modifying the counter at the same time.
3. Operations are not atomic.


**Atomic Operations**
* Appears at once.
* Single step operation—all or nothing
* No intermediate states

items++ is not atomic since have multiple steps involved in it
1. read current value
2. increment modify value
3. store modified value back to variable.


# Concurrency Challenges and Solutions
Below is the condition that causes synchronization problem:
1. critical section — In case of no atomic operations, one thread can enter into a critical section, and another thread needs to wait until the first thread crosses the critical section.
   By this way we can maintain the concurrency
2. Race condition:
   1. Condition when multiple threads are accessing a shared resource.
   2. At least one thread is modifying the resource.
   3. the timing of thread scheduling may cause an incorrect result.
   4. The core problem is non-atomic operations performed on shared resource.

3. Preemption—if thread in a critical section and cpu pause(preempted) the thread and start the another thread to work on critical section. In this case also results get wrong
   **Critical Section**
   In case of no atomic operations, one thread can enter into a critical section, and another thread needs to wait until the first thread crosses the critical section.
   By this way we can maintain the concurrency


Problems in the above code are as follows:
1. Two thread sharing items counter
2. Both threads are reading and modifying the counter at the same time.
3. Operations are not atomic.

Solutions in Java
1. Java provide locking mechanism
2. Used to restrict the entire section or critical section to single thread at a time.


Solutions 1: **Mutex**
Lock the critical section
`Lock lock= new ReenteredLcok();`
pass this lock to a critical section

    public class Mutex {
        public static void main(String[] args) throws InterruptedException {
            //constructor
            InventoryCounter inventoryCounter = new InventoryCounter();
            Lock lock = new ReentrantLock();
            IncrementNumber inc = new IncrementNumber(inventoryCounter,lock);
            DecrementNumber dec = new DecrementNumber(inventoryCounter,lock);
    
            inc.start(); //start the thread
            dec.start();//start the thread
            inc.join();//finished the thread
            dec.join();//finished the thread
            System.out.println("Result of Mutex threading "+inventoryCounter.getItems());
        }
    
        public static class InventoryCounter {
            private int items = 0;
    
            public void increment() {
                items++;
            }
    
            public void decrement() {
                items--;
            }
    
            public int getItems() {
                return items;
            }
        }
    
        public static class IncrementNumber extends Thread{
    
            InventoryCounter increment;
            Lock lock;
            public IncrementNumber(InventoryCounter increment,Lock lock){
                this.increment = increment;
                this.lock = lock;
            }
    
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    lock.lock();
                increment.increment();
                lock.unlock();}
            }
        }
    
        public static class DecrementNumber extends Thread{
    
            InventoryCounter increment;
            Lock lock;
            public DecrementNumber(InventoryCounter increment,Lock lock){
                this.increment = increment;
                this.lock = lock;
            }
    
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    lock.lock();
                increment.decrement();
                lock.unlock();}
            }
        }
    }
Problem:
1. If developer forget to unlock the object
2. If code throws error and object not unlocked properly
3. Always need to put unlock in final block so that it will execute always. that means we nee try  and final block in this scenario.

Solutions 2: **Synchronized**

There are two ways to use Synchronized Keyword
1. **Synchronized - Monitor**
   One or more methods of a class using synchronized
   ![objectLock.png](..%2Fresources%2FobjectLock.png)
   ```
   public class ABC{
        public synchronized method1(){
        .....
        }

        public synchronized method2(){
        .....
        }
    }
Problem:
If thread A accessing method 1 then thread B cannt access any method of that class as both methods are locked.

    public class Monitor {

        public static void main(String[] args) throws InterruptedException {
            //constructor
            InventoryCounter inventoryCounter = new InventoryCounter();
            IncrementNumber inc = new IncrementNumber(inventoryCounter);
            DecrementNumber dec = new DecrementNumber(inventoryCounter);
    
            inc.start(); //start the thread
            dec.start();//start the thread
            inc.join();//finished the thread
            dec.join();//finished the thread
            System.out.println("Result of Mutiple threading in sychronized way "+inventoryCounter.getItems());
    
    
        }
    
        public static class InventoryCounter {
            private int items = 0;
    
            public synchronized void increment() {
                items++;
            }
    
            public synchronized void decrement() {
                items--;
            }
    
            public synchronized int getItems() {
                return items;
            }
        }
    
        public static class IncrementNumber extends Thread{
    
            InventoryCounter increment;
            public IncrementNumber(InventoryCounter increment){
                this.increment = increment;
            }
    
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                increment.increment();}
            }
        }
    
        public static class DecrementNumber extends Thread{
    
            InventoryCounter increment;
            public DecrementNumber(InventoryCounter increment){
                this.increment = increment;
            }
    
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                increment.decrement();}
            }
        }
    }

2. **Synchronized-Lock**
   Lock the critical section not complete method.

   Advantage:
    1. Two threads can access two different methods having a critical section without blocking all methods which we are doing in the previous case.
    2. We are locking critical code only rest code can be accessed by muti threads
    3. Increase performance.
       ![2.jpg](..%2Fresources%2F2.jpg)![3.jpg](..%2Fresources%2F3.jpg)
       Syntax:


    Object lockingObject = new Object();
    public void method{
        .....
        ......
        synchronized(lockingObject){
        //critical section
        }
        ....
        ....
    }

package CoreJava.Threading.ResourceSharing;

    public class Lock {

        public static void main(String[] args) throws InterruptedException {
            //constructor
            InventoryCounter inventoryCounter = new InventoryCounter();
            IncrementNumber inc = new IncrementNumber(inventoryCounter);
            DecrementNumber dec = new DecrementNumber(inventoryCounter);
    
            inc.start(); //start the thread
            dec.start();//start the thread
            inc.join();//finished the thread
            dec.join();//finished the thread
            System.out.println("Result of Mutiple threading in sychronized way "+inventoryCounter.getItems());
    
    
        }
    
        public static class InventoryCounter {
            private int items = 0;
    
            Object lock = new Object();
            public  void increment() {
                System.out.println("Incrementing");
                synchronized (lock) {items++;}
    
            }
    
            public  void decrement() {
                System.out.println("Decrementing");
                synchronized (lock) {items--;}
            }
    
            public  int getItems() {
                return items;
            }
        }
    
        public static class IncrementNumber extends Thread{
    
            InventoryCounter increment;
            public IncrementNumber(InventoryCounter increment){
                this.increment = increment;
            }
    
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                increment.increment();}
            }
        }
    
        public static class DecrementNumber extends Thread{
    
            InventoryCounter increment;
            public DecrementNumber(InventoryCounter increment){
                this.increment = increment;
            }
    
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                increment.decrement();}
            }
        }
    }
![img.png](../resources/objectLock.png)

**Atomic Operations**
1. All assignments are atomic.
2. All getters and setters are atomic. Since we are assigning values only.
3. All primitive types are atomic except double and long.
4. Double and long also became atomic after declaring a volatile keyword
   volatile double x=1.0;
5. We have Atomic Datatype like Atomic Integer. that means operation happend on this function are atomic in nature and much faster
 `  AtomicInteger counter = new AtomicInteger(0);

public void increment() {
counter.incrementAndGet();
}
`
6. Atomic use case Implement Metric


    public class Atomic {

        public static void main(String[] args) {
            Metric metric = new Metric();
            BusinessLogic businessLogic = new BusinessLogic(metric);
            BusinessLogic businessLogic2 = new BusinessLogic(metric);
            MetricPrinter metricPrinter = new MetricPrinter(metric);
    
            businessLogic.start();
            businessLogic2.start();
            metricPrinter.start();
        }
    
        public static class MetricPrinter extends Thread {
            Metric metric;
    
            public MetricPrinter(Metric metric){
                this.metric = metric;
            }
    
            @Override
            public void run() {
             while(true){
                 System.out.println(metric.getAverage());
             }
            }
    
        }
    
        public static class BusinessLogic extends Thread {
            Metric metric;
            Random random= new Random();
    
            public BusinessLogic(Metric metric) {
                this.metric=metric;
            }
    
            @Override
            public void run() {
                while (true) {
                    long startTime = System.currentTimeMillis();
                    try {
                        Thread.sleep(random.nextInt(1000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    long endTime = System.currentTimeMillis();
                    metric.addSample(endTime - startTime);
                }
            }
        }
    
    
        public static class Metric {
            private volatile long count=0;
            private volatile double average=0.0;
    
            public synchronized void addSample(long sample){
                double currentSample= average*count;
                count++;
                average=(currentSample+sample)/count;
            }
    
            public double getAverage(){
                return average;
            }
    
    
        }
    }

Use case
A stock trading application that keeps track of the minimum and maximum price of the stock daily.


**Data Race**


    public class DataRace {

        public static void main(String[] args) {
           RaceCondition raceCondition = new RaceCondition();
           Thread th = new Thread(() -> {
               for(int i=0;i<Integer.MAX_VALUE;i++){
                   raceCondition.increment();
               }
           });
    
           Thread th1 = new Thread(() -> {
               for(int i=0;i<Integer.MAX_VALUE;i++){
                   raceCondition.checkForDataRace();
               }
           });
    
           th.start();
           th1.start();
    
        }
    
        public static class RaceCondition{
            private int x=0;
            private int y=0;
    
            public void increment(){
                x++;
                y++;
            }
    
            public void checkForDataRace(){
                if(y>x){
                    System.out.println("Data Race condition exists x="+x+" y="+y);
                }
            }
        }
    }
