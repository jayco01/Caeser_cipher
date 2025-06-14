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
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidMenuOption(String selectedStr) {
        try {
            int selected = Integer.parseInt(selectedStr);
            if(selected < 0 || selected > 4)
            {
                System.out.println("Condition 1: Please select a valid Menu option");
                return false;
            }
            System.out.println("Condition 2: Input is a valid Menu option");
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Invalid menu option. Enter a number from 0 to 4");
            return false;
        }
    }
}