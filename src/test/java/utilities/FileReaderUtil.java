package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileReaderUtil {
    private static final String FILE_PATH = System.getProperty("user.dir") + "/ExpectedResult/expected_values.txt"; // Set file path

    public static Map<String, String> readExpectedValues(String string) {
        Map<String, String> expectedValues = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    expectedValues.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return expectedValues;
    }
}
