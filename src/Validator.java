import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {
    private Validator() {}

    public static boolean isValidKey(int key, char[] alphabet) {
        if (key > 0 && key <= alphabet.length) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isFileExists(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            return false;
        } else if (Files.exists(Path.of(filePath))) {
            System.out.println("File exists");
            return true;
        } else {
            return false;
        }
    }
}