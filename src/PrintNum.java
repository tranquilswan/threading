public class PrintNum implements Runnable{
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