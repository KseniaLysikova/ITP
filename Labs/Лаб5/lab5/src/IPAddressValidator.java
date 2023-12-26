import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddressValidator {
    public static void main(String[] args) {
        String ip = "192.168.0.1";
        String regex = "((25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);
        System.out.println(matcher.matches());
    }
}