package threadSignal.cancelAndClose;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class LogWriter {
    private static final int CAPACITY = 10;
    private final BlockingDeque<String> queue;
    private final LoggerThread logger;

    public LogWriter(Writer writer) {
        this.queue = new LinkedBlockingDeque<String>(CAPACITY);
        this.logger = new LoggerThread(writer);
    }

    private class LoggerThread extends Thread{
        private final PrintWriter writer;
        public LoggerThread(Writer writer) {
            this.writer = (PrintWriter)writer;
        }

        @Override
        public void run() {
            try {
                while (true){
                    writer.println(queue.take());
                }
            }catch (InterruptedException ignored){

            }finally {
                writer.close();
            }
        }
    }
}
