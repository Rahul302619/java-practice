package algo;

public class EncryptStringExample {

    public static void main(String[] args) {
        String text = "Hello, World!";
        int shift = 3;

        String encryptedText = encrypt(text, shift);
        System.out.println("Encrypted Text: " + encryptedText);

        String decryptedText = decrypt(encryptedText, shift);
        System.out.println("Decrypted Text: " + decryptedText);

        convertIntToChar();
    }

    // Decrypts text using a shift value
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift); // Decrypting is simply encrypting with the reverse shift
    }

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char charAtPosition : text.toCharArray()) {

            // Encrypt uppercase letters
            if (Character.isUpperCase(charAtPosition)) {
                char encryptedChar = (char) (((charAtPosition - 'A' + shift) % 26) + 'A');
                result.append(encryptedChar);
            }
            // Encrypt lowercase letters
            else if (Character.isLowerCase(charAtPosition)) {
                char encryptedChar = (char) (((charAtPosition - 'a' + shift) % 26) + 'a');
                result.append(encryptedChar);
            }
            // Append the original character if it's neither uppercase nor lowercase
            else {
                result.append(charAtPosition);
            }
        }
        return result.toString();
    }

    private static void convertIntToChar() {
        for(int i=97; i<=97+25; i++) {
            System.out.println((char)i);
        }
    }

}
