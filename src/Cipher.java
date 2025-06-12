public class Cipher {

    // Alphabet
    private static final char[] ALPHABET = buildAlphaber();

    private static char[] buildAlphaber() {
        StringBuilder alphabet = new StringBuilder();

        for (char i = 'a'; i <= 'z' ; i++) //append lower case
        {
            alphabet.append(i);
        }
        for (char i = 'A'; i <= 'Z' ; i++)//append upper case
        {
            alphabet.append(i);
        }

        alphabet.append(".,\"':-!? ");

        return alphabet.toString().toCharArray();
    }

    // Methods for encryption, decryption, brute force, statistical analysis

    public void encrypt(String inputFile, String outputFile, int key) {
        // Implement encryption
    }

    public void decrypt(String inputFile, String outputFile, int key) {
        // Implement decryption
    }

    public void bruteForce(String inputFile, String outputFile,
                           String optionalSampleFile) {
        // Implementation of brute force
    }

    public void statisticalAnalysis(String inputFile, String outputFile,
                                    String optionalSampleFile) {
        // Implement statistical analysis
    }

    // Helper methods: validateInput(), createAlphabet(), shiftCharacter(), readFile(), writeFile()

    public static void main(String[] args) {
        Cipher cipher = new Cipher();
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

