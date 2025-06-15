import java.io.IOException;
import java.util.Scanner;

public class MenuHelper {
    private MenuHelper() {}

    public record filesAndKey(String inputFilePath, String outputFilePath, int key){};

    public static void printMenu() {
        System.out.println("1. Encryption\n" +
                "2. Decryption with key\n" +
                "3. Brute force\n" +
                "4. Statistical analysis\n" +
                "0. Exit");
    }

    public static filesAndKey inputFileAndKey() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter input file path: ");
        String inputFilePath = scanner.nextLine().trim();

        System.out.print("Enter output file path: ");
        String outputFilePath = scanner.nextLine().trim();

        System.out.print("Enter key: ");
        int key = scanner.nextInt();

        return new filesAndKey(inputFilePath, outputFilePath, key);
    }


    public static void selectService(int selectedInt, Scanner scanner) throws IOException {
        switch (selectedInt) {
            case 1:
                String inputFileEn = getInputFileEn("Enter the file name of the message to be encrypted('.txt' will be automatically added): ",
                        scanner, "Would you like to create a new file and write a message? (Y/N)",
                        "Enter the message to be encrypted: ");
                if (inputFileEn == null) break;

                int encryptKeyInt = getKeyInt(scanner);

                String outputFileEn = getOutputFileEn(scanner);

                FileManager encryptedFile = new FileManager(inputFileEn, encryptKeyInt, outputFileEn);

                Cipher encryptedMessage = new Cipher(encryptedFile.readFile());

                encryptedMessage.encrypt(encryptedFile.getEncryptionKey());

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

                FileManager decryptedFile = new FileManager(inputFileDe, decryptKeyInt, outputFileDe);

                Cipher decryptedMessage = new Cipher(decryptedFile.readFile());

                FileManager.writeFile(decryptedMessage.getDecryptedMessage(), outputFileDe);

                System.out.println(decryptedMessage.getDecryptedMessage());
                break;

            case 3:
                String inputFileBruteForce = getInputFileEn("Enter the file name of the message to be decrypted('.txt' will be automatically added): ",
                        scanner, "Would you like to create a new file and write an encrypted message? (Y/N)",
                        "Enter the message to be decrypted: ");
                if (inputFileBruteForce == null) break;

                int decryptKeyIntBF = getKeyInt(scanner);

                String outputFileBruteForce = getOutputFileEn(scanner);

                FileManager decryptedFileBruteForce = new FileManager(inputFileBruteForce, decryptKeyIntBF, outputFileBruteForce);

                Cipher decryptedMessageBF = new Cipher(decryptedFileBruteForce.readFile());

                decryptedMessageBF.decrypt(decryptedFileBruteForce.getEncryptionKey());

                FileManager.writeFile(decryptedMessageBF.getDecryptedMessage(), outputFileBruteForce);

                System.out.println(decryptedMessageBF.getDecryptedMessage());
                break;


            case 4:
                String inputFileSA = getInputFileEn("Enter the file name of the message to be decrypted('.txt' will be automatically added): ",
                        scanner, "Would you like to create a new file and write an encrypted message? (Y/N)",
                        "Enter the message to be decrypted: ");
                if (inputFileSA == null) break;

                int decryptKeyIntSA = getKeyInt(scanner);

                String outputFileSA = getOutputFileEn(scanner);

                FileManager decryptedFileSA = new FileManager(inputFileSA, decryptKeyIntSA, outputFileSA);

                Cipher decryptedMessageSA = new Cipher(decryptedFileSA.readFile());

                decryptedMessageSA.decrypt(decryptedFileSA.getEncryptionKey());

                FileManager.writeFile(decryptedMessageSA.getDecryptedMessage(), outputFileSA);

                System.out.println(decryptedMessageSA.getDecryptedMessage());
                break;
            default:
                return;
        }
    }

    private static String getOutputFileEn(Scanner scanner) {
        System.out.println("Enter a destination file name to send the encrypted message('.txt' will be automatically added): ");
        String outputFileEn = scanner.nextLine().trim().toLowerCase() + ".txt";
        return outputFileEn;
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

    private static String getInputFileEn(String x, Scanner scanner, String x1, String x2) throws IOException {
        System.out.println(x);
        String inputFileEn = scanner.nextLine().trim().toLowerCase() + ".txt";
        boolean inputFileExist = Validator.isFileExists(inputFileEn);
        if (!inputFileExist) {
            System.out.println("File doesn't exist!");
            System.out.println();
            System.out.println(x1);
            String createChoice = scanner.nextLine().trim().toLowerCase();
            if (createChoice.equals("y")) {
                System.out.println(x2);
                String messageEn = scanner.nextLine().trim();
                FileManager.writeFile(messageEn, inputFileEn);
            } else {
                return null;
            }
        }
        return inputFileEn;
    }
}
