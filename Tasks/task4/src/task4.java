import java.util.*;

public class task4 {
    public static void main(String[] args) {
        System.out.println("___task1___");
        System.out.println(nonRepeatable("abracadabra", "", 0));
        System.out.println(nonRepeatable("paparazzi", "", 0));
        System.out.println("___task2___");
        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));
        System.out.println("___task3___");
        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));
        System.out.println("___task4___");
        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("klmabzyxw"));
        System.out.println("___task5___");
        System.out.println(sortedString("aaabbcdd"));
        System.out.println(sortedString("vvvvaajaaaaa"));
        System.out.println("___task6___");
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));
        System.out.println("___task7___");
        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));
        System.out.println("___task8___");
        System.out.println(shortestWay(new int[][]{{1,3,1},{1,5,1},{4,5,1}}));
        System.out.println(shortestWay(new int[][]{{2,7,3},{1,4,8},{4,5,9}}));
        System.out.println("___task9___");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
        System.out.println("___task10___");
        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
    }

    public static String nonRepeatable(String s, String result, int elementsVisited) {
        String[] arr = s.split("");
        if (elementsVisited == s.length()) {
            return result;
        }
        if(!result.contains(arr[elementsVisited])) {
            result += arr[elementsVisited];
            elementsVisited++;
            nonRepeatable(s, result, elementsVisited);
        } else {
            elementsVisited++;
            nonRepeatable(s, result, elementsVisited);
        }
        return nonRepeatable(s, result, elementsVisited);
    }

    public static void generate(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count) {
        if (leftRem < 0 || rightRem < leftRem) return;

        if (leftRem == 0 && rightRem == 0) {
            String s = String.copyValueOf(str);
            list.add(s);
        } else {
            if (leftRem > 0) {
                str[count] = '(';
                generate(list, leftRem - 1, rightRem, str, count + 1);
            }

            if (rightRem > leftRem) {
                str[count] = ')';
                generate(list, leftRem, rightRem - 1, str, count + 1);
            }
        }
    }
    public static ArrayList<String> generateBrackets(int count) {
        char[] str = new char[count * 2];
        ArrayList<String> list = new ArrayList<>();
        generate(list, count, count, str, 0);
        return list;
    }

    public static ArrayList<String> binarySystem(int n) {
        String[] arr = new String[n-1];
        String[] temp = new String[(int)Math.pow(2,n)];
        arr[0] = "00";
        int count;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i-1] + "0";
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < (int)Math.pow(2,n); i++) {
            String binary = Integer.toString(i, 2);
            if (binary.length() < n) {
                while (binary.length() < n) {
                    binary = "0".concat(binary);
                }
            }
            temp[i] = binary;
        }
        for (int i = 0; i < temp.length; i++) {
            count = 0;
            for (int j = 0; j < arr.length; j++) {
                if(!temp[i].contains(arr[j])) {
                    count += 1;
                }

            }
            if (count == arr.length) {
                list.add(temp[i]);
            }
        }

        return list;
    }

    public static String alphabeticRow(String s) {
        String result = "";
        int ascii = 0;
        int maxLen =-1;
        String[] resultArr;
        for (int i = 0; i < s.length(); i++) {
            if (ascii == 0 || (int)s.charAt(i) - 1 == ascii || (int)s.charAt(i) + 1 == ascii) {
                result += s.charAt(i);
                ascii = s.charAt(i);
            } else {
                result += " ";
                result += s.charAt(i);
                ascii = s.charAt(i);
            }
        }
        resultArr = result.split(" ");
        for (String i : resultArr) {
            if (i.length() > maxLen) {
                maxLen = i.length();
                result = i;
            }
        }
        return result;
    }

    public static String sortedString(String s) {
        //"aaabbcdd"
        String result = "";
        int count = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                count += 1;
            } else {
                result += s.charAt(i) + Integer.toString(count);
                count = 1;
            }
        }
        char[] resultChar = (result + s.charAt(s.length()-1) + Integer.toString(count)).toCharArray();
        for (int i = 1; i < resultChar.length - 1; i += 2) {
            int min = i;
            for (int j = i; j < resultChar.length; j += 2) {
                if (resultChar[j] < resultChar[min]) {
                    min = j;
                }
            }
            char temp = resultChar[i];
            resultChar[i] = resultChar[min];
            resultChar[min] = temp;
            temp = resultChar[i - 1];
            resultChar[i - 1] = resultChar[min - 1];
            resultChar[min - 1] = temp;
        }
        return new String((resultChar));
    }

    public static int convertToNum(String s) {
        int result = 0;
        String[] arr = s.split(" ");
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
        "nineteen"};
        for (String string : arr) {
            switch (string) {
                case "hundred" -> result *= 100;
                case "twenty" -> result += 20;
                case "thirty" -> result += 30;
                case "forty" -> result += 40;
                case "fifty" -> result += 50;
                case "sixty" -> result += 60;
                case "seventy" -> result += 70;
                case "eighty" -> result += 80;
                case "ninety" -> result += 90;
            }
            for (int j = 0; j < numbers.length; j++) {
                if (string.equals(numbers[j])) result += j;
            }
        }
        return result;
    }

    public static String uniqueSubstring(String s) {
        String[] arr = s.split("");
        String temp = "";
        String result = "";
        int maxLen = -1;
        int[] countArr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            if (countArr[Integer.parseInt(arr[i])] == 0) {
                temp += arr[i];
                countArr[Integer.parseInt(arr[i])] =+ 1;
            } else {
                countArr = new int[10];
                temp += " " + arr[i];
                countArr[Integer.parseInt(arr[i])] =+ 1;
                }
        }
        for (String i : temp.split(" ")) {
            if (i.length() > maxLen) {
                maxLen = i.length();
                result = i;
            }
        }
        return result;
    }

    public static int shortestWay(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] arr = new int[rows][cols];

        arr[0][0] = matrix[0][0];
        for (int i = 1; i < cols; i++) {
            arr[0][i] = matrix[0][i] + arr[0][i - 1];
        }

        for (int i = 1; i < rows; i++) {
            arr[i][0] = matrix[i][0] + arr[i - 1][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                arr[i][j] = Math.min(arr[i - 1][j], arr[i][j - 1]) + matrix[i][j];
            }
        }
        return arr[rows - 1][cols - 1];
    }

    public static String numericOrder(String s) {
        String[] arr = s.split(" ");
        String[] numArr = new String[arr.length];
        String[] words = new String[arr.length];
        String[] resultArr = new String[arr.length];
        String resultStr = "";
        Arrays.fill(words, "");
        for (int i = 0; i < arr.length; i++) {
            String[] temp = arr[i].split("");
            for (int j = 0; j < temp.length; j++) {
                if (!Character.isDigit(temp[j].charAt(0))) {
                    words[i] += temp[j];
                } else {
                    numArr[i] = temp[j];
                }
            }
        }
        for (int i = 0; i < numArr.length; i++) {
            resultArr[Integer.parseInt(numArr[i])-1] = words[i];
        }
        for (String j : resultArr) resultStr += j + " ";
        return resultStr;
    }

    public static int switchNums(int num1, int num2) {
        String[] num1Arr = Integer.toString(num1).split("");
        String[] num2Arr = Integer.toString(num2).split("");
        String result = "";
        Arrays.sort(num1Arr, Comparator.reverseOrder());
        for (int i = 0; i < num1Arr.length; i++) {
            for (int j = 0; j < num2Arr.length; j++) {
                if (Integer.parseInt(num1Arr[i]) > Integer.parseInt(num2Arr[j])) {
                    num2Arr[j] = num1Arr[i];
                    break;
                }
            }
        }
        for (String i : num2Arr) {
            result += i;
        }
        return Integer.parseInt(result);
    }
}
