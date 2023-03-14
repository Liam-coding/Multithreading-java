package threadSignal;

public class MySignal {
    private boolean hasDataToProcess;

    public synchronized void setHasDataToProcess(boolean hasData) {
        this.hasDataToProcess = hasData;
    }

    public synchronized boolean isHasDataToProcess() {
        return this.hasDataToProcess;
    }
}
