import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopier {
    public static void main(String[] args) {
        String sourcePath = "1.txt";
        String destinationPath = "2.txt";

        try{
            FileInputStream sourceFile = new FileInputStream(sourcePath);
            FileOutputStream destinationFile = new FileOutputStream(destinationPath);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = sourceFile.read(buffer)) != -1) {
                destinationFile.write(buffer, 0, bytesRead);
            }
            System.out.println("Файл скопирован");
            sourceFile.close();
            destinationFile.close();
        } catch (IOException e) {
            System.out.println("Ошибка при копировании файла: " + e.getMessage());
        }
    }
}
