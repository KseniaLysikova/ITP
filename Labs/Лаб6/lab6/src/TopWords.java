import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "text.txt";
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        Map<String, Integer> map = new HashMap<>();
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (word.contains(".")) {
                word = word.replace(".", "");
            }
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        scanner.close();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        System.out.println(list);
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        System.out.println(list);
        System.out.println("Top 10 words:");
        int count = 0;
        for (int i = list.size() - 1; i >= 0; i-- ) {
            System.out.println(list.get(i).getKey());
            count++;
            if (count == 10) break;
        }
    }
}
