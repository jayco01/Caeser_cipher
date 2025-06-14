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

}
