package threadSignal.cancelAndClose;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class SampleThreadTest {
    @Test
    public void givenStartedThread_whenJoinCalled_waitsTillCompletion() throws InterruptedException {
        Thread t2 = new SampleThread(1);
        t2.start();
        System.out.println("Invoking join");
        t2.join(1000);
        System.out.println("Returned from join");
        assertFalse(t2.isAlive());
    }
}
