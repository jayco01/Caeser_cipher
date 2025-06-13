import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

//        String inputFilePath = scanner.nextLine().trim();
        String inputFilePath = "input.txt";
//        String ouputFilePath = scanner.nextLine().trim();
        String outputFilePath = "output.txt";
//        int key = Integer.parseInt(scanner.nextLine());

        FileManager firstFile = new FileManager(inputFilePath, outputFilePath);
        String firstFileContent = firstFile.readFile();


        Cipher fistMessage = new Cipher(firstFileContent);
        String encryptedFirstMessage = fistMessage.encrypt(6);

        firstFile.writeFile(encryptedFirstMessage);




        // Menu logic
        // 1. Encryption
        // 2. Decryption with key
        // 3. Brute force
        // 4. Statistical analysis
        // 0. Exit

        // Example of calling the encryption method:
        // cipher.encrypt("input.txt", "output.txt", 3);
    }
}