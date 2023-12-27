import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MaxMatrixElement {
    public static void main(String[] args) {
        int n = 4;
        ExecutorService executor = Executors.newFixedThreadPool(n);
        int[][] matrix = generateMatrix(4,4);
        int size = Math.max(n, matrix.length) / Math.min(n, matrix.length);
        System.out.println("size: " + size);

        for (int i = 0; i < matrix.length; i += size) {
            int start = i;
            int end = Math.min(i + size, matrix.length);


            Runnable task = new Runnable() {
                @Override
                public void run() {
                    for (int i = start; i < end; i++) {
                        for (int j = 0; j < matrix[i].length; j++) {
                            matrix[i][j] += 4;
                        }
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
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(max);
    }

    public static int[][] generateMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(100);
                //matrix[i][j] = 2;
            }
        }
        return matrix;
    }
}
