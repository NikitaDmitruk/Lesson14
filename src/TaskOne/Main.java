package TaskOne;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int i;
        StringBuilder romeoAndJuliet = new StringBuilder();
        String[] words;
        try (FileReader reader = new FileReader("src/TaskOne/romeo-and-juliet.txt")) {
            while ((i = reader.read()) != -1) {
                romeoAndJuliet.append((char) i);
            }
        } catch (IOException e) {
            System.out.println("Такого файла не сущетвует!");
        }
        words = romeoAndJuliet.toString().split("\\W+");
        String theLongestWord = words[0];
        for (String word : words) {
            if (theLongestWord.length() < word.length()) {
                theLongestWord = word;
            }
        }
        System.out.println(theLongestWord);
    }
}
