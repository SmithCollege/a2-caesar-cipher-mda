// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

/**
 * Represents a CaesarCipher
 */
public class CaesarCipher {

    /** Character array to store the letters in the alphabet in order */
    Character[] alphabet;

    /** DynamicArray object providing ArrayList-like operations for Characters */
    DynamicArray<Character> cipher;

    /** Private offset that tracks how many positions to shift the index for
    * This cipher */
    private int offset;

    /** Constructor that should define the instance variables, including
     * populating the alphabet
     * @param offset Offset to use when creating `cipher` of DynamicArray type
     */
    public CaesarCipher(int offset){
        this.alphabet = new Character[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('a' + i);
        }

        this.cipher = new DynamicArray<Character>(offset, alphabet);
        this.offset = offset;
    }

    /** Returns the value stored at a given index
     * @param i index of element to read
     * @return value stored at the given index
     */
    public char get(int i) {
        return cipher.get(i);
    }

    /** Implementation of linear search that looks through the alphabet
     * array to identify the position of the passed value
     * @param val character to search for
     * @return int indicating position of val in the alphabet array
     */
    public int findIndex(char val){
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == val) {
                return i;
            }
        }
        return -1;
    }

    /** Encode a message using the cipher
     * @param T message to encode
     * @return encoded message */  
    public String encode(String message){
        String lowerMessage = message.toLowerCase();
        String encodedMessage = "";

        for (int i = 0; i < lowerMessage.length(); i++) {
            char ch = lowerMessage.charAt(i);
            int position = findIndex(ch);

            if (position == -1) {
                encodedMessage += ch;
            } else {
                int newPos = (position - offset) % 26;
                if (newPos < 0) {
                    newPos += 26;
                }
                char c = alphabet[newPos];
                encodedMessage += c;
            }
        }
        return encodedMessage;
     }

    /** Decode a message using the cipher 
     * @param String message to decode
     * @param int key to use in decoding
     * @return decoded message
    */
    public String decode(String message, int key){
        String lowerMessage = message.toLowerCase();
        String decodedMessage = "";

        key = key % 26;
        if (key < 0) {
            key += 26;
        }

        for (int i = 0; i < lowerMessage.length(); i++) {
            char ch = lowerMessage.charAt(i);
            int position = findIndex(ch);

            if (position == -1) {
                decodedMessage += ch;
            } else {
                int newPos = (position + key) % 26;
                char c = alphabet[newPos];
                decodedMessage += c;
            }
        }
        return decodedMessage; 
    }

    /**
     * Main method for command-line arguments
     * @param args array of Strings for command-line arguments
     */
    public static void main(String[] args) {
        CaesarCipher classUnderTest = new CaesarCipher(3);
        System.out.println(classUnderTest.get(17));
        System.out.println(classUnderTest.encode("tHis Ssn't very seCreT."));
    }
    
}
