import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {
    private Validator() {}

    public static boolean isValidKey(String strKey) throws NumberFormatException {
        try {
            int key = Integer.parseInt(strKey);
            if (key > 0 && key <= Cipher.ALPHABET.length) {
                return true;
            } else {
                return false;
            }
        }catch(NumberFormatException e) {
            System.out.println("Encrypt Key is NOT valid. Please enter a number between 1 and 61. Error: " + e.getMessage());
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

    public static boolean isValidMenuOption(String selectedStr) throws NumberFormatException{
        try {
            int selected = Integer.parseInt(selectedStr);
            if(selected < 0 || selected > 4)
            {

                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Invalid menu option. Please enter a number between 0 and 4");
            return false;
        }
    }
}