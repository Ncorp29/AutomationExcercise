package utilities;

import java.io.File;
import java.io.IOException;

public class FileUploadUtilities {
    public static void uploadFile(String autoItScriptPath) {
        try {
            File scriptFile = new File(autoItScriptPath).getCanonicalFile();
            if (!scriptFile.isFile()) {
                throw new IllegalArgumentException("Invalid AutoIt script path");
            }
            Runtime.getRuntime().exec(new String[] { scriptFile.getPath() });
            Thread.sleep(3000); // Wait for file upload to complete
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}