public class PrintChar implements Runnable{
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