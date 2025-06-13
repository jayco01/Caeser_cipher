public class Cipher {

    private String rawMessage;

    public Cipher(String rawMessage){
        this.rawMessage = rawMessage;
    };

    //
    // Alphabet Array
    //
    private static final char[] ALPHABET = buildAlphabet();
    private static char[] buildAlphabet() {
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
    public String encrypt(int key) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : rawMessage.toCharArray()) {
            int position = findCharPosition(c);

            if (position == -1) continue;

            int newPosition = setNewPosition(position, key, true);

            encryptedMessage.append(ALPHABET[newPosition]);

        }
        return encryptedMessage.toString();
    }

    private int findCharPosition(Character character) {
        for (int i = 0; i < ALPHABET.length; i++) {
            if(ALPHABET[i] == character) return i;
        }
        return -1;
    }

    private int setNewPosition(int position, int key, boolean toEncrypt)
    {
        int positionWithKey = (toEncrypt) ? position + key : position - key;

        //add position length if the current position with key is negative,
        //this wraps the position in reverse when "decrypting"
        positionWithKey = (position > 0) ? position : position + ALPHABET.length;

        int newPosition = (positionWithKey % ALPHABET.length <= 0) ? positionWithKey : positionWithKey % ALPHABET.length;

        return newPosition;
    }

    public void decrypt(String inputFile, String outputFile, int key) {
        // Implement decryption
    }

    public void bruteForce(String inputFile, String outputFile, String optionalSampleFile) {
        // Implementation of brute force
    }

    public void statisticalAnalysis(String inputFile, String outputFile, String optionalSampleFile) {
        // Implement statistical analysis
    }

    // Helper methods: validateInput(), shiftCharacter()

}

