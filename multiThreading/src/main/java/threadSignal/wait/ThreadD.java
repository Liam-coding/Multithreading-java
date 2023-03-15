package threadSignal.wait;

public class ThreadD extends Thread{
    int count;
    MonitorObject mySignal;

    public ThreadD(MonitorObject mySignal){
        this.mySignal = mySignal;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            count = count + 1;
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (mySignal){
            System.out.println("Thread D is end. mySignal is notifying...");
            mySignal.notifyAll();
        }
    }
}
