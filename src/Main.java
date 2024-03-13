import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int countersThreadsAmount = 2;
        ThreadStopper threadStopper = new ThreadStopper(4000);
        Random random = new Random();
        for (int i = 0; i < countersThreadsAmount; i++) {
            new SumCounter(i, random.nextInt(1, 26), threadStopper);
        }
        threadStopper.run();
    }
}