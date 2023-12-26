import java.io.*;

public class ExceptionHandler {
    public static void logException(Exception e) {
        String path = "log.txt";

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(path, true));
            writer.println(e.toString());
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
