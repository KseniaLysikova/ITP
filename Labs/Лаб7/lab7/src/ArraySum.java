import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ArraySum {
    public static void main(String[] args) {
        int n = 4;
        ExecutorService executor = Executors.newFixedThreadPool(n);
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int size = data.length / n;
        int result = 0;

        for (int i = 0; i < data.length; i += size) {
            int start = i;
            int end = Math.min(i + size, data.length);

            Runnable task = new Runnable() {
                @Override
                public void run() {
                    for (int j = start; j < end; j++) {
                        data[j] *= 3;
                    }
                }
            };
            executor.execute(task);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        for (int value : data) {
            result += value;
            System.out.println(value);
        }
        System.out.println(result);
    }
}
