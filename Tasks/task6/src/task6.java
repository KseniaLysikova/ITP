import java.util.*;
import java.util.regex.Pattern;

public class task6 {
    public static void main(String[] args) {
        System.out.println("___task1___");
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.",
                "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor",
                "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title",
                "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));
        System.out.println("___task2___");
        System.out.println(collect("intercontinentalisationalism", 6));
        System.out.println(collect("strengths", 3));
        System.out.println(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15));
        System.out.println("___task3___");
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));
        System.out.println("___task4___");
        System.out.println(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15}, 45));
        System.out.println(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45));
        System.out.println(twoProduct(new int[]{1, 2, -1, 4, 5, 6, 10, 7}, 20));
        System.out.println(twoProduct(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10));
        System.out.println(twoProduct(new int[]{100, 12, 4, 1, 2}, 15));
        System.out.println("___task5___");
        System.out.println(isExact(6));
        System.out.println(isExact(24));
        System.out.println(isExact(125));
        System.out.println(isExact(720));
        System.out.println(isExact(1024));
        System.out.println(isExact(40320));
        System.out.println("___task6___");
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));
        System.out.println("___task7___");
        System.out.println(pilish_string("CANIMAKEAGUESSNOW"));
        System.out.println(pilish_string("33314444"));
        System.out.println(pilish_string("TOP"));
        System.out.println(pilish_string("X"));
        System.out.println(pilish_string(""));
        System.out.println("___task8___");
        System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)"));
        System.out.println(generateNonconsecutive("6 - 18 / (-1 + 4)"));
        System.out.println("___task9___");
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));
        System.out.println("___task10___");
        System.out.println(findLCS("abcd", "bd"));
        System.out.println(findLCS("aggtab", "gxtxamb"));

    }

    public static String hiddenAnagram(String sentence, String anagram) {
        sentence = sentence.toLowerCase();
        anagram = anagram.toLowerCase();
        anagram = anagram.replace(" ", "");
        String result = "";
        String notFound = "not found";
        for (String i : sentence.split("")) {
            if (!(((int)i.charAt(0)) >= 97 && ((int)i.charAt(0)) <= 122)) {
                sentence = sentence.replace(i,"");
            }
        }
        String[] sortedAnagram = anagram.split("");
        Arrays.sort(sortedAnagram);
        String sortAnagram = "";
        for (String i : sortedAnagram) {
            sortAnagram += i;
        }
        for (int i = 0; i < sentence.length()-sortedAnagram.length+1; i ++){
            String[] tmp = sentence.substring(i,sortedAnagram.length+i).split("");
            String[] tmp1 = new String[tmp.length];
            System.arraycopy(tmp, 0, tmp1, 0, tmp.length);
            Arrays.sort(tmp);
            String tmpStr = "";
            for (String c : tmp) {
                tmpStr += c;
            }
            if (tmpStr.equals(sortAnagram)) {
                for (String j : tmp1) {
                    result += j;
                }
                break;
            }
        }
        if (result.isEmpty()) return notFound;
        else return result;
    }

    public static ArrayList<String> collect(String word, int number) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> result = beforeCollect(word, number, list);
        Collections.sort(result);
        return result;
    }

    public static ArrayList<String> beforeCollect(String word, int number, ArrayList<String> result) {
        if (word.length() < number) return result;
        else {
            result.add(word.substring(0, number));
            word = word.substring(number);
            return beforeCollect(word, number, result);
        }
    }

    public static String nicoCipher(String message, String key) {
        char[] keyArr = key.toCharArray();
        List<Map.Entry<Character, Integer>> entry = new ArrayList<>();
        //HashMap<Character, Integer> map = new HashMap<>();
        List<List<Character>> list = new ArrayList<>();
        int[] arr = new int[keyArr.length];
        int k = 0;
        int n;
        String result = "";
        if (message.length() % keyArr.length == 0) {
            n = message.length() / keyArr.length;
        } else n = message.length() / keyArr.length + 1;
        char[][] mesArr = new char[n][keyArr.length];
        for (int i = 0; i < mesArr.length; i++) {
            for (int j = 0; j < mesArr[i].length; j++) {
                if (k == message.length()) {
                    break;
                } else {
                    mesArr[i][j] = message.charAt(k);
                    k++;
                }
            }
        }
        Arrays.sort(keyArr);
        for (int i = 0; i < keyArr.length; i++) {
            //map.put(keyArr[i], i+1);
            Map.Entry<Character, Integer> tempEntry = new AbstractMap.SimpleEntry<Character, Integer>(keyArr[i], i+1);
            entry.add(tempEntry);
        }

        for (int i = 0; i < keyArr.length; i++) {
            for (int j = 0; j < entry.size(); j++) {
                if (key.charAt(i) == entry.get(j).getKey()) {
                    arr[i] = entry.get(j).getValue();

                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    arr[i] = arr[j] - 1;
                }
            }
        }
        /*for (int i = 0; i < keyArr.length; i++) {
            arr[i] = map.get(key.charAt(i));
        }*/
        for (int i = 0; i < mesArr.length; i++) {
            for (int j = 0; j < mesArr[i].length; j++) {
                List<Character> tmp = new ArrayList<>();
                tmp.add(mesArr[i][j]); tmp.add(Character.forDigit(arr[j], 10));
                list.add(tmp);
            }
        }
        Arrays.sort(arr);
        for (int i = 0; i < list.size(); i += keyArr.length) {
            List<List<Character>> tmp = new ArrayList<>(n);
            tmp.addAll(list.subList(i, i + keyArr.length));
            for (int j = 0; j < arr.length; j++) {
                for (int z = 0; z < tmp.size(); z++) {
                    if ((Integer.parseInt(String.valueOf(tmp.get(z).get(1)))) == arr[j]) {
                        if ((int)tmp.get(z).get(0) == 0) {
                            result += " ";
                        } else result += Character.toString(tmp.get(z).get(0));
                    }
                }
            }
        }
        return result;
    }

    public static ArrayList<Integer> twoProduct(int[] arr, int product) {
        ArrayList<Integer> result = new ArrayList<>();
        int minLen = 1000;
        for (int i = 0; i < arr.length; i++) {
            int len;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] * arr[j] == product) {
                    len = j - i;
                    if (len < minLen) {
                        minLen = len;
                        result.add(arr[i]);
                        result.add(arr[j]);
                    }
                }
            }
        }
        return result;
    }

    public static ArrayList<Integer> isExact(int fact) {
        int i = 1; int endFact = 1;
        return fact(fact, i, endFact);
    }

    public static ArrayList<Integer> fact(int startFact, int i, int endFact) {
        ArrayList<Integer> result = new ArrayList<>();
        if (startFact == endFact) {
            result.add(startFact);
            result.add(i);
            return result;
        } else if (endFact > startFact) return result;
        i += 1;
        endFact *= i;
        return fact(startFact, i, endFact);
    }

    public static String fractions(String num) {
        char[] numArr = num.toCharArray();
        String a = "";
        String b = "";
        String c = "";
        int x1;
        int x2;
        int i = 0;
        while (numArr[i] != '.') {
            a += numArr[i];
            i++;
        }
        i++;
        while (numArr[i] != '(') {
            b += numArr[i];
            i++;
        }
        i++;
        while (numArr[i] != ')') {
            c += numArr[i];
            i++;
        }
        if (b.isEmpty()) {
            x1 = (int) ((Integer.parseInt(a)*Math.pow(10, c.length())) +
                    Integer.parseInt(c) - Integer.parseInt(a));
            x2 = (int) (Math.pow(10, c.length()) - 1);
        } else {
            x1 = (int) ((Integer.parseInt(a)*Math.pow(10, b.length()+c.length())) +
                    (Integer.parseInt(b) * Math.pow(10, c.length())) + Integer.parseInt(c) -
                    (Integer.parseInt(a) * Math.pow(10, b.length())) - Integer.parseInt(b));
            x2 = (int) (Math.pow(10, b.length()+c.length()) - Math.pow(10, b.length()));
        }
        int nod = getNOD(x1, x2);
        x1 /= nod; x2 /= nod;
        return (x1 + "/" + x2);
    }

    public static int getNOD(int a, int b) {
        if (b == 0) return a;
        return getNOD(b, a % b);
    }

    public static String pilish_string(String word) {
        double pi = 3.14159265358979;
        String[] piArr = Double.toString(pi).replace(".", "").split("");
        String result = "";
        if (word.length() > 77) {
            word = word.substring(0,77);
        }
        String word1 = word;
        int count = 0;
        for (int i = 0; i < piArr.length; i++) {
            if (word1.isEmpty()) break;
            if (result.isEmpty() && word1.length() >= Integer.parseInt(piArr[i])) {
                result += word.substring(0, 3) + " ";
                word1 = word.substring(3);
                count += 3;
            } else if (word1.length() < Integer.parseInt(piArr[i])) {
                String charac = Character.toString(word1.charAt(word1.length()-1));
                result += word1 + charac.repeat(Math.abs(Integer.parseInt(piArr[i]) - word1.length()));
                word1 = "";
            } else {
                result += word.substring(count, count + Integer.parseInt(piArr[i])) + " ";
                word1 = word.substring(count + Integer.parseInt(piArr[i]));
                count += Integer.parseInt(piArr[i]);
            }
        }
        return result;
    }

    public static String generateNonconsecutive(String txt) {
        txt = txt.replaceAll("\\(", "( ");
        txt = txt.replaceAll("\\)", " )");
        LinkedList<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        for (String elem : txt.split(" ")) {
            try {
                double num = Double.parseDouble(elem);
                queue.add(Double.toString(num));
            } catch (NumberFormatException ignore) {
                if (stack.isEmpty() || stack.peek().equals("(")) {
                    stack.push(elem);
                } else if ((elem.equals("*") || elem.equals("/")) && (stack.peek().equals("+") ||
                        stack.peek().equals("-"))) {
                    stack.push(elem);
                } else if (elem.equals("(")) {
                    stack.push(elem);
                } else if (elem.equals(")")) {
                    while (!stack.peek().equals("(")) {
                        queue.add(stack.pop());
                    }
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        Stack<Double> result = new Stack<>();
        System.out.println(queue);
        while (!queue.isEmpty()) {
            String elem = queue.removeFirst();
            try {
                double num = Double.parseDouble(elem);
                result.push(num);
            } catch (NumberFormatException e) {
                switch (elem) {
                    case "+":
                        result.push(result.pop() + result.pop());
                        break;
                    case "-":
                        result.push(-result.pop() + result.pop());
                        break;
                    case "*":
                        result.push(result.pop() * result.pop());
                        break;
                    case "/":
                        double num1 = result.pop();
                        double num2 = result.pop();
                        if (num1 == 0) {
                            return "ZeroDivision";
                        }
                        result.push(num2 / num1);
                }
            }
        }
        return Double.toString(result.pop());
    }

    public static String isValid(String word) {
        String[] arr = word.toLowerCase().split("");
        HashMap<String, Integer> map = new HashMap<>();
        for (String i : arr) {
            map.put(i, 0);
        }
        for (String i : arr) {
            int count;
            if (map.get(i) == 0) {
                count = word.length() - word.replace(i, "").length();
                map.put(i, count);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> subList2 = new ArrayList<>();
        list.addAll(map.values());
        Collections.sort(list);
        for (int i = 0; i < list.size()-1; i++) {
            if (!Objects.equals(list.get(i), list.get(i + 1))) {
                subList2 = new ArrayList<Integer>(list.subList(i+1, list.size()));
                break;
            }
        }
        if (subList2.isEmpty() || subList2.size() == 1) return "YES";
        else return "NO";
    }

    public static String findLCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcsLength = dp[m][n];
        char[] lcs = new char[lcsLength];
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs[lcsLength - 1] = s1.charAt(i - 1);
                i--;
                j--;
                lcsLength--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return new String(lcs);
    }


}
