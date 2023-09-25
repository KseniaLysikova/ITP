public class task3 {
    public static void main(String[] args) {
        System.out.println("---task1---");
        System.out.println(replaceVovels("apple"));
        System.out.println(replaceVovels("Even if you did this task not by yourself, " +
                "you have to understand every single line of code."));
        System.out.println("---task2---");
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));
        System.out.println("---task3---");
        System.out.println("---task4---");
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        System.out.println("---task5---");
        int[] arr = {1, -3, 2};
        int[] arr1 = {2, 5, 2};
        int[] arr2 = {1, -6, 9};
        System.out.println(countRoots(arr));
        System.out.println(countRoots(arr1));
        System.out.println(countRoots(arr2));
    }

    public static String replaceVovels(String word) {
        word = word.toLowerCase();
        String[] arrWord = word.split("");
        String[] vowels = {"a", "e", "i", "o", "u", "y"};
        for (int i = 0; i < arrWord.length; i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (arrWord[i].equals(vowels[j])) {
                    word = word.replace(arrWord[i], "*");
                }
            }
        }
        return word;
    }

    public static String stringTransform(String word) {
        word = word.toLowerCase();
        String[] arrWord = word.split("");
        for (int i = 0; i < arrWord.length; i++) {
            for (int j = i+1; j < arrWord.length - 1; j++) {
                if (arrWord[i].equals(arrWord[j])) {
                    word = word.replace((arrWord[i]+arrWord[j]), "Double"+arrWord[i].toUpperCase());
                }
            }
        }
        return word;
    }

    public static boolean numCheck(int num) {
        String number = String.valueOf(num);
        String[] arrNum = number.split("");
        int sum = 0;
        for (int i = 0; i < arrNum.length; i++) {
            sum += Math.pow(Integer.valueOf(arrNum[i]), 2);
        }
        if (sum % 2 == num % 2) return true;
        else return false;
    }

    public static int countRoots(int[] numArr) {
        double D = Math.pow(numArr[1], 2) - 4*numArr[0]*numArr[2];
        if (D > 0) return 2;
        else if (D == 0) return 1;
        else return 0;
    }
}
