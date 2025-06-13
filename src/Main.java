import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);


        String selected = "";
        while(!selected.equals("0")) {
            System.out.println("1. Encryption\n" +
                    "2. Decryption with key\n" +
                    "3. Brute force\n" +
                    "4. Statistical analysis\n" +
                    "0. Exit");
            selected = scanner.nextLine();
        }



//        String inputFilePath = scanner.nextLine().trim();
        String inputFilePath = "input.txt";
//        String ouputFilePath = scanner.nextLine().trim();
        String outputFilePath = "output.txt";
//        int key = Integer.parseInt(scanner.nextLine());

        FileManager firstFile = new FileManager(inputFilePath, outputFilePath);
        String firstFileContent = firstFile.readFile();


        Cipher fistMessage = new Cipher(firstFileContent);
        fistMessage.encrypt(6);
        firstFile.writeFile(fistMessage.getEncryptedMessage());
        System.out.println(fistMessage.getEncryptedMessage());

        fistMessage.decrypt(6);
        System.out.println(fistMessage.getDecryptedMessage());






        // Menu logic


        // Example of calling the encryption method:
        // cipher.encrypt("input.txt", "output.txt", 3);
    }
}