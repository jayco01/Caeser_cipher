import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);


        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        Boolean isFileExist = Validator.isFileExists(inputFilePath);

        FileManager firstFile = new FileManager(inputFilePath, outputFilePath);
        String firstFileContent = firstFile.readFile();

        Cipher firstMessage = new Cipher(firstFileContent);

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

                    System.out.println(firstMessage.getEncryptedMessage());
                    break;

                case 2:

                    System.out.println(deryptedMessage);
                    break;

                case 3:
                    String bruteForceMessage = firstMessage.decryptByBruteForce(firstFile.getOutputFilePath());
                    System.out.println(bruteForceMessage);

            }
        }
    }
}