import java.io.IOException;
import java.util.Scanner;

public class MenuHelper {
    private MenuHelper() {}

    public static void printMenu() {
        System.out.println();
        System.out.println("Choose a Service:\n" +
                "1. Encryption\n" +
                "2. Decryption with key\n" +
                "3. Brute force\n" +
                "4. Statistical analysis\n" +
                "0. Exit");
    }

    /**
     * Controls which obects are made and which functonalities are called
     * @param selectedInt The user's menu choice.
     * @param scanner The Scanner object for reading further user input.
     */
    public static void selectService(int selectedInt, Scanner scanner) throws IOException {
        System.out.println();
        switch (selectedInt) {
            case 1:
                String inputFileEn = getInputFileEn("Enter the file name of the message to be encrypted('.txt' will be automatically added): ",
                        scanner, "Would you like to create a new file and write a message? (Y/N)",
                        "Enter the message to be encrypted: ");
                if (inputFileEn == null) break;

                int encryptKeyInt = getKeyInt(scanner);

                String outputFileEn = getOutputFileEn(scanner);

                FileManager encryptedFile = new FileManager(inputFileEn, outputFileEn);

                Cipher encryptedMessage = new Cipher(encryptedFile.readFile(), encryptKeyInt, true);

                FileManager.writeFile(encryptedMessage.getEncryptedMessage(), outputFileEn);

                System.out.println(encryptedMessage.getEncryptedMessage());
                break;


            case 2:
                String inputFileDe = getInputFileEn("Enter the file name of the message to be decrypted('.txt' will be automatically added): ",
                        scanner, "Would you like to create a new file and write an encrypted message? (Y/N)",
                        "Enter the message to be decrypted: ");
                if (inputFileDe == null) break;

                int decryptKeyInt = getKeyInt(scanner);

                String outputFileDe = getOutputFileEn(scanner);

                FileManager decryptedFile = new FileManager(inputFileDe, outputFileDe);

                Cipher decryptedMessage = new Cipher(decryptedFile.readFile(), decryptKeyInt, false);

                FileManager.writeFile(decryptedMessage.getDecryptedMessage(), outputFileDe);

                System.out.println(decryptedMessage.getDecryptedMessage());
                break;


            case 3:
                String inputFileBruteForce = getInputFileEn("Enter the file name of the message to be decrypted('.txt' will be automatically added): ",
                        scanner, "Would you like to create a new file and write an encrypted message? (Y/N)",
                        "Enter the message to be decrypted: ");
                if (inputFileBruteForce == null) break;


                String outputFileBruteForce = getOutputFileEn(scanner);

                FileManager decryptedFileBruteForce = new FileManager(inputFileBruteForce, outputFileBruteForce);

                Cipher decryptedMessageBF = new Cipher(decryptedFileBruteForce.readFile(), 0, false);

                String messgeBF = decryptedMessageBF.decryptByBruteForce();
                FileManager.writeFile(messgeBF, outputFileBruteForce);

                System.out.println(messgeBF);
                break;


            case 4:
                String inputFileSA = getInputFileEn("Enter the file name of the message to be decrypted('.txt' will be automatically added): ",
                        scanner, "Would you like to create a new file and write an encrypted message? (Y/N)",
                        "Enter the message to be decrypted: ");
                if (inputFileSA == null) break;


                String outputFileSA = getOutputFileEn(scanner);

                FileManager decryptedFileSA = new FileManager(inputFileSA, outputFileSA);

                Cipher decryptedMessageSA = new Cipher(decryptedFileSA.readFile(), 0, false);

                String messageSA = decryptedMessageSA.statisticalAnalysis(decryptedMessageSA.getRawMessage());

                FileManager.writeFile(messageSA, outputFileSA);

                break;
            default:
                System.out.println("Please enter a valid Service.");
        }
    }

    private static String getOutputFileEn(Scanner scanner) {
        System.out.println("Enter a destination file name to send the encrypted message('.txt' will be automatically added): ");
        return scanner.nextLine().trim().toLowerCase() + ".txt";
    }

    private static int getKeyInt(Scanner scanner) {
        String encryptKey = null;
        int encryptKeyInt = 0;
        while (true) {
            System.out.println("Enter the encrypt Key: ");
            encryptKey = scanner.nextLine();
            boolean isValidEncryptKey = Validator.isValidKey(encryptKey);
            encryptKeyInt = (isValidEncryptKey) ? Integer.parseInt(encryptKey) : -1;
            if (isValidEncryptKey) break;
        }
        return encryptKeyInt;
    }

    private static String getInputFileEn(String inputFile, Scanner scanner, String writeFileInput, String messageToEncrypt) throws IOException {
        System.out.println(inputFile);
        String inputFileEn = scanner.nextLine().trim().toLowerCase() + ".txt";
        boolean inputFileExist = Validator.isFileExists(inputFileEn);
        if (!inputFileExist) {
            System.out.println("File doesn't exist!\n");
            System.out.println(writeFileInput);
            String createChoice = scanner.nextLine().trim().toLowerCase();
            if (createChoice.equals("y")) {
                System.out.println(messageToEncrypt);
                String messageEn = scanner.nextLine().trim();
                FileManager.writeFile(messageEn, inputFileEn);
            } else {
                return null;
            }
        }
        return inputFileEn;
    }
}
