import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        Boolean isFileExist = Validator.isFileExists(inputFilePath);



        String selected = "";
        boolean selectedIsValid = false;

        while(true) {

            MenuHelper.printMenu();

            selected = scanner.nextLine().trim();
            selectedIsValid = Validator.isValidMenuOption(selected);

            int selectedInt = Integer.parseInt(selected);
            if(!selectedIsValid || selectedInt == 0) break;

            firstMessage.encrypt(6);
            firstFile.writeFile(firstMessage.getEncryptedMessage());

            String deryptedMessage = firstMessage.decrypt(6);


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
                            String messageEn = scanner.nextLine().trim();
                            FileManager.writeFile(inputFileEn, messageEn);
                        } else { break; }
                    }

                    int encryptKey = 0;
                    while (true) {
                        System.out.println("Enter the encrypt Key: ");
                        encryptKey = scanner.nextInt();
                        boolean isValidEncryptKey = Validator.isValidKey(encryptKey);
                        if(!isValidEncryptKey) {
                            System.out.println("Encrypt Key is NOT valid. Please enter a number between 1 and 61.");
                        } else {break;}
                    }

                    System.out.println("Enter a destination file name to send the encrypted message('.txt' will be automatically added): ");
                    String outputFileEn = scanner.nextLine().trim().toLowerCase() + ".txt";


                    FileManager encryptedFile = new FileManager(inputFileEn, encryptKey, outputFileEn);

                    Cipher encryptedMessage = new Cipher(encryptedFile.readFile());

                    encryptedMessage.encrypt(encryptedFile.getEncryptionKey());

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
                            String messageDe = scanner.nextLine().trim();
                            FileManager.writeFile(inputFileDe, messageDe);
                        } else { break; }
                    }

                    int dencryptKey = 0;
                    while (true) {
                        System.out.println("Enter the encrypt Key: ");
                        dencryptKey = scanner.nextInt();
                        boolean isValidEncryptKey = Validator.isValidKey(dencryptKey);
                        if(!isValidEncryptKey) {
                            System.out.println("Encrypt Key is NOT valid. Please enter a number between 1 and 61.");
                        } else {break;}
                    }

                    System.out.println("Enter a destination file name to send the encrypted message('.txt' will be automatically added): ");
                    String outputFileDe = scanner.nextLine().trim().toLowerCase() + ".txt";

                    FileManager decryptedFile = new FileManager(inputFileDe, dencryptKey, outputFileDe);

                    Cipher decryptedMessage = new Cipher(decryptedFile.readFile());

                    decryptedMessage.encrypt(decryptedFile.getEncryptionKey());

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
                            String messageDe = scanner.nextLine().trim();
                            FileManager.writeFile(inputFileBruteForce, messageDe);
                        } else { break; }
                    }

                    int dencryptKeyBF = 0;
                    while (true) {
                        System.out.println("Enter the encrypt Key: ");
                        dencryptKeyBF = scanner.nextInt();
                        boolean isValidEncryptKey = Validator.isValidKey(dencryptKeyBF);
                        if(!isValidEncryptKey) {
                            System.out.println("Encrypt Key is NOT valid. Please enter a number between 1 and 61.");
                        } else {break;}
                    }

                    System.out.println("Enter a destination file name to send the encrypted message('.txt' will be automatically added): ");
                    String outputFileBruteForce = scanner.nextLine().trim().toLowerCase() + ".txt";

                    FileManager decryptedFileBruteForce = new FileManager(inputFileBruteForce, dencryptKeyBF, outputFileBruteForce);

                    Cipher decryptedMessageBF = new Cipher(decryptedFileBruteForce.readFile());

                    decryptedMessageBF.encrypt(decryptedFileBruteForce.getEncryptionKey());

                    System.out.println(decryptedMessageBF.getDecryptedMessage());
                    break;

                case 4:
                    System.out.println("Enter the file name of the message to be decrypted('.txt' will be automatically added): ");
                    String inputFileBruteForce = scanner.nextLine().trim().toLowerCase() + ".txt";
                    boolean inputFileBFExist = Validator.isFileExists(inputFileBruteForce);
                    if(!inputFileBFExist) {
                        System.out.println("File doesn't exist!");
                        System.out.println();
                        System.out.println("Would you like to create a new file and write an encrypted message? (Y/N)");
                        String createChoice = scanner.nextLine().trim().toLowerCase();
                        if(createChoice.equals("y")) {
                            String messageDe = scanner.nextLine().trim();
                            FileManager.writeFile(inputFileBruteForce, messageDe);
                        } else { break; }
                    }

                    int dencryptKeyBF = 0;
                    while (true) {
                        System.out.println("Enter the encrypt Key: ");
                        dencryptKeyBF = scanner.nextInt();
                        boolean isValidEncryptKey = Validator.isValidKey(dencryptKeyBF);
                        if(!isValidEncryptKey) {
                            System.out.println("Encrypt Key is NOT valid. Please enter a number between 1 and 61.");
                        } else {break;}
                    }

                    System.out.println("Enter a destination file name to send the encrypted message('.txt' will be automatically added): ");
                    String outputFileBruteForce = scanner.nextLine().trim().toLowerCase() + ".txt";

                    FileManager decryptedFileBruteForce = new FileManager(inputFileBruteForce, dencryptKeyBF, outputFileBruteForce);

                    Cipher decryptedMessageBF = new Cipher(decryptedFileBruteForce.readFile());

                    decryptedMessageBF.encrypt(decryptedFileBruteForce.getEncryptionKey());

                    System.out.println(decryptedMessageBF.getDecryptedMessage());
                    break;

            }
        }
    }
}