import java.util.Arrays;
import java.util.HashSet;

public class Cipher {

    private String rawMessage;
    private String encryptedMessage;
    private String decryptedMessage;

    public String getRawMessage() { return rawMessage;}
    public String getEncryptedMessage() { return encryptedMessage;}
    public String getDecryptedMessage() { return decryptedMessage;}


    public static final HashSet<String> ENGLISH_WORDS = new HashSet<>(Arrays.asList(
            "the", "be", "to", "of", "and", "a", "in", "that", "have", "i", "it", "for", "not",
            "on", "with", "he", "as", "you", "do", "at", "this", "but", "his", "by", "from",
            "they", "we", "say", "her", "she", "or", "an", "will", "my", "one", "all", "would",
            "there", "their", "what", "so", "up", "out", "if", "about", "who", "get", "which",
            "go", "me", "when", "make", "can", "like", "time", "no", "just", "him", "know", "take",
            "people", "into", "year", "your", "good", "some", "could", "them", "see", "other",
            "than", "then", "now", "look", "only", "come", "its", "over", "think", "also", "back",
            "after", "use", "two", "how", "our", "work", "first", "well", "way", "even",
            "new", "want", "because", "any", "these", "give", "day", "most", "us"
    ));

    public Cipher(String rawMessage){
        this.rawMessage = rawMessage;
    };

    //
    // Alphabet Array
    //
    public static final char[] ALPHABET = buildAlphabet();
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
    public void encrypt(int key) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : rawMessage.toCharArray()) {
            int position = findCharPosition(c);

            if (position == -1) continue;

            int newPosition = setNewPosition(position, key, true);

            encryptedMessage.append(ALPHABET[newPosition]);

        }
        this.encryptedMessage = encryptedMessage.toString();
    }

    public String decrypt(int key) {
        StringBuilder decryptedMessage = new StringBuilder();
        for (char c : encryptedMessage.toCharArray()) {
            int position = findCharPosition(c);
            if (position == -1) continue;
            int newPosition = setNewPosition(position, key, false);
            decryptedMessage.append(ALPHABET[newPosition]);
        }
        this.decryptedMessage = decryptedMessage.toString();
        return this.decryptedMessage;
    }


    public String decryptByBruteForce(String encryptedText) {
        // Brute force logic
        int englighWordsCount = Integer.MIN_VALUE;
        String decryptedMessage = "";
        for (int i = 0; i < ALPHABET.length; i++) {
            String message = decrypt(i);
            int tempEnglighWordsCount = countEnglishWords(message);
            if (tempEnglighWordsCount > englighWordsCount)
            {
                decryptedMessage = message;
                englighWordsCount = tempEnglighWordsCount;
            }
        }
        return decryptedMessage;
    }

    private int countEnglishWords(String message) {
        String[] messageList = message.split(" ");
        int count = 0;
        for (String str: messageList) {
            String strWithoutSymbols = str.replaceAll("[-.,\"':!?\\s]", "");
            if (ENGLISH_WORDS.contains(strWithoutSymbols.toLowerCase())) count++;
        }
        return count;
    }




    //
    // Helper Methods
    //
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
        positionWithKey = (positionWithKey >= 0) ? positionWithKey : positionWithKey + ALPHABET.length;

        int newPosition = (positionWithKey % ALPHABET.length <= 0) ? positionWithKey : positionWithKey % ALPHABET.length;

        return newPosition;
    }







    public void statisticalAnalysis(String inputFile, String outputFile, String optionalSampleFile) {
        // Implement statistical analysis
    }

    // Helper methods: validateInput(), shiftCharacter()

}

