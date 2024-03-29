package practice;

import practice.collection.ListPractice;
import practice.collection.MapPractice;
import practice.collection.SetPractice;
import practice.hackathon.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PracticeMain {
    public static void main(String[] args) {
        /*ListPractice.listExample();
        SetPractice.setExample();
        MapPractice.mapExample();
        MapPractice.mapWithCustomClassExample();

        CountOccurrencesOf.allCharacters("elephant");
        CountOccurrencesOf.allCharactersWithSingleLoop("elephant");

        Reverse.word("elephant");
        String reverseSentence = Reverse.sentence("Elephant is big Animal");
        String reverseSentenceAndWord = Arrays.stream(reverseSentence
                .split(" "))
                .map(Reverse::word).collect(Collectors.joining(" "));
        System.out.println(reverseSentenceAndWord);

        Lambda.example();*/

        CountOccurrencesOfUsingStream.words("my name is rahul my rahul");
        CountOccurrencesOfUsingStream.allCharacters("elephant");

        StreamForPrimitive.example();

        Java8Stream.example();
    }

}
