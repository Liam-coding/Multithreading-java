package threadSignal;

public class ThreadB extends Thread {
    int count;
    MySignal mySignal;

    public ThreadB(MySignal mySignal) {
        this.mySignal = mySignal;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            count = count + 1;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mySignal.setHasDataToProcess(true);
    }
}
