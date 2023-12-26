import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProtocolConverter {
    public static void main(String[] args) {
        String text = "ссылка: google.com";
        String regex = "\\b(([a-z\\d]+\\.?)+[a-z\\d]+)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        String result = matcher.replaceAll("http://$0");
        System.out.println(result);
    }
}
