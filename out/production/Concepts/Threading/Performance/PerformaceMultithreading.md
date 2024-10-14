**Performance of Multithreading**

**Latency** - The time of competition of a task. Measure in time units

**Throughput** - The amount of task completed in a given period. Measure in task/time unit

***Latency***-

**How to achieve Latency**- 

* Divide the task into independent subtasks.
* Schedule them in parallel, ensuring N is less than or equal to the number of cores available.
* Assume all subtasks are independent (no blocking, no sleeping).

**Cost of parallelization and Aggregation**

Consider the following costs when parallelizing tasks:

* Breaking a task into subtask
* Thread creation and passing tasks to thread
* Time required for scheduling threads
* Completion signaling and waiting for all threads to finish
* Time for the aggregation thread to run (get signals and scheduling)
* Aggregating sub-results into a single artifact

**Classification of task**

Type 1: **Parallelize Task**—Tasks that can be easily broken into independent subtasks.

Type 2: **Unbreakable, Sequential Task** - Tasks that must run in sequence and cannot be parallelized.

Type 3: **Partially parallelizable, partially sequential** — Tasks that can benefit from both parallel and sequential execution.

