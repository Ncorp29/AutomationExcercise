package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUploadUtilities {
    public static void uploadFile(String autoItScriptPath) {
        try {
            Path scriptPath = Paths.get(autoItScriptPath).toAbsolutePath().normalize();
            if (!Files.isRegularFile(scriptPath) || !scriptPath.toString().toLowerCase().endsWith(".au3")) {
                throw new SecurityException("Invalid upload script path");
            }
            Runtime.getRuntime().exec(scriptPath.toString());
            Thread.sleep(3000); // Wait for file upload to complete
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}