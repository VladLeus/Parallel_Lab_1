public class ThreadStopper implements Runnable {
    private boolean canStop = false;
    private final int delay;

    public ThreadStopper(int delay) {
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        canStop = true;

    }

    public boolean isCanStop() {
        return canStop;
    }
}
