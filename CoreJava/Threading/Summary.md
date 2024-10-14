#### Summary:

### Thread fundamental

#### Thread Creation

#### Thread Termination

#### Join
* Don't rely on the order of execution
* Always use thread coordination.
* Design code for a worst case scenario
* Thread may take an unreasonably long time.
* Always use Thred.join() with time limit.
* Stop the thread if it's not done in time.

#### Daemon Thread

### Performance Optimization

####   Latency

####   Throughput

### Data Sharing between Threads

####   Stack and Heap Region
* Primitives and references stored on stack which is not shared
* Objects, class member, static variables and class level reference stored on Heap which is shareable.



### The Concurrency Challenges and Solutions
####   Resources Sharing and critical section
* Benefits of resource sharing
* Challenge of multithreading operation
* Issue with non-atomic operation running on different thread.

#### Critical Section and Synchronized
* Definition of a concurrency problem
* How to identify the code that runs atomically and declare that code/section as critical section
* Synchronized keyword to protect a critical section
* Two ways to use Synchronized keyword
    1. Simple way (in front of method)
    2. On an explicit object.

#### Atomic Operations, Volatile and Metrics
* Atomic Operations
   1. Assignments of a primitive type (excluding long and double)
   2. Assignments of references
   3. Assignments of long and double using VOLATILE keyword
* Metric Capturing use case
* Race Condition and Data Race
* **Synchronized** keyword and **volatile** keyword
* Every shared variable should be either
  * Guarded via synchronized block or
  * Declare volatile
* Synchronized solves both problem race condition and Data race but has a performance penalty
* Volatile solved race condition for double and long data type and in case of data race its guaranteeing order

#### Locking and Deadlock
Locking Strategy
  Coarse-grained Locking — One lock on everything. Like synchronized method
  Fine-Grained Locking — Lock each block differently. It introduces deadlock condition.
Deadlock
  Solved by avoiding circular wait and hold
  Lock the resources in the same order, everywhere
 

