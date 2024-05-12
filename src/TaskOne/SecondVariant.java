package TaskOne;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SecondVariant {
    public static void main(String[] args) {
        int i;
        StringBuilder romeoAndJuliet = new StringBuilder();
        String[] words;
        try (FileReader reader = new FileReader("src/TaskOne/romeo-and-juliet.txt")) {
            while ((i = reader.read()) != -1) {
                romeoAndJuliet.append((char) i);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        words = romeoAndJuliet.toString().split("\\W+");
        String theLongestWord = words[0];
        for (String word : words) {
            if (theLongestWord.length() < word.length()) {
                theLongestWord = word;
            }
        }
        try (FileWriter writer = new FileWriter("src/TaskOne/the-longest-word.txt", true)) {
            writer.write(theLongestWord + "\n");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
