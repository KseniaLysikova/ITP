import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsFinder {
    public static void main(String[] args) {
        String letter = "S";
        String text = "hasdhjsd jasdlSSS Skbkh12414 Sbx";

        String regex = "\\b" + letter + "\\w*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
