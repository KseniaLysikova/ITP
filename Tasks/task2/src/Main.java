import java.util.Arrays;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        System.out.println("___task_1___");
        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));
        System.out.println("___task_2___");
        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));
        System.out.println("___task_3___");
        int[] arr = {44, 32, 86, 19};
        System.out.println(differenceEvenOdd(arr));
        int[] arr1 = {22, 50, 16, 63, 31, 55};
        System.out.println(differenceEvenOdd(arr1));
        System.out.println("___task_4___");
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(equalToAvg(numbers));
        int[] numbers1 = {1, 2, 3, 4, 6};
        System.out.println(equalToAvg(numbers1));
        System.out.println("___task_5___");
        int[] numberArr = {1, 2, 3};
        int[] numberArr1 = {3, 3, -2, 408, 3, 31};
        System.out.println(Arrays.toString(indexMult(numberArr)));
        System.out.println(Arrays.toString(indexMult(numberArr1)));
        System.out.println("___task_6___");
        System.out.println(reverse("Hello world"));
        System.out.println(reverse("The quick brown fox."));
        System.out.println("___task_7___");
        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));
        System.out.println("___task_8___");
        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));
        System.out.println("___task_9___");
        System.out.println(botHelper("Hello, I’m under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));
        System.out.println(botHelper("help"));
        System.out.println("___task_10___");
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));
    }

    public static String duplicateChars (String word) {
        word = word.toLowerCase();
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j < word.length(); j++) {
                if (word.charAt(i) == word.charAt(j)) {
                    count += 1;
                }
            }
        }
        if (count > 0) return "true";
        else return "false";
    }

    public static String getInitials(String name) {
        String[] arrayName = name.split(" ");
        return arrayName[0].substring(0,1) + arrayName[1].substring(0,1);
    }

    public static int differenceEvenOdd(int[] args) {
        int evenSum = 0, oddSum = 0;
        for (int i = 0; i < args.length; i++) {
            if (args[i] % 2 == 0) evenSum += args[i];
            else oddSum += args[i];
        }
        return Math.abs(evenSum - oddSum);
    }

    public static boolean equalToAvg(int[] numbers) {
        double avg;
        double sum = 0;
        boolean result = false;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        avg = sum / numbers.length;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == avg) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static int[] indexMult(int[] args) {
        for (int i = 0; i < args.length; i++) {
            args[i] *= i;
        }
        return args;
    }

    public static String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    public static int Tribonacci(int num) {
        if (num <= 2) {
            return 0;
        } else if (num == 3) {
            return 1;
        } else {
            return Tribonacci(num - 1) + Tribonacci(num - 2) +Tribonacci(num - 3);
        }
    }

    public static String pseudoHash(int length) {
        String[] charArr = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        Random r = new Random();
        String result = "";
        for (int i = 0; i < length; i++) {
            int j = r.nextInt(charArr.length);
            result += charArr[j];
        }
        return result;
    }

    public static String botHelper(String sentence) {
        sentence = sentence.toLowerCase();
        String[] sentenceArr = sentence.split(" ");
        for (int i = 0; i < sentenceArr.length; i++) {
            if (sentenceArr[i].equals("help")) {
                return "Calling for a staff member";
            }
        }
        return "Keep waiting";
    }

    public static boolean isAnagram (String firstWord, String secondWord) {
        String[] secondArr = secondWord.split("");
        int count = 0;
        for (String i : secondArr) {
            if (firstWord.contains(i)) {
                count += 1;
            }
        }
        return count == firstWord.length();
    }
}