import java.util.Arrays;

public class ArrayAverage {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;
        try {
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i+1];
            }
            sum = sum / arr.length;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An error has occurred");
        } finally {
            System.out.println(Arrays.toString(arr));
            System.out.println(sum);
        }
    }
}
