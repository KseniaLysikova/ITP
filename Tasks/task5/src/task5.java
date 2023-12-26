import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class task5 {
    public static void main(String[] args) {
        System.out.println("___task1___");
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
        System.out.println("___task2___");
        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "D4"));
        System.out.println(spiderVsFly("A4", "H4"));
        System.out.println("___task3___");
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));
        System.out.println("___task4___");
        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot",
        "dots", "sted"}, "tossed"));
        System.out.println("___task5___");
        System.out.println(sumsUp(new int[] {1, 2, 3, 4, 5}));
        System.out.println(sumsUp(new int[] {1, 2, 3, 7, 9}));
        System.out.println(sumsUp(new int[] {10, 9, 7, 2, 8}));
        System.out.println(sumsUp(new int[] {1, 6, 5, 4, 8, 2, 3, 7}));
        System.out.println("___task6___");
        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[]{"10%"}));
        System.out.println(takeDownAverage(new String[]{"53%", "79%"}));
        System.out.println("___task7___");
        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "almost last task!", 4));
        System.out.println("___task8___");
        System.out.println(setSetup(5, 3));
        System.out.println(setSetup(7, 3));
        System.out.println("___task9___");
        System.out.println(test("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(test("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(test("New York", "December 31, 1970 13:40", "Beijing"));
        System.out.println("___task10___");
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(130));

    }

    public static boolean sameLetterPattern(String firstWord, String secondWord) {
        if (firstWord.length() != secondWord.length()) return false;
        char[] firstArr = firstWord.toCharArray();
        char[] secondArr = secondWord.toCharArray();
        char x = firstArr[0];
        char y = secondArr[0];
        for (int i = 1; i < firstWord.length(); i++) {
            int dx = x - firstArr[i];
            int dy = y - secondArr[i];
            if (dx != dy) return false;
            x = firstArr[i];
            y = secondArr[i];
        }
        return true;
    }

    public static String spiderVsFly(String spider, String fly) {
        int move;
        int way;
        String result = "";
        int spiderX = (spider.charAt(0) - 'A');
        int spiderY = Character.getNumericValue(spider.charAt(1));
        int flyX = (fly.charAt(0) - 'A');
        int flyY = Character.getNumericValue(fly.charAt(1));
        if (Math.floorMod(spiderX - flyX, 8) <= 4) {
            move = -1;
        } else {
            move = 1;
        }
        if (Math.abs(spiderX - flyX) <= 2 || Math.abs(spiderX - flyX) >= 6){
            way = 1;
        } else {
            way = 0;
        }
        while (spiderY != flyY || spiderX != flyX){
            if (way == 1) {
                if (spiderY > flyY) {
                    result += (char)(spiderX + 'A') + String.valueOf(spiderY)+ "-";
                    spiderY--;
                } else if (spiderX != flyX) {
                    result += (char)(spiderX + 'A') + String.valueOf(spiderY) + "-";
                    spiderX = Math.floorMod(spiderX + move, 8);
                } else {
                    result += (char)(spiderX + 'A') + String.valueOf(spiderY) + "-";
                    spiderY++;

                }
            } else {
                if (spiderY != 0 && spiderX != flyX) {
                    result += (char)(spiderX + 'A') + String.valueOf(spiderY) + "-";
                    spiderY--;
                } else if (spiderY == 0){
                    spiderX = flyX;
                    result += "A" + String.valueOf(spiderY)+ "-";
                    spiderY++;
                } else {
                    result += (char)(spiderX + 'A') + String.valueOf(spiderY) + "-";
                    spiderY++;
                }
            }
        }

        return result + fly;

    }

    public static int digitsCount(long number) {
        if (number < 10) return 1;
        else return 1 + digitsCount(number / 10);
    }

    public static int totalPoints(String[] answers, String startWord) {
        String[] startArr = startWord.split("");
        int result = 0;
        int count = 0;
        for (String i : answers) {
            if (i.length() == 6) count += 1;
        }
        for (int i = 0; i < answers.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            for (String k : startArr) {
                map.put(k, 0);
            }
            String[] wordArr = answers[i].split("");
            for (int j = 0; j < wordArr.length; j++) {
                if (Arrays.stream(startArr).anyMatch(wordArr[j] :: equals)) {
                    map.put(wordArr[j], map.get(wordArr[j])+1);
                }
            }
            if (map.containsValue(2)) result += 0;
            else if (answers[i].length() == 3) result += 1;
            else if (answers[i].length() == 4) result += 2;
            else if (answers[i].length() == 5) result += 3;
            else if (answers[i].length() == 6) result += 4;
            if (answers[i].equals(startWord)) result += 50*count;
        }
        return result;
    }

    public static List<List<Integer>> sumsUp (int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        nums.add(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            nums.add(numbers[i]);
            for (int j = 0; j < nums.size(); j++) {
                for (int k = j + 1; k < nums.size(); k++) {
                    if (nums.get(j) + nums.get(k) == 8) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums.get(j));
                        temp.add(nums.get(k));
                        Collections.sort(temp);
                        if (!(result.contains(temp))) {
                            result.add(temp);
                        }
                    }
                }
            }
        }
        return result;
    }

    /*public static List<List<Integer>> sumsUp (int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == 8) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(numbers[i]); temp.add(numbers[j]);
                    Collections.sort(temp);
                    result.add(temp);
                }
            }
        }
        return result;
    }*/

    public static String takeDownAverage(String[] marks) {
        int[] marksInt = new int[marks.length];
        double sum = 0;
        for (int i = 0; i < marks.length; i++) {
            String[] temp = marks[i].split("");
            sum += Integer.parseInt(temp[0]+temp[1]);
            marksInt[i] = Integer.parseInt(temp[0]+temp[1]);
        }
        int result = (int) (((sum / marks.length) - 5) * (marks.length + 1) - sum);
        return result + "%";
    }

    public static String caesarCipher(String type, String word, int shift) {
        StringBuilder result = new StringBuilder();
        char[] wordArr = word.toCharArray();
        if (type.equals("encode")) {
            for (char i : wordArr) {
                char temp;
                if (i == ' ') {
                    temp = i;
                } else {
                    temp = (char)((int) i - shift);
                }
                result.append(temp);
            }
        } else if (type.equals("decode")) {
            for (char i : wordArr) {
                char temp;
                if (i == ' ' || i == '!') {
                    temp = i;
                } else {
                    temp = (char)((int) i + shift);
                }
                result.append(temp);
            }
        }

        return result.toString().toUpperCase();
    }

    public static int setSetup(int n, int k) {
        if (k == n || k == 0) return 1;
        if (k != 1) return n * setSetup(n-1, k-1);
        else return n;
    }

    public static String timeDifference(String timeZone, String dateString, String newTimeZone) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Los Angeles", 8); map.put("New York", 5); map.put("Caracas", 4);
        map.put("Buenos Aires", 3); map.put("London", 0); map.put("Rome", 1);
        map.put("Moscow", 3); map.put("Tehran", 3); map.put("New Delhi", 5);
        map.put("Beijing", 8); map.put("Canberra", 10);
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy HH:mm", Locale.US);
            Date date = dateFormat.parse(dateString);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.HOUR_OF_DAY, (map.get(timeZone) + map.get(newTimeZone)));
            if (newTimeZone.equals("Caracas") || newTimeZone.equals("Tehran") || newTimeZone.equals("New Delhi")){
                calendar.add(Calendar.MINUTE, 30);
            }

            Date cityBTime = calendar.getTime();

            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-M-d HH:mm");
            return outputFormat.format(cityBTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "1";
    }

    public static String test(String timeZone, String dateString, String newTimeZone) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Los Angeles", "UTC-8"); map.put("New York", "UTC-5"); map.put("Caracas", "UTC-8:30");
        map.put("Buenos Aires", "UTC-3"); map.put("London", "UTC-0"); map.put("Rome", "UTC+1");
        map.put("Moscow", "UTC+3"); map.put("Tehran", "UTC+3:30"); map.put("New Delhi", "UTC+5:30");
        map.put("Beijing", "UTC+8"); map.put("Canberra", "UTC+10");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy HH:mm", Locale.ENGLISH);
        LocalDateTime sourceDateTime = LocalDateTime.parse(dateString, formatter);

        ZoneId sourceZoneId = ZoneId.of(map.get(timeZone));
        ZoneId targetZoneId = ZoneId.of(map.get(newTimeZone));

        ZonedDateTime sourceZonedDateTime = sourceDateTime.atZone(sourceZoneId);
        ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(ZoneId.of("UTC"));

        ZonedDateTime targetDateTime = targetZonedDateTime.withZoneSameInstant(targetZoneId);

        LocalDateTime targetLocalDateTime = targetDateTime.toLocalDateTime();
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.ENGLISH);

        return targetLocalDateTime.format(newFormatter);
    }

    public static boolean isNew(int number) {
        char[] numArr = String.valueOf(number).toCharArray();
        String tmp = "";
        Arrays.sort(numArr);
        if (numArr[0] == '0') {
            numArr[0] = numArr[1];
            numArr[1] = '0';
        }
        for (char i : numArr) {
            tmp += i;
        }
        int sortedNum = Integer.parseInt(tmp);
        if (sortedNum == number) return true;
        else return false;
    }
}
