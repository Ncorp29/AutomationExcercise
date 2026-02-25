package utilities;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class FileUploadUtilities {
    private static final Set<String> ALLOWED_SCRIPT_NAMES = Set.of("UploadFile.exe");

    public static void uploadFile(String autoItScriptPath) {
        try {
            if (!isAllowed(autoItScriptPath)) {
                throw new IllegalArgumentException("Unrecognized script path");
            }
            ProcessBuilder processBuilder = new ProcessBuilder(autoItScriptPath);
            processBuilder.start();
            Thread.sleep(3000); // Wait for file upload to complete
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static boolean isAllowed(String autoItScriptPath) {
        if (autoItScriptPath == null || autoItScriptPath.isBlank()) {
            return false;
        }
        Path resolvedPath = Paths.get(autoItScriptPath).normalize();
        Path fileName = resolvedPath.getFileName();
        return fileName != null && ALLOWED_SCRIPT_NAMES.contains(fileName.toString());
    }
}