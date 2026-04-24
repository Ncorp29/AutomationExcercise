package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUploadUtilities {
    public static void uploadFile(String autoItScriptPath) {
        try {
            Path scriptPath = Paths.get(autoItScriptPath);
            if (!Files.isRegularFile(scriptPath)) {
                throw new IllegalArgumentException("Invalid script path");
            }
            Runtime.getRuntime().exec(new String[] { scriptPath.toAbsolutePath().toString() });
            Thread.sleep(3000); // Wait for file upload to complete
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}