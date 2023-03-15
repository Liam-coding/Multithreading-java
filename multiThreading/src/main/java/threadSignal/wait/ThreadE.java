package threadSignal.wait;

public class ThreadE extends Thread {
    int count;
    MonitorObject mySignal;

    public ThreadE(MonitorObject mySignal) {
        this.mySignal = mySignal;
    }

    @Override
    public void run() {
        synchronized (mySignal) {
            try {
                System.out.println("Thread E mySignal is wait...");
                mySignal.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("threadE time is :" + System.currentTimeMillis());
        }
    }
}
