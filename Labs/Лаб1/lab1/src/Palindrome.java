public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            System.out.println(isPalindrome(s));
        }
    }

    public static String reverseString(String s) {
        String arg = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            arg += s.charAt(i);
        }
        return arg;
    }

    public static boolean isPalindrome(String s) {
        String revS = reverseString(s);
        return s.equals(revS);
    }
}
