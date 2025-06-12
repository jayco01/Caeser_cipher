public class Cipher {

    //
    // Alphabet Array
    //
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


    //
    // Methods for encryption, decryption, brute force, statistical analysis
    //
//    public String encrypt(String inputFile, String outputFile, int key) {
//        for ()
//    }

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

}

