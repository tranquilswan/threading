public class MultiPrint {
    public static void main(String[] args){
        //These are your runnables. Lets call these tasks
        Runnable printLetterOne = new PrintChar('a',100);
        Runnable printLetterTwo = new PrintChar('b',100);
        Runnable printNumbers = new PrintNum(100);

        //The following are threads, threads can run runnable tasks
        Thread threadOne = new Thread(printLetterOne);
        Thread threadTwo = new Thread(printLetterTwo);
        Thread threadThree = new Thread(printNumbers);

        //The threads must me told to start(). The start() method calls the run() method implemented in the tasks
        threadOne.start();
        threadTwo.start();
        threadThree.start();

    }
}

class PrintChar implements Runnable{
    //Your "task class" needs to be implement runnable so a thread can run it.
    //Though it should be noted that Thread class also implements runnable

    long clockStart = System.currentTimeMillis();
    private char charToPrint;
    private int times;

    public PrintChar(char c, int t){
        this.charToPrint = c;
        this.times = t;
    }

    @Override
    public void run(){
        for(int i = 0; i<this.times; i++){
            System.out.print(this.charToPrint);
        }
    }



}

class PrintNum implements Runnable{
    private int lastNum;

    public PrintNum(int lastNum){
        this.lastNum = lastNum;
    }

    //everytime you implement runnable, you must override run() method
    @Override
    public void run() {
        for(int i = 1; i <= this.lastNum;i++){
            System.out.print(" " + i);
        }
    }
}