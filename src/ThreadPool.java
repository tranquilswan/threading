import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args){

        //Define a threadPool with fixed number of threads. If the number of threads is less then the number of tasks
        //that need to be executed, then the execution will be sequential
        ExecutorService executor = Executors.newFixedThreadPool(3);

        //when using a new CachedThreadPool, the tasks will execute concurrently
//        ExecutorService executor = Executors.newCachedThreadPool();

        //add runnable tasks to the the pool
        executor.execute(new PrintChar('c',100));
        executor.execute(new PrintChar('d',100));
        executor.execute(new PrintNum(100));

        //must explicitly show the executor down or it will keep running.
        executor.shutdown();

        //basically a thread pool allows us to have the uses of Threads sans the management. We don't have to create
        //individual threads and assign tasks to individual ones.
    }
}
