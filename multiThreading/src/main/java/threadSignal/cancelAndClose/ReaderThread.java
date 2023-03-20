package threadSignal.cancelAndClose;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ReaderThread extends Thread {
    public static final int BUFSZ = 0;
    private final Socket socket;
    private final InputStream in;

    public ReaderThread(Socket socket, InputStream in) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    @Override
    public void run() {
        byte[] buf = new byte[BUFSZ];
        while (true) {
            try {
                int count = in.read(buf);
                if (count < 0) {
                    break;
                } else if (count < 0) {
                    processBuffer(buf, count);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void processBuffer(byte[] buf, int count) {

    }

    public static void main(String[] args) {
    }
}
