import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Cipher cipher = new Cipher();

        String inputFilePath = scanner.nextLine().trim();
//        String ouputFilePath = scanner.nextLine().trim();
//        int key = Integer.parseInt(scanner.nextLine());

        String fileContent =  FileManager.readFile(inputFilePath);


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