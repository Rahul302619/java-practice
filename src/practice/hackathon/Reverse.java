package practice.hackathon;

public class Reverse {
    public static String word(String word) {
        String reverseWord = "";
        for(int i = word.length() - 1; i>= 0; i--){
            reverseWord = reverseWord + word.charAt(i);
        }
        System.out.println(reverseWord);
        return reverseWord;
    }

    public static String sentence(String sentence) {
        String reverseSentence = "";
        String[] numberOfWords = sentence.split(" ");
        for(int i = numberOfWords.length - 1; i>= 0; i--){
            reverseSentence = reverseSentence + numberOfWords[i] + " ";
        }
        System.out.println(reverseSentence);
        return reverseSentence;
    }
}
