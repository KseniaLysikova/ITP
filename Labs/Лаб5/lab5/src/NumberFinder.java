import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "Пример текста55 с чис1лами: 123, 4.56, -7";
        String regex = "[-+]?\\d*\\.?\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String number = matcher.group();
            System.out.println(number);
        }
    }
}
