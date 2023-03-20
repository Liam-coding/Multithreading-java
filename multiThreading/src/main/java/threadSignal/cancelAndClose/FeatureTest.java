package threadSignal.cancelAndClose;

import java.util.concurrent.*;

public class FeatureTest {
    private final static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 10, 10L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(2));

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("I am running...");
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            throw new RuntimeException("this is a exception I was created");
        };

        timeRun(runnable,2,TimeUnit.SECONDS);
        //一定记得shutdown
        threadPoolExecutor.shutdown();
    }

    public static void timeRun(Runnable r, long timeout, TimeUnit unit) {
        Future<?> task = threadPoolExecutor.submit(r);
        try {
            task.get(timeout, unit);
        } catch (ExecutionException e) {
            //如果再任务中抛出了异常,那么将重新抛出该异常
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            System.out.println("timeout...");
            //接下来任务将要被取消
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            //如果任务成功地结束,那么取消操作也不会带来任何影响
            task.cancel(true);
        }
    }
}
