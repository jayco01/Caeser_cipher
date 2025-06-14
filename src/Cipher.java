import java.util.Arrays;
import java.util.HashSet;

public class Cipher {

    private String rawMessage;
    private String encryptedMessage;
    private String decryptedMessage;

    public String getRawMessage() { return rawMessage;}
    public String getEncryptedMessage() { return encryptedMessage;}
    public String getDecryptedMessage() { return decryptedMessage;}

    private final HashSet<String> ENGLISH_WORDS = new HashSet<>(Arrays.asList(
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

    private final char[] COMMON_ENGLISH_LETTERS = {'e', 't', 'a', 'o', 'i', 'n', 's', 'h', 'r'};

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

    public String statisticalAnalysis(String encryptedText) {
        char[] encryptedMessageChars = encryptedText.toCharArray();

        int[] charFrequencyArray = getCharFrequencyArray(encryptedMessageChars);

        int postionOfHighestFrequency = getPositionOfHighestFrequency(charFrequencyArray);

        int[] possibleKeys = getPossibleKeys(postionOfHighestFrequency);

        for(int number : possibleKeys) {
            System.out.println(decrypt(number));
        }
        return decrypt(possibleKeys[0]);
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

    //add position length if the current position with key is negative,
    //this wraps the position in reverse when "decrypting"
    private int setNewPosition(int position, int key, boolean toEncrypt) {
        int positionWithKey = (toEncrypt) ? position + key : position - key + ALPHABET.length;

        return (positionWithKey % ALPHABET.length);
    }

    //count how many english words are in text
    private int countEnglishWords(String message) {
        String[] messageList = message.split(" ");
        int count = 0;
        for (String str: messageList) {
            String strWithoutSymbols = str.replaceAll("[-.,\"':!?\\s]", "");
            if (ENGLISH_WORDS.contains(strWithoutSymbols.toLowerCase())) count++;
        }
        return count;
    }

    //create an array that counts the number of times an alphabet was used in the encrypted message
    private int[] getCharFrequencyArray(char[] encryptedMessageChars) {
        int[] charFrequencyArray = new int[ALPHABET.length];
        Arrays.fill(charFrequencyArray, 0);

        for(char letter : encryptedMessageChars) {
            int position = findCharPosition(letter);
            charFrequencyArray[position]++;
        }
        return charFrequencyArray;
    }

    //find the letter that has the highest occurrence in the encrypted message
    private static int getPositionOfHighestFrequency(int[] charFrequencyArray) {
        int highestFrequency = 0;
        int postionOfHighestFrequency = 0;
        for (int i = 0; i < charFrequencyArray.length; i++) {
            if (charFrequencyArray[i] > highestFrequency) {
                highestFrequency = charFrequencyArray[i];
                postionOfHighestFrequency = i;
            }
        }
        System.out.println("Highest frequency Number: " + highestFrequency
                + "\nPostion of highest frequency: " + postionOfHighestFrequency
                + "\nLetter in highest frequency: " + ALPHABET[postionOfHighestFrequency]);
        return postionOfHighestFrequency;
    }

    //Find the possible positions by subtracting the postionOfHighestFrequency to the most commonly used english letters
    private int[] getPossibleKeys(int postionOfHighestFrequency) {
        int numberOfPossibleKeys = 3;//Change this to the number of possible keys you want to output
        int[] possibleKeys = new int[numberOfPossibleKeys];
        for (int i = 0; i < numberOfPossibleKeys; i++) {
            char commonLetter = COMMON_ENGLISH_LETTERS[i];
            int commonPosition = findCharPosition(commonLetter);
            possibleKeys[i] = postionOfHighestFrequency - commonPosition;

        }
        return possibleKeys;
    }

}

