package TaskOne;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstVariant {
    public static void main(String[] args) {
        int i;
        StringBuilder romeoAndJuliet = new StringBuilder();
        String theLongestWord = "";
        try (FileReader reader = new FileReader("src/TaskOne/romeo-and-juliet.txt")) {
            while ((i = reader.read()) != -1) {
                romeoAndJuliet.append((char) i);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        Matcher matcher = Pattern.compile("\\w+").matcher(romeoAndJuliet);
        while (matcher.find()) {
            if (theLongestWord.length() < matcher.group().length()) {
                theLongestWord = matcher.group();
            }
        }
        try (FileWriter writer = new FileWriter("src/TaskOne/the-longest-word.txt", true)) {
            writer.write(theLongestWord + "\n");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
