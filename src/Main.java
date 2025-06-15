import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String selected = "";
        boolean selectedIsValid = false;

        while(true) {

            MenuHelper.printMenu();

            selected = scanner.nextLine().trim();
            selectedIsValid = Validator.isValidMenuOption(selected);

            int selectedInt = (selectedIsValid) ? Integer.parseInt(selected): -1;
            if(selectedInt == 0)
            {
                break;
            } else if (selectedInt == -1) {
                continue;
            }

            switch(selectedInt) {
                case 1:
                    System.out.println("Enter the file name of the message to be encrypted('.txt' will be automatically added): ");
                    String inputFileEn = scanner.nextLine().trim().toLowerCase() + ".txt";
                    boolean inputFileExist = Validator.isFileExists(inputFileEn);
                    if(!inputFileExist) {
                        System.out.println("File doesn't exist!");
                        System.out.println();
                        System.out.println("Would you like to create a new file and write a message? (Y/N)");
                        String createChoice = scanner.nextLine().trim().toLowerCase();
                        if(createChoice.equals("y")) {
                            System.out.println("Enter the message to be encrypted: ");
                            String messageEn = scanner.nextLine().trim();
                            FileManager.writeFile(messageEn, inputFileEn);
                        } else { break; }
                    }

                    String encryptKey = null;
                    int encryptKeyInt = 0;
                    while (true) {
                        System.out.println("Enter the encrypt Key: ");
                        encryptKey = scanner.nextLine();
                        boolean isValidEncryptKey = Validator.isValidKey(encryptKey);
                        encryptKeyInt = (isValidEncryptKey) ? Integer.parseInt(encryptKey) : -1;
                        if(isValidEncryptKey) break;
                    }

                    System.out.println("Enter a destination file name to send the encrypted message('.txt' will be automatically added): ");
                    String outputFileEn = scanner.nextLine().trim().toLowerCase() + ".txt";

                    FileManager encryptedFile = new FileManager(inputFileEn, encryptKeyInt, outputFileEn);

                    Cipher encryptedMessage = new Cipher(encryptedFile.readFile());

                    encryptedMessage.encrypt(encryptedFile.getEncryptionKey());

                    FileManager.writeFile(encryptedMessage.getEncryptedMessage(), outputFileEn);

                    System.out.println(encryptedMessage.getEncryptedMessage());
                    break;

                case 2:
                    System.out.println("Enter the file name of the message to be decrypted('.txt' will be automatically added): ");
                    String inputFileDe = scanner.nextLine().trim().toLowerCase() + ".txt";
                    boolean inputFileDeExist = Validator.isFileExists(inputFileDe);
                    if(!inputFileDeExist) {
                        System.out.println("File doesn't exist!");
                        System.out.println();
                        System.out.println("Would you like to create a new file and write an encrypted message? (Y/N)");
                        String createChoice = scanner.nextLine().trim().toLowerCase();
                        if(createChoice.equals("y")) {
                            System.out.println("Enter the message to be decrypted: ");
                            String messageDe = scanner.nextLine().trim();
                            FileManager.writeFile(messageDe, inputFileDe);
                        } else { break; }
                    }

                    String decryptKey = null;
                    int decryptKeyInt = 0;
                    while (true) {
                        System.out.println("Enter the encrypt Key: ");
                        decryptKey = scanner.nextLine();
                        boolean isValidEncryptKey = Validator.isValidKey(decryptKey);
                        decryptKeyInt = (isValidEncryptKey) ? Integer.parseInt(decryptKey) : -1;
                        if(isValidEncryptKey) break;
                    }

                    System.out.println("Enter a destination file name to send the encrypted message('.txt' will be automatically added): ");
                    String outputFileDe = scanner.nextLine().trim().toLowerCase() + ".txt";

                    FileManager decryptedFile = new FileManager(inputFileDe, decryptKeyInt, outputFileDe);

                    Cipher decryptedMessage = new Cipher(decryptedFile.readFile());

                    FileManager.writeFile(decryptedMessage.getDecryptedMessage(), outputFileDe);

                    System.out.println(decryptedMessage.getDecryptedMessage());
                    break;

                case 3:
                    System.out.println("Enter the file name of the message to be decrypted('.txt' will be automatically added): ");
                    String inputFileBruteForce = scanner.nextLine().trim().toLowerCase() + ".txt";
                    boolean inputFileBFExist = Validator.isFileExists(inputFileBruteForce);
                    if(!inputFileBFExist) {
                        System.out.println("File doesn't exist!");
                        System.out.println();
                        System.out.println("Would you like to create a new file and write an encrypted message? (Y/N)");
                        String createChoice = scanner.nextLine().trim().toLowerCase();
                        if(createChoice.equals("y")) {
                            System.out.println("Enter the message to be decrypted: ");
                            String messageBF = scanner.nextLine().trim();
                            FileManager.writeFile(messageBF, inputFileBruteForce);
                        } else { break; }
                    }

                    String decryptKeyBF = null;
                    int decryptKeyIntBF = 0;
                    while (true) {
                        System.out.println("Enter the encrypt Key: ");
                        decryptKeyBF = scanner.nextLine();
                        boolean isValidEncryptKey = Validator.isValidKey(decryptKeyBF);
                        decryptKeyIntBF = (isValidEncryptKey) ? Integer.parseInt(decryptKeyBF) : -1;
                        if(isValidEncryptKey) break;
                    }

                    System.out.println("Enter a destination file name to send the encrypted message('.txt' will be automatically added): ");
                    String outputFileBruteForce = scanner.nextLine().trim().toLowerCase() + ".txt";

                    FileManager decryptedFileBruteForce = new FileManager(inputFileBruteForce, decryptKeyIntBF, outputFileBruteForce);

                    Cipher decryptedMessageBF = new Cipher(decryptedFileBruteForce.readFile());

                    decryptedMessageBF.decrypt(decryptedFileBruteForce.getEncryptionKey());

                    FileManager.writeFile(decryptedMessageBF.getDecryptedMessage(), outputFileBruteForce);

                    System.out.println(decryptedMessageBF.getDecryptedMessage());
                    break;

                case 4:
                    System.out.println("Enter the file name of the message to be decrypted('.txt' will be automatically added): ");
                    String inputFileSA = scanner.nextLine().trim().toLowerCase() + ".txt";
                    boolean inputFileExistSA = Validator.isFileExists(inputFileSA);
                    if(!inputFileExistSA) {
                        System.out.println("File doesn't exist!");
                        System.out.println();
                        System.out.println("Would you like to create a new file and write an encrypted message? (Y/N)");
                        String createChoice = scanner.nextLine().trim().toLowerCase();
                        if(createChoice.equals("y")) {
                            System.out.println("Enter the message to be decrypted: ");
                            String messageSA = scanner.nextLine().trim();
                            FileManager.writeFile(messageSA, inputFileSA);
                        } else { break; }
                    }

                    String decryptKeySA = null;
                    int decryptKeyIntSA = 0;
                    while (true) {
                        System.out.println("Enter the encrypt Key: ");
                        decryptKeySA = scanner.nextLine();
                        boolean isValidEncryptKey = Validator.isValidKey(decryptKeySA);
                        decryptKeyIntSA = (isValidEncryptKey) ? Integer.parseInt(decryptKeySA) : -1;
                        if(isValidEncryptKey) break;
                    }

                    System.out.println("Enter a destination file name to send the encrypted message('.txt' will be automatically added): ");
                    String outputFileSA = scanner.nextLine().trim().toLowerCase() + ".txt";

                    FileManager decryptedFileSA = new FileManager(inputFileSA, decryptKeyIntSA, outputFileSA);

                    Cipher decryptedMessageSA = new Cipher(decryptedFileSA.readFile());

                    decryptedMessageSA.decrypt(decryptedFileSA.getEncryptionKey());

                    FileManager.writeFile(decryptedMessageSA.getDecryptedMessage(), outputFileSA);

                    System.out.println(decryptedMessageSA.getDecryptedMessage());
                    break;
                default:
                    continue;
            }
        }
    }
}