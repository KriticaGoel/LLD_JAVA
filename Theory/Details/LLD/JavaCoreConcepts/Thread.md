# Threads and Multithreading
- [Threads and Multithreading](#threads-and-multithreading)
    - [Threads](#threads)
        - [Thread vs Process](#thread-vs-process)
        - [Concurrency vs Parallelism](#concurrency-vs-parallelism)
        - [Using threads in Java](#using-threads-in-java)
            - [Number printer](#number-printer)
    - [Executor](#executor)
    - [Callable and Future](#callable-and-future)
    - [Assignment](#assignment)
    - [Reading List](#reading-list)

## Threads

> A thread is a lightweight process. It is a unit of execution within a process. A process can have multiple threads. Each thread has its own program counter, stack, and registers. Threads share the same address space. This means that all threads in a process can access the same memory. This is different from processes where each process has its own address space.

Often, a process needs to perform multiple tasks at the same time. For example, a web browser needs to download a file
and display a web page at the same time. Creating a new process for each task is expensive. This is because creating a
new process requires a lot of Theory.resources.

Threads are used to solve this problem. Threads are used to perform multiple tasks within a process. This is done by sharing the same address space. This means that all threads in a process can access the same memory. This is different from processes where each process has its own address space.

Thread is a sequential flow of tasks within a process. Threads in OS can be of the same or different types. Threads are used to increase the performance of the applications.
Each thread has its own program counter, stack, and set of registers. But the threads of a single process might share
the same code and data/file. Threads are also termed as lightweight processes as they share common Theory.resources.
![Thread.PNG](..%2F..%2Fresources%2FThread.PNG)
### Thread vs Process
| Process                                                                                 | Thread                                                                                                     |
|-----------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|
| Processes use more Theory.resources and hence they are termed as heavyweight processes. | Threads share Theory.resources and hence they are termed as lightweight processes.                         |
| Creation and termination times of processes are slower.                                 | Creation and termination times of threads are faster compared to processes.                                |
| Processes have their own code and data/file.                                            | Threads share code and data/file within a process.                                                         |
| Communication between processes is slower.                                              | Communication between threads is faster.                                                                   |
| Context Switching in processes is slower.                                               | Context switching in threads is faster.                                                                    |
| Processes are independent of each other.                                                | Threads, on the other hand, are interdependent. (i.e they can read, write or change another thread’s data) |
| Eg: Opening two different browsers.                                                     | Eg: Opening two tabs in the same browser.                                                                  
![threadProcess.PNG](..%2F..%2Fresources%2FthreadProcess.PNG)

### Concurrency vs Parallelism

* Concurrent - At the same time, **but not necessarily at the same instant**. It is possible for multiple threads to be at different stages of execution at the same time **but not being processed together**. A single core CPU can only execute one thread at a time. But it can switch between threads very quickly. This is called context switching. This is how concurrency is achieved. A single core CPU can have concurrency but not parallelism.
* Parallel - At the same time and **at the same instant**. It is possible for multiple threads to be at different stages of execution at the same time and **being processed together**. A single core CPU cannot achieve parallelism. It can only achieve concurrency. A multi-core CPU can achieve both concurrency and parallelism.



###  Context Switching

**Definition**: Context switching refers to the process of storing the state of a currently running thread or process, so that it can be resumed later, and restoring the state of the next thread or process to run.

**Cost Implications**: It is generally more expensive to switch between threads of different processes (inter-process switching) than between threads of the same process (intra-process switching). This is because switching between different processes requires additional overhead, such as switching memory contexts.

### Multithreading Implementation

1. Implementing Runnable Interface

```java
public class MyRunnable implements Runnable {
 public void run() {
     // Code to be executed by this thread
 }
}
```
2. Extending Thread Class
```java
public class MyThread extends Thread {
    public void run() {
        // Code to be executed by this thread
    }
}
```

**Case Study**

You can create a simple simulation of a system with a username and password, where a hacker thread attempts to break it, and simultaneously, a police thread tries to arrive within 10 seconds.
```java
public class SecuritySystem {
    private static String correctUsername = "admin";
    private static String correctPassword = "password";
    private volatile boolean hacked = false;

    public static void main(String[] args) {
        SecuritySystem system = new SecuritySystem();
        Thread hacker = new Thread(system.new Hacker());
        Thread police = new Thread(system.new Police());

        hacker.start();
        police.start();
    }

    class Hacker implements Runnable {
        public void run() {
            try {
                for (int i = 0; i < 100 && !hacked; i++) {
                    // Simulate guessing username/password
                    Thread.sleep(100); // Simulating time taken to guess
                    if (guessCredentials()) {
                        hacked = true;
                        System.out.println("Hacker broke the system!");
                    }
                }
            } catch (InterruptedException e) {
                // Handle interruption
            }
        }

        private boolean guessCredentials() {
            // Simulation logic to guess credentials; returns true if successful
            return Math.random() < 0.01; // 1% chance of success
        }
    }

    class Police implements Runnable {
        public void run() {
            try {
                for (int i = 10; i > 0; i--) {
                    System.out.println("Police arriving in " + i + " seconds...");
                    Thread.sleep(1000); // Sleep for 1 second
                }
                if (!hacked) {
                    System.out.println("Police arrived! System protected successfully.");
                }
            } catch (InterruptedException e) {
                // Handle interruption
            }
        }
    }
}
```

**Interrupt**
Thread A can interrupt thread B, or we can stop long-running thread through interrupt

To check whether anyone called thread to interrupt
**if(Thread.currentThread().isInterrupted()){}**

**Damon Thread**
Background threads that do not prevent the application from existing if the main thread terminates

When to use Damon Thread

1.Background task that should not block our application to terminate. For Example File saving in text editor
2.Code in worker thread is not in our control, and we don't want it to block our applcoation from terminate. For example Third part libraries.

**Join Thread / Thread coordination**
Make sure dependent thread completes the work before another thread starts

Implementation

1. Result print in FactorialThread
2. How to read variable of threaded class in another class using thread
   FactorialThread factorial = (FactorialThread) threads.get(i);
3. Implement isFinished to print value if finished
  **Problem**: this introduces race condition since start method starting thread and finished method trying to print as soon as possible
4. To remove race condition, we added join
    thread.join() this makes thread dependent on each other.
    **Problem**: if one thread is taking more than expected time, then the main thread will keep on waiting
5. How long we are willing to wait for each thread to complete the task
     thread.join(2000);//time is in milliseconds
