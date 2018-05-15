public class MultiPrint {
    public static void main(String[] args){
        //These are your runnables. Lets call these tasks
        Runnable taskOne = new PrintChar('a',100);
        Runnable taskTwo = new PrintChar('b',100);
        Runnable taskThree = new PrintNum(100);

        //The following are threads, threads can run runnable tasks
        Thread threadOne = new Thread(taskOne);
        Thread threadTwo = new Thread(taskTwo);
        Thread threadThree = new Thread(taskThree);

        //The threads must me told to start(). The start() method calls the run() method implemented in the tasks
        threadOne.start();
        threadTwo.start();
        threadThree.start();

        //I mean, this proves nothing other than you can run methods via threads. this example doesn't really leverage
        //the power of multithreading, its an example for the basics. Also, lets not forget that you need to individually
        //need to create threads for every task. That's garbage mane, super inefficient. Gotta use thread pools instead.
        //This keyboard sucks.
    }
}