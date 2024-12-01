package Beta_Scenario;

import java.util.Scanner;

interface DataProcessor {
    void read(String filePath);
    void parse();
    void save(String outputPath);
}

class CSVProcessor implements DataProcessor {
    @Override
    public void read(String filePath) {
        System.out.println("Reading CSV file: " + filePath);
    }

    @Override
    public void parse() {
        System.out.println("Parsing CSV data...");
    }

    @Override
    public void save(String outputPath) {
        System.out.println("Saving CSV data to: " + outputPath);
    }
}

class JSONProcessor implements DataProcessor {
    @Override
    public void read(String filePath) {
        System.out.println("Reading JSON file: " + filePath);
    }

    @Override
    public void parse() {
        System.out.println("Parsing JSON data...");
    }

    @Override
    public void save(String outputPath) {
        System.out.println("Saving JSON data to: " + outputPath);
    }
}

class XMLProcessor implements DataProcessor {
    @Override
    public void read(String filePath) {
        System.out.println("Reading XML file: " + filePath);
    }

    @Override
    public void parse() {
        System.out.println("Parsing XML data...");
    }

    @Override
    public void save(String outputPath) {
        System.out.println("Saving XML data to: " + outputPath);
    }
}

class DataProcessorFactory {
    public static DataProcessor getProcessor(String fileType) {
        return switch (fileType.toLowerCase()) {
            case "csv" -> new CSVProcessor();
            case "json" -> new JSONProcessor();
            case "xml" -> new XMLProcessor();
            default -> throw new IllegalArgumentException("Unsupported file type: " + fileType);
        };
    }
}

// Step 4: Client Code
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String fileType = sc.nextLine();
        String filePath = "data.".concat(fileType);
        String outputPath = "output.".concat(fileType);


        DataProcessor processor = DataProcessorFactory.getProcessor(fileType);
        processor.read(filePath);
        processor.parse();
        processor.save(outputPath);
    }
}
