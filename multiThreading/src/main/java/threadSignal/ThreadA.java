package threadSignal;

public class ThreadA extends Thread {
    MySignal mySignal;
    ThreadB threadB;

    public ThreadA(MySignal mySignal, ThreadB threadB) {
        this.mySignal = mySignal;
        this.threadB = threadB;
    }

    //In here, just a foolish wait, it will still use cpu resource. The cost is wasteful.
    @Override
    public void run() {
        while (true) {
            System.out.println("ThreadA is running...");
            if (mySignal.isHasDataToProcess()){
                System.out.println("ThreadB count:"+threadB.count);
                break;
            }
        }
    }

    public static void main(String[] args) {
        MySignal mySignal = new MySignal();
        ThreadB threadB = new ThreadB(mySignal);
        ThreadA threadA = new ThreadA(mySignal,threadB);
        threadB.start();
        threadA.start();
    }
}
