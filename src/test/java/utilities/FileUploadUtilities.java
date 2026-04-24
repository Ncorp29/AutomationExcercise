package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUploadUtilities {
    public static void uploadFile(String autoItScriptPath) {
        try {
            Path scriptPath = Paths.get(autoItScriptPath).toAbsolutePath().normalize();
            if (!Files.isRegularFile(scriptPath) || !Files.isExecutable(scriptPath)) {
                throw new IOException("Invalid script path");
            }
            new ProcessBuilder(scriptPath.toString()).start();
            Thread.sleep(3000); // Wait for file upload to complete
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}