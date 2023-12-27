import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface DataProcessor {
}

public class DataManager {
    private List<Object> processors = new ArrayList<>();
    private List<Object> data = new ArrayList<>();

    private List<Object> processedData = new ArrayList<>();

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) {
        try {
            File file = new File(source);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                data.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void processData() {
        ExecutorService executor = Executors.newFixedThreadPool(data.size());

        for (Object processor : processors) {
            executor.execute(() -> {
                if (processor instanceof FilterProcessor) {
                    data.stream().map(d ->
                            ((FilterProcessor) processor).process(d)).forEach(processedData::add);
                } else if (processor instanceof TransformProcessor) {
                    data.stream().map(d ->
                            ((TransformProcessor) processor).process(d)).forEach(processedData::add);
                } else if (processor instanceof AggregateProcessor) {
                    data.stream().map(d ->
                            ((AggregateProcessor) processor).process(d)).forEach(processedData::add);
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveData(String dest) {
        try {
            File file = new File(dest);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            for (Object line : processedData) {
                if (line instanceof String) {
                    writer.write((String)line);
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    static class FilterProcessor {
        @DataProcessor
        public Object process(Object data) {
            if (data instanceof String) {
                String text = (String) data;
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(text);
                return matcher.replaceAll("");
            } else {
                return "Not a String";
            }
        }
    }

    static class TransformProcessor {
        @DataProcessor
        public Object process(Object data) {
            if (data instanceof String) {
                String originString = (String) data;
                String transformedString = "Prefix_" + originString + "_Suffix";
                return transformedString;
            } else return "Not a String";
        }
    }

    static class AggregateProcessor {
        @DataProcessor
        public Object process(Object data) {
            if (data instanceof String) {
                String[] strings = ((String) data).split(",");
                String aggregatedString = String.join(",", strings);
                return aggregatedString;
            } else return "Not a string";
        }
    }

    public static void main(String[] args) {
        DataManager dataManager = new DataManager();
        dataManager.registerDataProcessor(new TransformProcessor());
        dataManager.loadData("text.txt");
        dataManager.processData();
        System.out.println(dataManager.processedData);
        dataManager.saveData("new.txt");
    }
}


