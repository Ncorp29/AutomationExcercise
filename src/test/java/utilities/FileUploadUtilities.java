package utilities;

import java.io.IOException;

public class FileUploadUtilities {
    public static void uploadFile(String autoItScriptPath) {
        try {
            Runtime.getRuntime().exec(autoItScriptPath);
            Thread.sleep(3000); // Wait for file upload to complete
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
