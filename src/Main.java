import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);


        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        Boolean isFileExist = Validator.isFileExists(inputFilePath);

        FileManager firstFile = new FileManager(inputFilePath, outputFilePath);
        String firstFileContent = firstFile.readFile();

        Cipher fistMessage = new Cipher(firstFileContent);

        String selected = null;
        boolean selectedIsValid = false;

        while(true) {
            MenuHelper.printMenu();

            selected = scanner.nextLine().trim();
            selectedIsValid = Validator.isValidMenuOption(selected);

            int selectedInt = Integer.parseInt(selected);
            if(!selectedIsValid || selectedInt == 0) break;

            switch(selectedInt) {
                case 1:
                    fistMessage.encrypt(6);
                    firstFile.writeFile(fistMessage.getEncryptedMessage());
                    System.out.println(fistMessage.getEncryptedMessage());
                    break;

                case 2:
                    fistMessage.decrypt(6);
                    System.out.println(fistMessage.getDecryptedMessage());

            }
        }





















        // Menu logic


        // Example of calling the encryption method:
        // cipher.encrypt("input.txt", "output.txt", 3);
    }
}