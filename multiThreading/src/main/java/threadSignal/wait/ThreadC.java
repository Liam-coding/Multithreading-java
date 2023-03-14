package threadSignal.wait;

public class ThreadC extends Thread {
    MonitorObject mySignal;
    ThreadD threadD;

    public ThreadC(MonitorObject mySignal, ThreadD threadD) {
        this.mySignal = mySignal;
        this.threadD = threadD;
    }

    @Override
    public void run() {
        synchronized (mySignal) {
            try {
                System.out.println("mySignal is wait...");
                mySignal.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("execute result is " + threadD.count);
        }
    }

    public static void main(String[] args) {
        MonitorObject mySignal = new MonitorObject();
        ThreadD threadD = new ThreadD(mySignal);
        ThreadC threadC = new ThreadC(mySignal,threadD);
        threadC.start();
        threadD.start();
    }
}
