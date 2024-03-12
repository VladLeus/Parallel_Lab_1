public class SumCounter extends Thread {
    private final int id;
    private final int step;

    private final ThreadStopper threadStopper;
    private int sum = 0;

    public SumCounter(int id, int step, ThreadStopper threadStopper) {
        this.id = id;
        this.step = step;
        this.threadStopper = threadStopper;
        this.start();
    }


    @Override
    public void run() {
        try {
            while (!threadStopper.isCanStop()) {
                Thread.sleep(1000);
                this.sum += step;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread: " + this.id + ", returned sum: " + this.sum);
    }

}
